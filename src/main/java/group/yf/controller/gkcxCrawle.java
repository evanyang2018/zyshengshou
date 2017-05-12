/**
 * 
 */
package group.yf.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.io.IOUtils;  

import java.io.*;  
/**
 * @author Yang Fei
 *
 */
public class gkcxCrawle {
	
	private static OkHttpClient client = new OkHttpClient();
	
//	public static void main(String[] args)throws Exception{
//		//String url="http://gkcx.eol.cn/soudaxue/querySpecialtyScore.html?&page=1";
////		String url="https://www.zhuige.com/app/index/page/1";
////		String url="http://gkcx.eol.cn//soudaxue/querySpecialtyScore.html?&schoolyear=2016&zytype=%E6%96%87%E5%AD%A6%E7%B1%BB&province=%E5%8C%97%E4%BA%AC&recomschprop=%E7%BB%BC%E5%90%88%E7%B1%BB&argschtype=%E6%99%AE%E9%80%9A%E6%9C%AC%E7%A7%91&schoolflag=985%E5%B7%A5%E7%A8%8B&schoolpc=%E6%9C%AC%E7%A7%91%E4%B8%80%E6%89%B9";
////		String html=run(url);
////		Document doc=Jsoup.parse(html);
////		doc.getElementsByClass("table table-bordered table-striped");
////		System.out.println(doc);	
//		
//		String result=fetch_url("http://gkcx.eol.cn/soudaxue/querySpecialtyScore.html?&page=1","utf-8");
//		System.out.println(result);
//			
//	}
//	
//	
//	public static String run(String url) throws Exception {
//		Request request = new Request.Builder().url(url).build();
//		Response response = client.newCall(request).execute();
//		if (response.isSuccessful()) {
//			return response.body().string();
//		} else {
//			throw new IOException("Unexpected code " + response);
//		}
//	}
//	
//	
//	
//	
//	public static String fetch_url(String url, String code) throws IOException {
//	    BufferedReader bis = null; 
//	    InputStream is = null; 
//	    InputStreamReader inputStreamReader = null;
//	    try { 
//	        URLConnection connection = new URL(url).openConnection(); 
//	        connection.setConnectTimeout(20000);
//	        connection.setReadTimeout(20000);
//	        connection.setUseCaches(false);
//	        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11");
//	        is = connection.getInputStream(); 
//	        inputStreamReader = new InputStreamReader(is, code);
//	        bis = new BufferedReader(inputStreamReader); 
//	        String line = null; 
//	        StringBuffer result = new StringBuffer(); 
//	        while ((line = bis.readLine()) != null) { 
//	            result.append(line); 
//	        } 
//	        
//	        return result.toString(); 
//	    } finally { 
//	        if (inputStreamReader != null) {
//	            try { 
//	                inputStreamReader.close();
//	            } catch (IOException e) { 
//	                e.printStackTrace(); 
//	            } 
//	             
//	        }
//	        if (bis != null) { 
//	            try { 
//	                bis.close(); 
//	            } catch (IOException e) { 
//	                e.printStackTrace(); 
//	            } 
//	        } 
//	        if (is != null) { 
//	            try { 
//	                is.close(); 
//	           } catch (IOException e) { 
//	                e.printStackTrace(); 
//	            } 
//	        } 
//	    } 
//	}
	
	
	    public static String getAjaxCotnent(String url) throws IOException {  
	        Runtime rt =Runtime.getRuntime();
	        Process p = rt.exec("C:/Users/Administrator/Desktop/新建文件夹 (2)/phantomjs-1.9.7-windows/phantomjs.exe E:/crawl2.js ");
	     InputStream is = p.getInputStream();  
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));  
	        StringBuffer sbf = new StringBuffer();  
	        String tmp = "";  
	        while((tmp = br.readLine())!=null){  
	            sbf.append(tmp);  
	        }  
	        System.out.println(sbf.toString());  
	        return sbf.toString();  
	    }  
	  
	    public static void main(String[] args) throws IOException{  
	        getAjaxCotnent("");  
	    }  
	}  



