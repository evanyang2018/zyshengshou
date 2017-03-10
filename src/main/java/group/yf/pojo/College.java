package group.yf.pojo;

import java.io.Serializable;

/**
 * 大学
 * @author Yang Fei
 *
 */
public class College implements Serializable{
	private static final long serialVersionUID = 5855928131577654033L;
	private int id;
	private String college;
	private String info;
	private String officialWebsite;  //官网
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getOfficialWebsite() {
		return officialWebsite;
	}
	public void setOfficialWebsite(String officialWebsite) {
		this.officialWebsite = officialWebsite;
	}
	
}
