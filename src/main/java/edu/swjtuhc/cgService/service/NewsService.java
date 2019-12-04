package edu.swjtuhc.cgService.service;

import edu.swjtuhc.cgService.model.News;

public interface NewsService {
	int createNews(News n);
	int updateNews(News n);
    Long getNextId();    
}
