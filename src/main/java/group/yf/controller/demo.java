/**
 * 
 */
package group.yf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Yang Fei
 *
 */
@Controller
public class demo {
	
	@ResponseBody
	@RequestMapping("aaa")
	public String aaa(HttpServletRequest req,HttpServletResponse resp){
		
		resp.setHeader("Access-Control-Allow-Origin", "*");
		JSONObject jsonResp=new JSONObject();
		jsonResp.put("aaa", "123456");
		
		jsonResp.put("image", "http://210.51.190.27:8097/2.png");
		  jsonResp.put("boxImage", "http://210.51.190.27:8097/box.png");
		  jsonResp.put("youImage", "http://210.51.190.27:8097/you.jpg");
		  jsonResp.put("zuoImage", "http://210.51.190.27:8097/zuo.jpg");
	      jsonResp.put("result", 0);

		
		
		return jsonResp.toString();
	}
}
