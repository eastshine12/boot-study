package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.SummerDto;
import bit.com.a.dto.SummerParam;
import bit.com.a.service.SummerService;

@RestController
public class SummerController {
	
	
	@Autowired
	SummerService service;
	
	
	@RequestMapping(value = "/summerList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<SummerDto> summerList(SummerParam param, HttpSession session) {
		System.out.println("SummerController summerList()" + new Date());
		return service.summerList(param);
	}
	

	@RequestMapping(value = "/writeSummer", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeSummer(SummerDto dto) {
		System.out.println("SummerController writeSummer()" + new Date());
		
		return service.writeSummer(dto)>0?"suc":"err";
	}
	
	
	@RequestMapping(value = "/detailSummer", method = {RequestMethod.GET, RequestMethod.POST})
	public SummerDto detailSummer(int seq) {
		System.out.println("SummerController detailSummer()" + new Date());
		
		return service.detailSummer(seq);
	}
	
	
	@RequestMapping(value = "/deleteSummer", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteSummer(int seq) {
		System.out.println("SummerController deleteSummer()" + new Date());
		
		return service.deleteSummer(seq)>0?"suc":"err";
	}
	
	@RequestMapping(value = "/updateSummer", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateSummer(SummerDto dto) {
		System.out.println("SummerController updateSummer()" + new Date());
		return service.updateSummer(dto)>0?"suc":"err";
	}
	
	
	
}
