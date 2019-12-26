package edu.swjtuhc.cgService.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.service.articleService;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/article")
public class ArticleController{

    @Autowired
    private articleService articleService;
 
   
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/createarticle",method = RequestMethod.GET)
    public JSONObject createarticle(@RequestBody Article a) {
    	
    	JSONObject result = new JSONObject(); 
    	try {
    		int i = articleService.createarticle(a);
        	if(i==-2) {
        		result.put("state","fail");
        		result.put("msg", "该文章已存在");
        	}else if(i==-1) {
        		result.put("state","fail");
        		result.put("msg", "文章内容不能为空");
        	}else if(i==0) {
        		result.put("state","fail");
        		result.put("msg", "数据库内部错误");
        	}else if(i==1) {
        		result.put("state","success");
        		result.put("msg", "上传成功");
        	}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("state","fail");
    		result.put("msg", "服务器内部错误");
		}    	
		return result;    	
}
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/updatearticle",method = RequestMethod.POST)
    public JSONObject updatearticle(@RequestBody Article a) {
    	
    	JSONObject result = new JSONObject(); 
    	try {
    		int i = articleService.updateArticle(a);
        	if(i==-1) {
        		result.put("state","fail");
        		result.put("msg", "文章内容不能为空");
        	}else if(i==-2) {
        		result.put("state","fail");
        		result.put("msg", "文章标题不能为空");
        	}else if(i==-3) {
        		result.put("state","fail");
        		result.put("msg", "作者姓名不能为空");
        	}else if(i==0) {
        		result.put("state","fail");
        		result.put("msg", "数据库内部错误");
        	}else if(i==1) {
        		result.put("state","success");
        		result.put("msg", "修改成功");
        	}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("state","fail");
    		result.put("msg", "服务器内部错误");
		}    	
		return result;    	
}
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/deletearticle",method = RequestMethod.POST)
    public JSONObject deletearticle(@RequestBody Article a) {
    	
    	JSONObject result = new JSONObject(); 
    	try {
    		int i = articleService.deleteArticle(a);
        	if(i==-1) {
        		result.put("state","fail");
        		result.put("msg", "文章ID为空");
        	}else if(i==0) {
        		result.put("state","fail");
        		result.put("msg", "数据库内部错误");
        	}else if(i==1) {
        		result.put("state","success");
        		result.put("msg", "删除成功");
        	}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("state","fail");
    		result.put("msg", "服务器内部错误");
		}    	
		return result;    	
}
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/getAllarticle",method = RequestMethod.GET)
    public List<Article> getAllList() {
    	
		return articleService.getAllArticlesList();    	
}
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/getarticle",method = RequestMethod.GET)
    public List<Article> getList() {
    	
		return articleService.getArticlesList();    	
}
    }
