package edu.swjtuhc.cgService.controller;




import java.util.List;

import org.apache.ibatis.javassist.bytecode.analysis.MultiArrayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.model.NewsJpg;
import edu.swjtuhc.cgService.model.TeacherTime;
import edu.swjtuhc.cgService.service.NewsJpgService;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/newsjpg")
public class NewsJpgController{

    @Autowired
    private NewsJpgService NewsJpgService;
 
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/createjpg")
    public JSONObject createjpg(NewsJpg newsJpg,MultipartFile file) {
    	JSONObject result = new JSONObject(); 
    	newsJpg.setPoster(file.getOriginalFilename());
    	int i =0;
    	try {
			i = NewsJpgService.createJpg(newsJpg, file.getInputStream());
			if (i==-1) {
				result.put("state","fail");
        		result.put("msg", "路径不存在");
			}else if(i==0) {
        		result.put("state","fail");
        		result.put("msg", "数据库内部错误");
        	}else if(i==-2){
				result.put("state","fail");
        		result.put("msg", "服务器内部错误");
			}else if(i==-3){
				result.put("state","fail");
        		result.put("msg", "没有传此文件");
			}else if(i==1){
				result.put("state","success");
        		result.put("msg", "上传成功");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("state","fail");
    		result.put("msg", "服务器内部错误");
		}
    	
		return result;    	
}

    }
