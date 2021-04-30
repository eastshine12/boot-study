package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.SummerDto;
import bit.com.a.dto.SummerParam;

@Mapper
@Repository
public interface SummerDao {
	
	public List<SummerDto> summerList(SummerParam param);
	
	public int writeSummer(SummerDto dto);
	
	public SummerDto detailSummer(int seq);
	
	public int deleteSummer(int seq);
	
	public int updateSummer(SummerDto dto);
	
}
