package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Mapper
@Repository
public interface BbsDao {
	
	public List<BbsDto> bbsPagingList(BbsParam param);
	
	public int allBbs(BbsParam param);
	
	public int write(BbsDto dto);
	
	public BbsDto detail(int seq);
	
	public int delete(int seq);
	
	public int update(BbsDto dto);
	
	public int answerUpdate(int seq);
	public int answerInsert(BbsDto dto);
	
}
