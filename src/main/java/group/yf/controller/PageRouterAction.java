package group.yf.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yang Fei
 *
 */
@Controller
public class PageRouterAction {

	Logger log=Logger.getLogger(this.getClass());
	
	
	/**
	 * 进入志愿查询页面
	 */
	@RequestMapping("volunteerPage")
	public ModelAndView volunteer(){
		log.info("Page>>>volunteer");
		ModelAndView mav=new ModelAndView("volunteer");
		return mav;
	}
	
}
