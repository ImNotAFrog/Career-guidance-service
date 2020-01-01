package edu.swjtuhc.cgService.model;

public class Personal {
	private Long pId;
	private String uName;
	private String uSex;
	private String uPhone;
	private String uWeixin;
	private String uEmail;
	private String uMajor;
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuSex() {
		return uSex;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getuWeixin() {
		return uWeixin;
	}
	public void setuWeixin(String uWeixin) {
		this.uWeixin = uWeixin;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuMajor() {
		return uMajor;
	}
	public void setuMajor(String uMajor) {
		this.uMajor = uMajor;
	}
	@Override
	public String toString() {
		return "Personal [pId=" + pId + ", uName=" + uName + ", uSex=" + uSex + ", uPhone=" + uPhone + ", uWeixin="
				+ uWeixin + ", uEmail=" + uEmail + ", uMajor=" + uMajor + "]";
	}
	
}
