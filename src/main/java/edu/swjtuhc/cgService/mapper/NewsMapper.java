package edu.swjtuhc.cgService.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import edu.swjtuhc.cgService.model.News;
@Mapper
public interface NewsMapper {
	News getNewsByUrl(String  Url);
	News getNewsByName(String  Name);
	News getNewsBynPicturePath(String PicturePath);
	Integer createNews(News News);	
	Integer updateNews(News News);	
	Integer deleteNews(News News);	
	public List<News> getNews();
	public List<News> getAllNews();
}
