package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.PdsDto;
import bit.com.a.service.PdsService;

@RestController
public class PdsController {
	
	@Autowired
	PdsService service;
	
	
	@RequestMapping(value = "/getPdsList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<PdsDto> getPdsList() {
		System.out.println("PdsController getPdsList()" + new Date());
		
		return service.getPdsList();
	}
	
	@RequestMapping(value = "/uploadPds", method = {RequestMethod.GET, RequestMethod.POST})
	public String uploadPds(PdsDto dto) {
		System.out.println("PdsController uploadPds()" + new Date());
		
		return service.uploadPds(dto)>0?"suc":"err";
	}
	
	@RequestMapping(value = "/getFilename", method = {RequestMethod.GET, RequestMethod.POST})
	public String getFilename(String filename) {
		System.out.println("PdsController getFilename()" + new Date());
		
		return service.getFilename(filename);
	}
	
	
	@RequestMapping(value = "/downloadCountPds", method = {RequestMethod.GET, RequestMethod.POST})
	public String downloadCount(PdsDto dto) {
		System.out.println("PdsController downloadCount()" + new Date());
		
		return service.downloadCount(dto.getSeq())>0?"suc":"err";
	}
	
	@RequestMapping(value = "/getPdsDetail", method = {RequestMethod.GET, RequestMethod.POST})
	public PdsDto getDetail(PdsDto dto) {
		System.out.println("PdsController getDetail()" + new Date());
		service.readCount(dto.getSeq());
		return service.getDetail(dto.getSeq());
	}
	
	
	@RequestMapping(value = "/deletePds", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(PdsDto dto) {
		System.out.println("PdsController delete()" + new Date());
		
		return service.delete(dto.getSeq())>0?"suc":"err";
	}
	
	
	@RequestMapping(value = "/updatePds", method = {RequestMethod.GET, RequestMethod.POST})
	public String update(PdsDto dto) {
		System.out.println("PdsController update()" + new Date());
		
		return service.update(dto)>0?"suc":"err";
	}
	
	
}
