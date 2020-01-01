package edu.swjtuhc.cgService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.swjtuhc.cgService.model.News;
import edu.swjtuhc.cgService.service.NewsService;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private NewsService newsService;
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public JSONObject create(@RequestBody News n) {
		JSONObject result = new JSONObject(); 
		try {
			int i = newsService.createNews(n);
			 if(i==-1) {
        		result.put("state","fail");
        		result.put("msg", "链接不能为空");
        	}else if(i==-2) {
        		result.put("state","fail");
        		result.put("msg", "标题不能为空");
        	}else if(i==-3) {
        		result.put("state","fail");
        		result.put("msg", "图片路径不能为空");
        	}else if(i==-4) {
        		result.put("state","fail");
        		result.put("msg", "链接已存在");
        	}else if(i==-5) {
        		result.put("state","fail");
        		result.put("msg", "标题已存在");
        	}else if(i==0) {
        		result.put("state","fail");
        		result.put("msg", "内部错误");
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
	@RequestMapping(value="/update",method=RequestMethod.POST)
		public JSONObject update(@RequestBody News n) {
			JSONObject result = new JSONObject(); 
			try {
				int i = newsService.updateNews(n);
				 if(i==-1) {
	        		result.put("state","fail");
	        		result.put("msg", "标题不能为空");
	        	}else if(i==-2) {
	        		result.put("state","fail");
	        		result.put("msg", "图片路径不能为空");
	        	}else if(i==-3) {
	        		result.put("state","fail");
	        		result.put("msg", "标题已存在");
	        	}else if(i==0) {
	        		result.put("state","fail");
	        		result.put("msg", "内部错误");
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
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public JSONObject delete(@RequestBody News n) {
		JSONObject result = new JSONObject(); 
		try {
			int i = newsService.deleteNews(n);
			 if(i==-1) {
        		result.put("state","fail");
        		result.put("msg", "编号不能为空");
        	}else if(i==0) {
        		result.put("state","fail");
        		result.put("msg", "内部错误");
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
	@RequestMapping(value="/getnews",method=RequestMethod.GET)
	public List<News> getList(){
		return newsService.getNewsList();
	}
	@RequestMapping(value="/getAllnews",method=RequestMethod.GET)
	public List<News> getList2(){
		return newsService.getAllNewsList();
	}

}
