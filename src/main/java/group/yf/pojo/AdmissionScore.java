package group.yf.pojo;

import java.io.Serializable;

/**
 * 大学录取分数线
 * @author Yang Fei
 *
 */
public class AdmissionScore implements Serializable{
	private static final long serialVersionUID = -1235868809118469477L;
	private int id;
	private int collegeId;
	private int provinceId;
	private int year;
	private int ensureHigh; //保底最高位次
	private int ensureLow;  //保底最低位次
	private int stablityHigh;  //稳定最高位次
	private int stablityLow;   //稳定最低位次
	private int sprintHigh;   //可冲刺最高位次
	private int sprintLow;	  //可冲刺最低位次
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getEnsureHigh() {
		return ensureHigh;
	}
	public void setEnsureHigh(int ensureHigh) {
		this.ensureHigh = ensureHigh;
	}
	public int getEnsureLow() {
		return ensureLow;
	}
	public void setEnsureLow(int ensureLow) {
		this.ensureLow = ensureLow;
	}
	public int getStablityHigh() {
		return stablityHigh;
	}
	public void setStablityHigh(int stablityHigh) {
		this.stablityHigh = stablityHigh;
	}
	public int getStablityLow() {
		return stablityLow;
	}
	public void setStablityLow(int stablityLow) {
		this.stablityLow = stablityLow;
	}
	public int getSprintHigh() {
		return sprintHigh;
	}
	public void setSprintHigh(int sprintHigh) {
		this.sprintHigh = sprintHigh;
	}
	public int getSprintLow() {
		return sprintLow;
	}
	public void setSprintLow(int sprintLow) {
		this.sprintLow = sprintLow;
	}
	
}
