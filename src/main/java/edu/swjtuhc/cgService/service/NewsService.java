package edu.swjtuhc.cgService.service;

import java.util.List;

import edu.swjtuhc.cgService.model.News;

public interface NewsService {
	int createNews(News n);
	int updateNews(News n);
	int deleteNews(News n);
    Long getNextId();    
    public List<News> getNewsList();
    public List<News> getAllNewsList();
}
