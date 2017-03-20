package group.yf.po;

import java.io.Serializable;

/**
 * 各省分数线
 * @author Yang Fei
 * 
 */
public class ScoreSegment implements Serializable{
	private static final long serialVersionUID = -8057908050161760546L;
	private int id;
	private int provinceId;
	private int grade;
	private int ranking;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
}
