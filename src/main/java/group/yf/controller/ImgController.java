package group.yf.controller;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import group.yf.util.ImageUtil;

/**
 * @author Yang Fei
 *
 */
@Controller
class ImgController{
	
	//生成验证码图片  
	@RequestMapping("/valicode.img") //对应/user/valicode.do请求  
	public void valicode(HttpServletResponse response,HttpSession session) throws Exception{  
		Thread.sleep(2000);
	  //利用图片工具生成图片  
	  //第一个参数是生成的验证码，第二个参数是生成的图片  
	  Object[] objs = ImageUtil.createImage();  
	  //将验证码存入Session  
	  session.setAttribute("imageCode",objs[0]);  
	  //将图片输出给浏览器  
	  BufferedImage image = (BufferedImage) objs[1];  
	  response.setContentType("image/png");  
	  OutputStream os = response.getOutputStream();  
	  ImageIO.write(image, "png", os);  
	    
	}  
	
	
	
}
