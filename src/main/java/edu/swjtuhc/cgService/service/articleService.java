package edu.swjtuhc.cgService.service;

import java.util.List;

import edu.swjtuhc.cgService.model.Article;

public interface articleService {
	int createarticle(Article a);
	int updateArticle(Article a);
	int deleteArticle(Article a);
	public List<Article> getAllArticlesList();
	public List<Article> getArticlesList();
    Long getNextId();
}
