package edu.swjtuhc.cgService.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.cgService.model.SysUser;

@Mapper
public interface UserMapper {
	SysUser getUserByAccount(String account);
	Integer createUser(SysUser sysUser);	
	Integer changePassword(String account, String password);
	Integer updateUser(SysUser sysUser);
	Integer deleteUser(Long uId);
	SysUser getUserById(Long uId);	
}
