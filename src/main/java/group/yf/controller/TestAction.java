package group.yf.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView abc(){
		ModelAndView mav=new ModelAndView("test");
		int i=testService.add();
		log.info("action>>>>>>>>"+i);
		return mav;
	}
}
