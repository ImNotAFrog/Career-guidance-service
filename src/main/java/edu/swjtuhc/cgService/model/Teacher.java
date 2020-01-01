package edu.swjtuhc.cgService.model;


public class Teacher {
	private Long tCenterId;
	private String tName;
	private String tSex;
	private String tMajor;
	private String tSynopsis;
	private String tPhone;
	public Long gettCenterId() {
		return tCenterId;
	}
	public void settCenterId(Long tCenterId) {
		this.tCenterId = tCenterId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettSex() {
		return tSex;
	}
	public void settSex(String tSex) {
		this.tSex = tSex;
	}
	public String gettMajor() {
		return tMajor;
	}
	public void settMajor(String tMajor) {
		this.tMajor = tMajor;
	}
	public String gettSynopsis() {
		return tSynopsis;
	}
	public void settSynopsis(String tSynopsis) {
		this.tSynopsis = tSynopsis;
	}
	
	public String gettPhone() {
		return tPhone;
	}
	public void settPhone(String tPhone) {
		this.tPhone = tPhone;
	}
	@Override
	public String toString() {
		return "Teacher [tCenterId=" + tCenterId + ", tName=" + tName + ", tSex=" + tSex + ", tMajor=" + tMajor
				+ ", tSynopsis=" + tSynopsis + ", tPhone=" + tPhone + "]";
	}

	
	
}
