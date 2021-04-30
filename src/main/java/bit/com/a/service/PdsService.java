package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.PdsDao;
import bit.com.a.dto.PdsDto;

@Service
@Transactional
public class PdsService {
	
	@Autowired
	PdsDao dao;

	public List<PdsDto> getPdsList() {
		return dao.getPdsList();
	}
	
	public int uploadPds(PdsDto dto) {
		return dao.uploadPds(dto);
	}
	
	public String getFilename(String filename) {
		return dao.getFilename(filename);
	}
	
	public int readCount(int seq) {
		return dao.readCount(seq);
	}
	
	public int downloadCount(int seq) {
		return dao.downloadCount(seq);
	}
	
	public PdsDto getDetail(int seq) {
		return dao.getDetail(seq);
	}
	
	public int delete(int seq) {
		return dao.delete(seq);
	}
	
	public int update(PdsDto dto) {
		return dao.update(dto);
	}
	
}
