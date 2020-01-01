package edu.swjtuhc.cgService.serviceImpl;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swjtuhc.cgService.mapper.articleMapper;
import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.service.articleService;
import edu.swjtuhc.cgService.util.IdWorker;
import edu.swjtuhc.cgService.util.JwtTokenUtil;


@Service
public class articleServiceImpl implements articleService {
    private articleMapper articleMapper;
    private IdWorker idWorker;
    @Autowired
    public articleServiceImpl(
            JwtTokenUtil jwtTokenUtil,
            articleMapper articleMapper) {
        this.articleMapper = articleMapper;
        this.idWorker=new IdWorker(0, 0);
    }


	@Override
	public Long getNextId() {
		// TODO Auto-generated method stub
		return idWorker.nextId();
	}

	@Override
	public int createarticle(Article a) {
		// TODO Auto-generated method stub
		Article u = articleMapper.getArticle(a.getArticle());
		if(u!=null&&u.getaId()!=null&&u.getaId()>0) {
			return -2;
		}else if(a.getArticle()==null||a.getArticle().length()<1){
			return -1;
		}else {
			a.setapublishDate(new Date());
			a.setaId(getNextId());
		}	
		return articleMapper.createArticle(a);
	}


	@Override
	public int updateArticle(Article a) {
		// TODO Auto-generated method stub
		articleMapper.getArticle(a.getArticle());
		if(a.getArticle()==null||a.getArticle().length()<1) {
			return -1;
		}else if(a.getAname()==null||a.getAname().length()<1){
			return -2;
		}else if(a.getauploader()==null||a.getauploader().length()<1){
			return -3;
		}else{
			a.setapublishDate(new Date());
		}	
		return articleMapper.updateArticle(a);
	}


	@Override
	public int deleteArticle(Article a) {
		// TODO Auto-generated method stub
		if(a.getaId()==null) {
			return -1;
		}else{
			return articleMapper.deleteArticle(a);
		}
		
	}


	@Override
	public List<Article> getAllArticlesList() {
		// TODO Auto-generated method stub
		return articleMapper.selectAllArticle();
	}


	@Override
	public List<Article> getArticlesList() {
		// TODO Auto-generated method stub
		return articleMapper.selectArticle();
	}



    
}

