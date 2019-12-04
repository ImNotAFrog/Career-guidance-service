package edu.swjtuhc.cgService.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.cgService.model.News;
@Mapper
public interface NewsMapper {
	News getNewsByUrl(String  Url);
	News getNewsByName(String  name);
//	News getNewsById(Long  Id);

	Integer createNews(News News);	
	Integer updateNews(News News);	

//	Integer changenName(String nName, String nUrl);
//	Integer deleteNew(Long nId);
//	New getNewByName(String nName);
}
