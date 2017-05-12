/**
 * 
 */
package group.yf.controller;

import java.io.File;
import java.io.FileOutputStream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import group.yf.util.UrlConnUtils;

/**
 * @author Yang Fei
 *
 */
public class chengji {

	public static void main(String[] args) throws Exception {

		File f = new File("F:/score.txt");
		FileOutputStream fout = new FileOutputStream(f);
		
		for (int pageNum = 1; pageNum < 184091; pageNum++) {
			System.out.println("页码>>>"+pageNum);
			String url = "http://data.api.gkcx.eol.cn/soudaxue/querySpecialtyScore.html?messtype=jsonp&provinceforschool=&schooltype="
					+ "&page="+pageNum+"&size=10&keyWord=&schoolproperty=&schoolflag=&province=&fstype=&zhaoshengpici=&fsyear=&zytype=&_=1494235888592";
			String result = UrlConnUtils.getConnStr(url);
			result = result.substring(5, result.length() - 2);

			JSONObject r = new JSONObject();
			try{
				r = JSONObject.parseObject(result);
			}catch(Exception e){
				System.out.println("result>>>"+result);
			}
			
			JSONArray array = r.getJSONArray("school");

			for (int i = 0; i < array.size(); i++) {
				JSONObject school = array.getJSONObject(i);

				String resp = school.getString("schoolname") + "  " + school.getString("specialtyname") + "  "
						+ school.getString("localprovince") + "  " + school.getString("studenttype") + "  "
						+ school.getString("year") + "  " + school.getString("batch") + "  " + school.getString("min")
						+ "  " + school.getString("var") + "  " + school.getString("max")+"\n";
				System.out.println(resp);

				fout.write(resp.getBytes());
				

			}
			Thread.sleep(100);
		}
		System.out.println("================end=======================");
		fout.close();

	}
}
