package edu.swjtuhc.cgService.model;

import java.sql.Date;

public class Reservation {
	private Long rId;
	private Long uId;
	private String tName;
	private String uName;
	private String project;
	private String time;
	public Long getrId() {
		return rId;
	}
	public void setrId(Long rId) {
		this.rId = rId;
	}
	public Long getuId() {
		return uId;
	}
	public void setuId(Long uId) {
		this.uId = uId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Reservation [rId=" + rId + ", uId=" + uId + ", tName=" + tName + ", uName=" + uName + ", project="
				+ project + ", time=" + time + "]";
	}
	
	

}
