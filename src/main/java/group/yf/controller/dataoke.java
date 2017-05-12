/**
 * 
 */
package group.yf.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import group.yf.util.UrlConnUtils;

/**
 * @author Yang Fei
 *
 */
public class dataoke {
	
	public static void main(String[] args)throws Exception{
		
		String urlTop100="http://api.dataoke.com/index.php?r=Port/index&type=top100&appkey=i1mcnvd4gb&v=2";
//		
//		String url="http://shop.m.taobao.com/shop/coupon.htm?seller_id=1890827965&activity_id=50bca6afaba048f6a369b8d39d9f5868";
		String url1="http://api.dataoke.com/index.php?r=goodsLink/www&type=www_quan&appkey=i1mcnvd4gb&v=2&page=1";
//		String url="http://api.dataoke.com/index.php?type=www_quan&appkey=i1mcnvd4gb&v=2&page=1";
		String result=UrlConnUtils.getConnStr(url1);
		System.out.println(result);
		
//		System.out.println("result>>>"+result);
		
		JSONObject resp=JSONObject.parseObject(result);
		
//		System.out.println(resp);
		
		JSONArray array=resp.getJSONArray("result");
		System.out.println(array.getJSONObject(1).toString());;
		
		
		
//		String t=UrlConnUtils.getConnStr(url);
		
//		System.out.println(t);
	}
}
