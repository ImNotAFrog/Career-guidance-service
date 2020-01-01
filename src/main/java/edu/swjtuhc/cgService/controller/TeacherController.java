package edu.swjtuhc.cgService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.swjtuhc.cgService.model.Teacher;
import edu.swjtuhc.cgService.service.TeacherService;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/create",method=RequestMethod.GET)
	public JSONObject create(@RequestBody Teacher n) {
		JSONObject result = new JSONObject();
		try {
			int i = teacherService.createTeacher(n);
			if (i==0) {
				result.put("state", "fail");
				result.put("msg", "内部错误");
			}else if(i==-1) {
        		result.put("state","success");
        		result.put("msg", "老师名字不能为空");
        	}else if(i==-2) {
        		result.put("state","success");
        		result.put("msg", "老师专业不能为空");
        	}else if(i==-3) {
        		result.put("state","success");
        		result.put("msg", "老师简介不能为空");
        	}else if(i==-4) {
        		result.put("state","success");
        		result.put("msg", "老师电话不能为空");
        	}else if(i==1) {
        		result.put("state","success");
        		result.put("msg", "编辑成功");
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("state","fail");
			result.put("msg", "服务器内部错误");
		}
		return result;
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public JSONObject update(@RequestBody Teacher n) {
		JSONObject result = new JSONObject();
		try {
			int i = teacherService.updateTeacher(n);
			if (i==-1) {
				result.put("state","fail");
        		result.put("msg", "ID不能为空");
			}else if(i==-2) {
        		result.put("state","success");
        		result.put("msg", "老师名字不能为空");
        	}else if(i==-3) {
        		result.put("state","success");
        		result.put("msg", "老师专业不能为空");
        	}else if(i==-4) {
        		result.put("state","success");
        		result.put("msg", "老师简介不能为空");
        	}else if(i==-5) {
        		result.put("state","success");
        		result.put("msg", "老师电话不能为空");
        	}else if(i==0) {
        		result.put("state","success");
        		result.put("msg", "内部错误");
        	}else if(i==1) {
        		result.put("state","success");
        		result.put("msg", "修改成功");
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("state","fail");
    		result.put("msg", "服务器内部错误");
		}
		return result;
	}
	@RequestMapping(value = "/delete" ,method = RequestMethod.POST)
	public JSONObject delete(@RequestBody Teacher n) {
		JSONObject result = new JSONObject();
		try {
			int i = teacherService.deleteTeacher(n);
			if (i==-1) {
				result.put("state","fail");
        		result.put("msg", "t_center_id不能为空");
			}else if(i==0) {
        		result.put("state","success");
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
	@RequestMapping(value = "/getteacher" ,method = RequestMethod.GET)
	public List<Teacher> getList(){
		return teacherService.getTeacherList();
	}
	@RequestMapping(value = "/getAllteacher" ,method = RequestMethod.GET)
	public List<Teacher> getList2(){
		return teacherService.getAllTeacherList();
	}
}

