package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.BbsService;

@RestController
public class BbsController {
	
	
	@Autowired
	BbsService service;
	
	
	@RequestMapping(value = "/bbsList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<BbsDto> bbsList(BbsParam param, HttpSession session) {
		System.out.println("BbsController bbsList()" + new Date());
		return service.bbsPagingList(param);
	}
	
	@RequestMapping(value = "/bbsCount", method = {RequestMethod.GET, RequestMethod.POST})
	public int bbsCount(BbsParam param) {
		System.out.println("BbsController bbsCount()" + new Date());
		
		return service.allBbs(param);
	}
	
	@RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(BbsDto dto) {
		System.out.println("BbsController write()" + new Date());
		
		return service.write(dto)>0?"suc":"err";
	}
	
	
	@RequestMapping(value = "/detail", method = {RequestMethod.GET, RequestMethod.POST})
	public BbsDto detail(int seq) {
		System.out.println("BbsController detail()" + new Date());
		
		return service.detail(seq);
	}
	
	
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(int seq) {
		System.out.println("BbsController delete()" + new Date());
		
		return service.delete(seq)>0?"suc":"err";
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public String update(BbsDto dto) {
		System.out.println("BbsController update()" + new Date());
		return service.update(dto)>0?"suc":"err";
	}
	
	
	@RequestMapping(value = "/answer", method = {RequestMethod.GET, RequestMethod.POST})
	public String answer(BbsDto dto) {
		System.out.println("BbsController answer()" + new Date());
		return service.answer(dto.getSeq(), dto)?"suc":"err";
	}
	
	
	
	
}
