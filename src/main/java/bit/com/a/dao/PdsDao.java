package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.PdsDto;

@Mapper
@Repository
public interface PdsDao {
	
	public List<PdsDto> getPdsList();
	
	public int uploadPds(PdsDto dto);
	
	public String getFilename(String filename);
	
	public int readCount(int seq);
	
	public int downloadCount(int seq);
	
	public PdsDto getDetail(int seq);
	
	public int delete(int seq);
	
	public int update(PdsDto dto);
	
	
}
