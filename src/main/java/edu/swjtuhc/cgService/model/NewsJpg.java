package edu.swjtuhc.cgService.model;

public class NewsJpg {
	private Long jId;
	private String jName;
	private String Poster;
	public Long getjId() {
		return jId;
	}
	public void setjId(Long jId) {
		this.jId = jId;
	}
	public String getjName() {
		return jName;
	}
	public void setjName(String jName) {
		this.jName = jName;
	}
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		Poster = poster;
	}
	@Override
	public String toString() {
		return "NewsJpg [jId=" + jId + ", jName=" + jName + ", Poster=" + Poster + "]";
	}
}
