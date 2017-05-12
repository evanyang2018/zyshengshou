package group.yf.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;



public class UrlConnUtils {
	 private static Logger log = Logger.getLogger(UrlConnUtils.class);	
	/**
	 * 注意：5秒内请求不到页面.就认为出现错误。
	 * @param urlPath
	 * @return
	 */
	public static String getConnStr(String urlPath){
		HttpURLConnection urlconn = null;
		StringBuffer sbf  = new StringBuffer();
		JSONObject json=new JSONObject();
			try{
				URL url = new URL(urlPath);
				urlconn = (HttpURLConnection)url.openConnection();
				urlconn.setRequestMethod("GET");
				urlconn.setConnectTimeout(30000);
				urlconn.setReadTimeout(50000);
				urlconn.connect();
				BufferedReader br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),"UTF-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sbf.append(line);
				}
				br.close();
				urlconn.disconnect();
				return sbf.toString();
			}catch(Exception e){
				json.put("code", "500");
				json.put("msg", "连接超时");
				log.info("请求地址出错！！！");
			}finally{
				if(urlconn!=null){
					urlconn.disconnect();
				}
			}
			return json.toJSONString();
	}
	
	public static String getConnStrLongtime(String urlPath){
		HttpURLConnection urlconn = null;
		StringBuffer sbf  = new StringBuffer();
		JSONObject json=new JSONObject();
			try{
				URL url = new URL(urlPath);
				urlconn = (HttpURLConnection)url.openConnection();
				urlconn.setRequestMethod("GET");
				urlconn.setConnectTimeout(30000);
				urlconn.setReadTimeout(30000);
				urlconn.connect();
				BufferedReader br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),"UTF-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sbf.append(line);
				}
				br.close();
				urlconn.disconnect();
				return sbf.toString();
			}catch(Exception e){
				json.put("code", "500");
				json.put("msg", "连接超时");
			}finally{
				if(urlconn!=null){
					urlconn.disconnect();
				}
			}
			return json.toJSONString();
	}
	
	public static String getConnStrForMethod(String urlPath,String method,String encoding){
		HttpURLConnection urlconn = null;
		StringBuffer sbf  = new StringBuffer();
			try{
				URL url = new URL(urlPath);
				urlconn = (HttpURLConnection)url.openConnection();
				urlconn.setRequestMethod(method);
				
				//urlconn.setConnectTimeout(1500);
				//urlconn.setReadTimeout(2500);
				urlconn.setConnectTimeout(4500);
				urlconn.setReadTimeout(5500);
				
				urlconn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				urlconn.connect();
				BufferedReader br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),encoding));
				String line;
				while ((line = br.readLine()) != null) {
					sbf.append(line);
				}
				br.close();
				urlconn.disconnect();
				urlconn.disconnect();
				return sbf.toString();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(urlconn!=null){
					urlconn.disconnect();
				}
			}
		return null;
	}
	
	public static String getConnStrForPOST(String urlPath,String encoding,String param){
		HttpURLConnection urlconn = null;
		StringBuffer sbf  = new StringBuffer();
			try{
				URL url = new URL(urlPath);
				urlconn = (HttpURLConnection)url.openConnection();
				urlconn.setRequestMethod("POST");
				urlconn.setDoOutput(true);
				urlconn.setConnectTimeout(1000);
				urlconn.setReadTimeout(2000);
				urlconn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				urlconn.setRequestProperty("Charset", "utf-8");
				urlconn.connect();
				OutputStreamWriter osw = new OutputStreamWriter(urlconn.getOutputStream(),"utf-8");
				osw.write(param);
				osw.flush();
				osw.close();
				if(urlconn.getResponseCode() == 200){
					BufferedReader br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),encoding));
					String line;
					while ((line = br.readLine()) != null) {
						sbf.append(line);
					}
					br.close();
					urlconn.disconnect();
				}
				return sbf.toString();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(urlconn!=null){
					urlconn.disconnect();
				}
			}
		return null;
	}
	
	public static String getConnStr(String urlPath,String encoding){
		HttpURLConnection urlconn = null;
		StringBuffer sbf  = new StringBuffer();
			try{
				URL url = new URL(urlPath);
				urlconn = (HttpURLConnection)url.openConnection();
				urlconn.setRequestMethod("GET");
				urlconn.setConnectTimeout(1500);
				urlconn.setReadTimeout(2500);
				urlconn.connect();
				BufferedReader br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),encoding));
				String line;
				while ((line = br.readLine()) != null) {
					sbf.append(line);
				}
				br.close();
				urlconn.disconnect();
				return sbf.toString();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(urlconn!=null){
					urlconn.disconnect();
				}
			}
		return null;
	}
	public static void main(String[] args) throws UnsupportedEncodingException{
//		String urlPath = "http://live.itougu.jrjc.local/live/index.php/service/addGiftMessage";
//		String encoding = "UTF-8";
//		String param = "gift_id=1&gift_num=1&gift_rmb=1&sn=201508241042451991&tgid=&userid=141107010049770731&uniqueid=23";
//		String str = UrlConnUtils.getConnStrForPOST(urlPath, encoding, param);
//		System.out.println("str = "+str);
		
		
		
		//http://live.itougu.jrjc.local/live/index.php/service/addGiftMessage?gift_id=1&gift_num=1&gift_rmb=1&sn=201508241042451991&tgid=&userid=141107010049770731&uniqueid=nul
		//System.out.println(UrlConnUtils.getConnStrForMethod("http://sso.jrj.com.cn/sso/passport/certificateValid.jsp?appParam=TG&certificateId=372923198908195045&certificateName="+URLEncoder.encode(URLEncoder.encode("张阳","utf-8"),"UTF-8"),"POST","UTF-8"));
		//http\://sso.jrj.com.cn/sso/passport/updatePassport.jsp?jsonStr\={json}
		//System.out.println(UrlConnUtils.getConnStrForMethod("http://sso.jrj.com.cn/sso/passport/certificateValid.jsp?appParam=TG&certificateId=372923198908195045&certificateName="+URLEncoder.encode(URLEncoder.encode("张阳","utf-8"),"UTF-8"),"POST","UTF-8"));
		//System.out.println(UrlConnUtils.getConnStrForMethod("http://sso.jrj.com.cn/sso/passport/userPassportById.jsp?passportIds=141027010023086621","POST","GBK"));
		
		String url="http://weipan.izhipeng.com/autoCloseOrder.jspa";
		String encode="UTF-8";
		String param2="{\"code\": \"200\",\"msg\": \"推送成功\",\"result\": [{\"addTime\": \"2015-12-08 11:53:26\",\"belongsid\": \"181\",\"bottomLimit\": 0.1,\"bottomPrice\": 2.942,\"buyDirection\": 1,\"buyMoney\": 64,"+
"\"buyPrice\": 2.934,\"count\": 8,\"couponFlag\": 1,\"deficitPrice\": 3.014,\"mobile\": 15622352229,\"orderId\": 43975,\"orderNum\": \"3192115326189706\",\"orderType\": 5,\"plAmount\": -6.4,\"productId\": 4,"+
"\"sellPrice\": 2.942,\"sellTime\": \"2015-12-08 14:08:28\",\"topLimit\": 0.5,\"topPrice\": 2.894,\"wid\": \"15622352229\"，“ buyNum”:”3192115326189706”        },        {"+
"\"addTime\": \"2015-12-07 18:52:04\",\"belongsid\": \"181\",\"buyDirection\": 2,\"buyMoney\": 8,\"buyPrice\": 2.991,\"count\": 1,\"couponFlag\": 1,\"deficitPrice\": 2.911,\"mobile\": 15622352229,"+
"\"orderId\": 43962,\"orderNum\": \"3192185204472630\",\"orderType\": 4,"+
"\"plAmount\": 0.8,\"productId\": 4,\"sellPrice\": 2.999,\"sellTime\": \"2015-12-07 21:22:49\",\"topLimit\": 0.1,\"topPrice\": 2.999,\"wid\": \"15622352229\","+
"\" buyNum\":\"3192115326189706\"   },"+
"{\"addTime\": \"2015-12-07 17:03:33\",\"belongsid\": \"181\",\"bottomLimit\": 0.1,\"bottomPrice\": 1,\"buyDirection\": 2,\"buyMoney\": 10,\"buyPrice\": 3.24,\"count\": 1,"+
"\"couponFlag\": 0,\"deficitPrice\": 1,\"fee\": 0.8,\"mobile\": 15622352229,\"orderId\": 43961,\"orderNum\": \"3525835627769\",\"orderType\": 4,\"plAmount\": -11200,\"productId\": 11,"+
"\"sellPrice\": 1,\"sellTime\": \"2015-12-07 17:03:33\",\"topLimit\": 0.1,\"topPrice\": 1,\"wid\": \"15622352229\","+
"\"buyNum\":\"3192115326189706\"}, {\"addTime\": \"2015-12-07 16:59:23\",\"belongsid\": \"181\",\"bottomLimit\": 0.3,\"bottomPrice\": 3.011,\"buyDirection\": 1,"+
"\"buyMoney\": 64,\"buyPrice\": 3.003,\"count\": 8,\"couponFlag\": 1,\"deficitPrice\": 3.083,\"mobile\": 15622352229,\"orderId\": 43958,\"orderNum\": \"3192165923502897\",\"orderType\": 4,"+
"\"plAmount\": 6.4,\"productId\": 4,\"sellPrice\": 2.995,\"sellTime\": \"2015-12-07 18:25:31\",\"topLimit\": 0.1,\"topPrice\": 2.995,"+
"\"wid\": \"15622352229\",“ buyNum”:”3192115326189706” } ],\"status\": true}";
		
		String result = UrlConnUtils.getConnStrForPOST(url, encode, param2);
		System.out.println("result = "+result);
		
		
	}
}
