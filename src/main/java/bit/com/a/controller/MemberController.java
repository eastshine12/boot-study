package bit.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@RestController
public class MemberController {
	
	
	@Autowired
	MemberService service;
	

	
	@RequestMapping(value = "/idCheck", method = {RequestMethod.GET, RequestMethod.POST})
	public String idCheck(MemberDto dto, HttpServletRequest req) {
		System.out.println("MemberController idCheck()" + new Date());
		
		return service.idcheck(dto.getId())==null?"suc":"err";
	}
	
	
	@RequestMapping(value = "/regi", method = {RequestMethod.GET, RequestMethod.POST})
	public String regi(MemberDto dto, HttpServletRequest req) {
		System.out.println("MemberController regi()" + new Date());
		//System.out.println(dto.toString());
		return service.addMember(dto)>0?"suc":"err";
	}
	
	
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(MemberDto dto, HttpSession session) {
		System.out.println("MemberController login()" + new Date());
		
		return service.login(dto).getId();
	}
	
	
	
	@RequestMapping(value = "/sessionId", method = {RequestMethod.GET, RequestMethod.POST})
	public String sessionId(HttpServletRequest req) {
		System.out.println("MemberController sessionId()" + new Date());
		MemberDto dto = (MemberDto)req.getSession().getAttribute("login");
		System.out.println(dto.toString());
		return dto.getId();
	}
	
	
	
}
