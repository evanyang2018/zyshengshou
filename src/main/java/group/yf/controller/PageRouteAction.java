package group.yf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import group.yf.pojo.College;
import group.yf.service.AdmissionScoreService;
import group.yf.service.ScoreSegmentService;

/**
 * 进入页面相关方法
 * @author Yang Fei
 *
 */
@Controller
public class PageRouteAction {
	
	Logger log=Logger.getLogger(this.getClass());
	@Autowired
	private ScoreSegmentService scoreSegmentService;
	@Autowired
	private AdmissionScoreService admissionScoreService;
	@Value("#{pageConfig.collegeNum}")
	private Integer collegeNum; 
	
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
			@PathVariable("science")Integer science,
			@PathVariable("score")Integer score,
			@PathVariable("volunteerArea")String volunteerArea){
		log.info("volunteerResultPage>>province"+province+">>>science>>"+science+">>>score>>"+score+">>>volunteerArea>>"+volunteerArea);
		
		ModelAndView mav=new ModelAndView("volunteerResult");
		
		int ranking=scoreSegmentService.selectRanking(province, score, science);
		
		List<College> ensureCollegeList=new ArrayList<College>();
		ensureCollegeList=admissionScoreService.selectEnsureCollege(province, volunteerArea, ranking, collegeNum,science);
		
		List<College> stablityCollegeList=new ArrayList<College>();
		stablityCollegeList=admissionScoreService.selectStablityCollege(province, volunteerArea, ranking, collegeNum,science);
		
		List<College> sprintCollegeList=new ArrayList<College>();
		sprintCollegeList=admissionScoreService.selectSprintCollege(province, volunteerArea, ranking, collegeNum,science);
		
		mav.addObject("ensureCollegeList", ensureCollegeList);
		mav.addObject("stablityCollegeList", stablityCollegeList);
		mav.addObject("sprintCollegeList", sprintCollegeList);
		
		return mav;
	}
}
