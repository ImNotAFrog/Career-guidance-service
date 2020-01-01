package edu.swjtuhc.cgService.service;


import java.util.List;


import edu.swjtuhc.cgService.model.SysUser;

public interface AuthService {
	int create(SysUser user);
	int changepassword(SysUser user);
	int deleteUser(SysUser a);
    String login(String username, String password);
    String refresh(String oldToken);
    void logout();
    Long getNextId();
    boolean verifyPassword(String account, String password);
    public List<SysUser> getAllUserList();
	public List<SysUser> getUserList();
}
