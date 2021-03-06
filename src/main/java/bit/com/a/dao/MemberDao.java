package bit.com.a.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {
	
	public String idCheck(String id);
	public int addMember(MemberDto dto);
	public MemberDto login(MemberDto dto);
	

}
