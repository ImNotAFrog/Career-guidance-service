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
    		int i = TeacherTimeService.createTime(t);
        	if(i==-1) {
        		result.put("state","fail");
        		result.put("msg", "时间不能为空");
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
    @RequestMapping(value="/updatetime",method = RequestMethod.POST)
    public JSONObject updatetime(@RequestBody TeacherTime t) {
    	
    	JSONObject result = new JSONObject(); 
    	try {
    		int i = TeacherTimeService.updateTime(t);
        	if(i==0) {
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
		return result;    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/deletetime",method = RequestMethod.POST)
    public JSONObject deletetime(@RequestBody TeacherTime t) {
    	
    	JSONObject result = new JSONObject(); 
    	try {
    		int i = TeacherTimeService.deleteTime(t);
        	 if(i==0) {
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
} @PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value="/gettime",method = RequestMethod.GET)
public List<TeacherTime> getTimeList() {
	
	return TeacherTimeService.getTimeList();    	
}
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value="/getname",method = RequestMethod.GET)
public List<TeacherTime> getNameList() {
	
	return TeacherTimeService.getNameList();    	
}
    }
