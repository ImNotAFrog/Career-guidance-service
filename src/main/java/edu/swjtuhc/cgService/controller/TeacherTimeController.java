package edu.swjtuhc.cgService.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.model.TeacherTime;
import edu.swjtuhc.cgService.service.TeacherTimeService;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/teachertime")
public class TeacherTimeController{

    @Autowired
    private TeacherTimeService TeacherTimeService;
 
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/createtime",method = RequestMethod.GET)
    public JSONObject createtime(@RequestBody TeacherTime t) {
    	
    	JSONObject result = new JSONObject(); 
    	try {
    		int i = TeacherTimeService.createtime(t);
        	if(i==-1) {
        		result.put("state","fail");
        		result.put("msg", "星期几不能为空");
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
   
    }
