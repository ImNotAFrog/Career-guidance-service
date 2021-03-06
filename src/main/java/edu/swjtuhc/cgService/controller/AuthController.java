package edu.swjtuhc.cgService.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.swjtuhc.cgService.mapper.UserMapper;
import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.model.JwtAuthenticationRequest;
import edu.swjtuhc.cgService.model.JwtAuthenticationResponse;
import edu.swjtuhc.cgService.model.SysUser;
import edu.swjtuhc.cgService.service.AuthService;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/auth")
public class AuthController{
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;
 
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest)
    {
    	JSONObject result = new JSONObject();
    	try {                                                                                                                                                                                                                                                                            
    		final String token = authService.login(authenticationRequest.getAccount(), authenticationRequest.getPassword());
    		JwtAuthenticationResponse jwt = new JwtAuthenticationResponse(token);
    		result.put("state", "success");
    		result.put("token", jwt.getToken());
    	} catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
    		result.put("state", "fail");
    		result.put("msg", "用户名或密码错误");
		}
        
        
        // Return the token
        return result;
    }

    
    @RequestMapping(value = "/register",method=RequestMethod.POST)
    @ResponseBody
    public JSONObject register(@RequestBody SysUser user) {
    	
    	JSONObject result = new JSONObject(); 
    	try {
    		int i = authService.create(user);
        	if(i==-3) {
        		result.put("state","fail");
        		result.put("msg", "密码不能为空");
        	}else if(i==-2) {
        		result.put("state","fail");
        		result.put("msg", "角色不能为空");
        	}else if(i==-1) {
        		result.put("state","fail");
        		result.put("msg", "账号已存在");
        	}else if(i==0) {
        		result.put("state","fail");
        		result.put("msg", "数据库内部错误");
        	}else if(i==1) {
        		result.put("state","success");
        		result.put("msg", "注册成功");
        	}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("state","fail");
    		result.put("msg", "服务器内部错误");
		}    	
		return result;    	
    }
    
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    @RequestMapping(value="/getAllUsers",method = RequestMethod.GET)    
    public String getAll() {
    	return "success";
    }
	    @RequestMapping(value = "/changepassword",method=RequestMethod.POST)
	    @ResponseBody
	    public JSONObject changepassword(@RequestBody SysUser user) {
	    	
	    	JSONObject result = new JSONObject(); 
	    	try {
	    		int i = authService.changepassword(user);
	        	if(i==-1) {
	        		result.put("state","fail");
	        		result.put("msg", "账号不能为空");
	        	}else if(i==-2) {
	        		result.put("state","fail");
	        		result.put("msg", "旧密码不能为空");
	        	}else if(i==-3) {
	        		result.put("state","fail");
	        		result.put("msg", "账号错误");
	        	}else if(i==-4) {
	        		result.put("state","fail");
	        		result.put("msg", "旧密码错误");
	        		}
	        		else if(i==-6) {
	        		result.put("state","fail");
	        		result.put("msg", "新密码不能为空");
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
	    @RequestMapping(value="/deleteuser",method = RequestMethod.POST)
	    public JSONObject deleteuser(@RequestBody SysUser a) {
	    	
	    	JSONObject result = new JSONObject(); 
	    	try {
	    		int i = authService.deleteUser(a);
	        	if(i==-1) {
	        		result.put("state","fail");
	        		result.put("msg", "用户ID为空");
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
	    @RequestMapping(value="/getAlluser",method = RequestMethod.GET)
	    public List<SysUser> getAllList(SysUser sysuser) {
	    	System.out.println(sysuser);
			return authService.getAllUserList();    	
	}  
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    @RequestMapping(value="/getuser",method = RequestMethod.GET)
	    public List<SysUser> getList() {
	    	
			return authService.getUserList();    	
	}
}
