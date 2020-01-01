package edu.swjtuhc.cgService.model;

import java.util.Date;

public class Article {
	private Long aId;
	private Long uId;
	private String article;
	private Date apublishDate=new Date();
	private String aname;
	private String auploader;
	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public Date getapublishDate() {
		return apublishDate;
	}

	public void setapublishDate(Date apublishDate) {
		this.apublishDate = apublishDate;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getauploader() {
		return auploader;
	}

	public void setauploader(String a_uploader) {
		this.auploader = a_uploader;
	}
	
	public Long getaId() {
		return aId;
	}

	public void setaId(Long aId) {
		this.aId = aId;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Article [aId=" + aId + ", uId=" + uId + ", article=" + article + ", apublishDate=" + apublishDate
				+ ", aname=" + aname + ", auploader=" + auploader + "]";
	}
	
}
