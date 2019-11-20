package edu.swjtuhc.cgService.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SysUser{
	
	private Long uId;
	private String account;
	private String password;
	private List<String> roles;
	private Date lastPasswordResetDate=new Date();
	public SysUser() {
		
	}

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}
	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	@Override
	public String toString() {
		return "SysUser [uId=" + uId + ", account=" + account + ", password=" + password + ", roles=" + roles
				+ ", lastPasswordResetDate=" + lastPasswordResetDate + "]";
	}

	
}
