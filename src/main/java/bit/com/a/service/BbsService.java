package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Service
@Transactional
public class BbsService {

	
	@Autowired
	BbsDao dao;
	
	public List<BbsDto> bbsPagingList(BbsParam param) {
		return dao.bbsPagingList(param); 
	}
	
	
	public int allBbs(BbsParam param) {
		return dao.allBbs(param);
	}
	
	public int write(BbsDto dto) {
		return dao.write(dto);
	}
	
	public BbsDto detail(int seq) {
		return dao.detail(seq);
	}
	
	public int delete(int seq) {
		return dao.delete(seq);
	}
	
	public int update(BbsDto dto) {
		return dao.update(dto);
	}
	
	public boolean answer(int seq, BbsDto dto) {
		int a = dao.answerUpdate(seq);
		int b = dao.answerInsert(dto);
		
		return a+b>1?true:false;
	}
	
	
}
