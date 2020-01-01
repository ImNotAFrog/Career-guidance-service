package edu.swjtuhc.cgService.model;

import java.util.Date;

public class TeacherTime {
	private Long tId;
	private Long uId;
	private Long sId;
	private String freeTop;
	private String freeDown;
	private String timeName;
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public Long getuId() {
		return uId;
	}
	public void setuId(Long uId) {
		this.uId = uId;
	}
	public Long getsId() {
		return sId;
	}
	public void setsId(Long sId) {
		this.sId = sId;
	}
	

	
	
	public String getTimeName() {
		return timeName;
	}
	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}
	public String getFreeTop() {
		return freeTop;
	}
	public void setFreeTop(String freeTop) {
		this.freeTop = freeTop;
	}
	public String getFreeDown() {
		return freeDown;
	}
	public void setFreeDown(String freeDown) {
		this.freeDown = freeDown;
	}
	@Override
	public String toString() {
		return "TeacherTime [tId=" + tId + ", uId=" + uId + ", sId=" + sId + ", freeTop=" + freeTop + ", freeDown="
				+ freeDown + ", timeName=" + timeName + "]";
	}
	
	
}
