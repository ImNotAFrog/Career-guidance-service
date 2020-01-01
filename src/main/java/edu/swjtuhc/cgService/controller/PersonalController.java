package edu.swjtuhc.cgService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.swjtuhc.cgService.model.Personal;
import edu.swjtuhc.cgService.service.PersonalService;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/personal")
public class PersonalController {
	@Autowired
	private PersonalService personalService;
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public JSONObject create(@RequestBody Personal n) {
		JSONObject result = new JSONObject();
		try {
			int i = personalService.createPersonal(n);
			if (i==0) {
				result.put("state","fail");
        		result.put("msg", "内部错误");
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
	public JSONObject update(@RequestBody Personal n) {
		JSONObject result = new JSONObject();
		try {
			int i = personalService.updatePersonal(n);
			if (i==-1) {
				result.put("state","fail");
        		result.put("msg", "pid不能为空");
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
	public JSONObject delete(@RequestBody Personal n) {
		JSONObject result = new JSONObject();
		try {
			int i = personalService.deletePersonal(n);
			if (i==-1) {
				result.put("state","fail");
        		result.put("msg", "pid不能为空");
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
	@RequestMapping(value = "/get" ,method = RequestMethod.GET)
	public List<Personal> getList(){
		return personalService.getPersonalList();
	}
	@RequestMapping(value = "/getAll" ,method = RequestMethod.GET)
	public List<Personal> getList2(){
		return personalService.getAllPersonalList();
	}
}
