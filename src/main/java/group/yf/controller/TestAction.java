package group.yf.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import group.yf.service.TestService;

/**
 * @author Yang Fei
 *
 */
@Controller
public class TestAction {
	
	Logger log=Logger.getLogger(this.getClass());
	@Autowired
	private TestService testService;
	
	
	@RequestMapping(value="abc")
	public ModelAndView abc(HttpServletRequest req){
		ModelAndView mav=new ModelAndView("test");
		int i=testService.add();
		log.info("action>>>>>>>>"+i);
		return mav;
	}
	
	/**
	 * 文件上传
	 */
	@RequestMapping("fileUpLoad")
	public String fileUpLoad(@RequestParam("file")MultipartFile file){
		if(!file.isEmpty()){
			try {
				
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File("保存地址"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return "";
	}
}
