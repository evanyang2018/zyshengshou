package group.yf.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 进入页面相关方法
 * @author Yang Fei
 *
 */
@Controller
public class PageRouteAction {
	
	Logger log=Logger.getLogger(this.getClass());
	/**
	 * 进入志愿查询页面
	 */
	@RequestMapping("volunteer")
	public ModelAndView volunteer(){
		log.info("volunteerPage");
		ModelAndView mav=new ModelAndView("volunteer");
		return mav;
	}
	
	/**
	 * 进入志愿查询结果页面
	 */
	@RequestMapping(value="volunteerResult/{province}/{science}/{score}/{volunteerArea}")
	public ModelAndView volunteerResult(HttpServletRequest req,
			@PathVariable("province")String province,
			@PathVariable("science")String science,
			@PathVariable("score")Integer score,
			@PathVariable("volunteerArea")String volunteerArea){
		log.info("volunteerResultPage>>province"+province+">>>science>>"+science+">>>score>>"+score+">>>volunteerArea>>"+volunteerArea);
		
		ModelAndView mav=new ModelAndView("volunteerResult");
		
		return mav;
	}
}
