package edu.swjtuhc.cgService.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.model.SysUser;

@Mapper
public interface UserMapper {
	SysUser getUserByAccount(String account);
	SysUser getUserByPassword(String password);
	Integer createUser(SysUser sysUser);	
	Integer changePassword(SysUser sysUser);
	Integer updateUser(SysUser sysUser);
	Integer deleteUser(SysUser sysUser);
	public List<SysUser> selectUser();
	public List<SysUser> selectUserById();
}
