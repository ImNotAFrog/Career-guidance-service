package edu.swjtuhc.cgService.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.model.SysUser;

@Mapper
public interface articleMapper {
	Article getArticle(String article);
	Integer createArticle(Article Article);	
	Integer updateArticle(Article Article);
	Integer deleteArticle(Article Article);
	public List<Article> selectAllArticle();
	public List<Article> selectArticle();
	}
