package group.yf.po;

import java.io.Serializable;

/**
 * 省份
 * @author Yang Fei
 *
 */
public class Province implements Serializable{
	private static final long serialVersionUID = 5488442703433277626L;
	private int id;
	private String province;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
}
