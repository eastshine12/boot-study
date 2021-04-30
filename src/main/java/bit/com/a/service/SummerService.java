package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.SummerDao;
import bit.com.a.dto.SummerDto;
import bit.com.a.dto.SummerParam;

@Service
@Transactional
public class SummerService {

	
	@Autowired
	SummerDao dao;
	
	public List<SummerDto> summerList(SummerParam param) {
		return dao.summerList(param); 
	}
	
	
	public int writeSummer(SummerDto dto) {
		return dao.writeSummer(dto);
	}
	
	public SummerDto detailSummer(int seq) {
		return dao.detailSummer(seq);
	}
	
	public int deleteSummer(int seq) {
		return dao.deleteSummer(seq);
	}
	
	public int updateSummer(SummerDto dto) {
		return dao.updateSummer(dto);
	}
	

	
}
