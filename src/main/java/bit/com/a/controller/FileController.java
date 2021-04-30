package bit.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.MediaTypeUtiles;
import bit.com.a.dto.PdsDto;
import bit.com.a.service.PdsService;
import util.PdsUtil;

@RestController
public class FileController {

	@Autowired
	PdsService service;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = "/fileUpload", method= RequestMethod.POST)
	public String fileUpload(@RequestParam("uploadFile")MultipartFile uploadFile, PdsDto pds, HttpServletRequest req) {
		
		System.out.println("FileController fileUpload");
		
		
		/* 경로	src/main/webapp/upload 폴더를 생성할 것 */
		String uploadPath = req.getServletContext().getRealPath("/upload");
		//String uploadPath = "d:\\tmp";
		
		
		String filename = uploadFile.getOriginalFilename();
		
		String newFilename = PdsUtil.getNewFileName(filename);
		String filepath = uploadPath + File.separator + newFilename;
		/* = '/' */
		System.out.println("filepath :" + filepath);
		pds.setFilename(filename);
		pds.setNewFilename(newFilename);
		
		System.out.println("dto 들어오나 : "+pds.toString());
		
		
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			os.write(uploadFile.getBytes());
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "file upload fail";
		}
		
		return service.uploadPds(pds)>0?"suc":"err";
	}
	
	
	@RequestMapping(value = "/fileUpdate", method= RequestMethod.POST)
	public String fileUpdate(@RequestParam("uploadFile")MultipartFile uploadFile, PdsDto pds, HttpServletRequest req) {
		
		System.out.println("FileController fileUpdate");
		
		
		/* 경로	src/main/webapp/upload 폴더를 생성할 것 */
		String uploadPath = req.getServletContext().getRealPath("/upload");
		//String uploadPath = "d:\\tmp";
		
		if(uploadFile != null) {
			String filename = uploadFile.getOriginalFilename();
			
			String newFilename = PdsUtil.getNewFileName(filename);
			String filepath = uploadPath + File.separator + newFilename;
			/* = '/' */
			System.out.println("filepath :" + filepath);
			pds.setFilename(filename);
			pds.setNewFilename(newFilename);
			try {
				BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				os.write(uploadFile.getBytes());
				os.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "file upload fail";
			}
		}
		
		System.out.println("수정된 pds : "+pds.toString());
		
		
		
		return service.update(pds)>0?"suc":"err";
	}
	
	
	
	@RequestMapping(value = "/fileDownload")
	public ResponseEntity<InputStreamResource> download(String fileName, HttpServletRequest req) throws Exception {
		
		System.out.println("FileController download");
		
		/* 경로	src/main/webapp/upload 폴더를 생성할 것 */
		String uploadPath = req.getServletContext().getRealPath("/upload");
		//String uploadPath = "d:\\tmp";
		
		MediaType mediaType = MediaTypeUtiles.getMediaTypeForFileName(this.servletContext, fileName);
		System.out.println("fileName :"+fileName);
		System.out.println("mediaType :"+mediaType);
		
		File file = new File(uploadPath + File.separator + fileName);
		InputStreamResource is = new InputStreamResource(new FileInputStream(file));
		
		return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + service.getFilename(fileName))
	            .contentType(mediaType)
	            .contentLength(file.length())
	            .body(is);
		
		
	}
	
	
	
}
