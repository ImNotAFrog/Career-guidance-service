package edu.swjtuhc.cgService.service;

import edu.swjtuhc.cgService.model.SysUser;

public interface AuthService {
	int create(SysUser user);
    String login(String username, String password);
    String refresh(String oldToken);
    void logout();
    Long getNextId();
    boolean verifyPassword(String account, String password);
}
