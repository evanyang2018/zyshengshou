package group.yf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 进入页面相关方法
 * @author Yang Fei
 *
 */
@Controller
@RequestMapping("page")
public class PageRouteAction {
	/**
	 * 进入志愿查询页面
	 */
	@RequestMapping("volunteer")
	public ModelAndView Volunteer(){
		ModelAndView mav=new ModelAndView("volunteer");
		return mav;
	}
	
	/**
	 * 进入志愿查询结果页面
	 */
	@RequestMapping("volunteerResult")
	public ModelAndView volunteerResult(){
		ModelAndView mav=new ModelAndView("volunteerResult");
		return mav;
	}
}
