package edu.swjtuhc.cgService.serviceImpl;

import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.swjtuhc.cgService.mapper.UserMapper;
import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.model.JwtUser;
import edu.swjtuhc.cgService.model.SysUser;
import edu.swjtuhc.cgService.service.AuthService;
import edu.swjtuhc.cgService.util.IdWorker;
import edu.swjtuhc.cgService.util.JwtTokenUtil;
import edu.swjtuhc.cgService.util.JwtUserFactory;


@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private UserMapper userMapper;
    private IdWorker idWorker;
    
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userMapper = userMapper;
        this.idWorker=new IdWorker(0, 0);
    }


    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);        
        UserDetails userDetails = null;
        final SysUser user = userMapper.getUserByAccount(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
        	userDetails = JwtUserFactory.create(user);
        }
        
        final String token = jwtTokenUtil.generateToken(userDetails);

        return token;
    }

    
    @Override
	public void logout() {
		// TODO Auto-generated method stub
    	SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
	}

	@Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }

	@Override
	public Long getNextId() {
		// TODO Auto-generated method stub
		return idWorker.nextId();
	}

	@Override
	public boolean verifyPassword(String account, String password) {
		// TODO Auto-generated method stub
		UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(account, password);
	    authenticationManager.authenticate(upToken);
	    return true;
	}


	@Override
	public int create(SysUser user) {
		// TODO Auto-generated method stub
		SysUser u = userMapper.getUserByAccount(user.getAccount());
		if(u!=null&&u.getuId()!=null&&u.getuId()>0) {
			return -1;
		}else if(user.getRoles().size()<1){
			return -2;
		}else if(user.getPassword()==null||user.getPassword().length()<1){
			return -3;
		}else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			user.setLastPasswordResetDate(new Date());
			user.setuId(getNextId());
		}		
		return userMapper.createUser(user);
	}
	public int changepassword(SysUser user) {
		// TODO Auto-generated method stub
		SysUser u = userMapper.getUserByAccount(user.getAccount());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if(user.getAccount()==null||user.getAccount().length()<1) {
			return -1;
		}else if(user.getPassword()==null||user.getPassword().length()<1){
			return -2;
		}else if(user.getNewpassword()==null||user.getNewpassword().length()<1){
			return -6;
		}
		else if(u==null){
			return -3;
		}
		else if(!encoder.matches(user.getPassword(),u.getPassword())){
			return -4;
		}else {
			BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder();
			
			user.setNewpassword(encoder1.encode(user.getNewpassword()));
			user.setLastPasswordResetDate(new Date());
		}
		return userMapper.changePassword(user);
	}


	@Override
	public List<SysUser> getAllUserList() {
		// TODO Auto-generated method stub

		
		return userMapper.selectUserById();
	}


	@Override
	public List<SysUser> getUserList() {
		// TODO Auto-generated method stub
		return userMapper.selectUser();
	}


	@Override
	public int deleteUser(SysUser user) {
		// TODO Auto-generated method stub
		if(user.getuId()==null) {
			return -1;
		}else{
			return userMapper.deleteUser(user);
		}
	}





	


    
}

