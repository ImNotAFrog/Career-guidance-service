package edu.swjtuhc.cgService.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.swjtuhc.cgService.model.JwtAuthenticationRequest;
import edu.swjtuhc.cgService.model.JwtAuthenticationResponse;
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
    public String createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest){
    	JSONObject result = new JSONObject();
    	try {
    		final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
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
        return result.toString();
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException{
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }

    
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public void logout(HttpServletRequest request) throws AuthenticationException{
        
    	authService.logout();
    }
}
