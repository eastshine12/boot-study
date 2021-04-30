package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	
	public String idcheck(String id) {
		return dao.idCheck(id);
	}
	
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}
	
	public int addMember(MemberDto dto) {
		return dao.addMember(dto);
	}
	
	
}
