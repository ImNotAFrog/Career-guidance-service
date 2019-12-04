package edu.swjtuhc.cgService.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.swjtuhc.cgService.mapper.NewsMapper;
import edu.swjtuhc.cgService.model.News;
import edu.swjtuhc.cgService.service.NewsService;
import edu.swjtuhc.cgService.util.IdWorker;


@Service
public class NewsServiceImpl implements NewsService {
  
    private NewsMapper newsMapper;
    private IdWorker idWorker;
    
    @Autowired
    public NewsServiceImpl(
            NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
        this.idWorker= IdWorker.getInstance();
    }
    


	@Override
	public Long getNextId() {
		// TODO Auto-generated method stub
		return idWorker.nextId();
	}

	@Override
	public int createNews(News n) {
		// TODO Auto-generated method stub
		News u = newsMapper.getNewsByUrl(n.getnUrl());
		News u1 = newsMapper.getNewsByName(n.getnName());

		if(n.getnUrl().length()<1) {
			return -1;
		}else if (n.getnName().length()<1) {
			return -2;
		}else if(u!=null&&n.getnUrl().length()>0){
			return -3;
		}else if(u1!=null&&n.getnName().length()>0){
			return -4;
		}
		else {
			n.setnId(getNextId());
		}		
		return newsMapper.createNews(n);
	}
    
	@Override
	public int updateNews(News n) {
		// TODO Auto-generated method stub
//		News u = newsMapper.getNewsByUrl(n.getnUrl());
		News u = newsMapper.getNewsByName(n.getnName());

		if(n.getnName().length()<1) {
			return -1;
		}else if (u!=null&&n.getnId()!=null&&n.getnId()>0) {
			return -2;
		}
		else {
			return newsMapper.updateNews(n);
		}
				
		
	}
}

