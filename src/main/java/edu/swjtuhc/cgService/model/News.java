package edu.swjtuhc.cgService.model;

public class News {
	private Long nId;
	private String nName;
	private String nUrl;
	private String nPicturePath;
	public Long getnId() {
		return nId;
	}
	public void setnId(Long nId) {
		this.nId = nId;
	}
	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}
	public String getnUrl() {
		return nUrl;
	}
	public void setnUrl(String nUrl) {
		this.nUrl = nUrl;
	}
	
	public String getnPicturePath() {
		return nPicturePath;
	}
	public void setnPicturePath(String nPicturePath) {
		this.nPicturePath = nPicturePath;
	}
	@Override
	public String toString() {
		return "News [nId=" + nId + ", nName=" + nName + ", nUrl=" + nUrl + ",  nPicturePath="
				+ nPicturePath + "]";
	}
	
	
	
	
}
