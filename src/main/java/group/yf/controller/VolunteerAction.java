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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import group.yf.po.College;
import group.yf.resp.BaseResp;
import group.yf.service.AdmissionScoreService;
import group.yf.service.ScoreSegmentService;

/**
 * 进入页面相关方法
 * @author Yang Fei
 *
 */
@Controller
public class VolunteerAction {
	
	Logger log=Logger.getLogger(this.getClass());
	@Autowired
	private ScoreSegmentService scoreSegmentService;
	@Autowired
	private AdmissionScoreService admissionScoreService;
	@Value("#{pageConfig.collegeNum}")
	private Integer collegeNum; 
	@Value("#{pageConfig.year}")
	private Integer year;
	
	/**
	 * 获取改分数的 排名
	 */
	@ResponseBody
	@RequestMapping(value="ranking/{province}/{science}/{score}",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String ranking(HttpServletRequest req,
			@PathVariable("province")String province,
			@PathVariable("science")Integer science,
			@PathVariable("score")Integer score){
		
		log.info("ranking>>>province>>"+province+">>>science>>"+science+">>>score>>"+score);
		Integer ranking=scoreSegmentService.selectRanking(province, score, science,year);
		JSONObject result=new JSONObject();
		if(ranking==null){
			result.put("ret", BaseResp.RESP_STATUS_FAIL);
			result.put("info", "抱歉，未查到输入的分数所处的位次！");
		}else{
			result.put("ret", BaseResp.RESP_STATUS_SUCCESS);
			result.put("info", "查询成功!");
			result.put("ranking", ranking);
		}
		return result.toString();
	}
	
	/**
	 * 进入志愿查询结果页面
	 */
	@ResponseBody
	@RequestMapping(value="volunteerResultPage/{province}/{science}/{ranking}",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public ModelAndView volunteerResult(HttpServletRequest req,
			@PathVariable("province")String province,
			@PathVariable("science")Integer science,
			@PathVariable("ranking")Integer ranking){

		log.info("volunteerResultPage>>province>>"+province+">>>science>>"+science+">>>ranking>>"+ranking);
		
		ModelAndView mav=new ModelAndView("volunteerResult");
		
		//保底学校列表
		List<College> ensureCollegeList=new ArrayList<College>();
		ensureCollegeList=admissionScoreService.selectEnsureCollege(province, ranking, collegeNum,science);
		
		//稳定学校列表
		List<College> stablityCollegeList=new ArrayList<College>();
		stablityCollegeList=admissionScoreService.selectStablityCollege(province, ranking, collegeNum,science);
		
		//可冲刺学校列表
		List<College> sprintCollegeList=new ArrayList<College>();
		sprintCollegeList=admissionScoreService.selectSprintCollege(province, ranking, collegeNum,science);
		
		mav.addObject("ensureCollegeList", ensureCollegeList);
		mav.addObject("stablityCollegeList", stablityCollegeList);
		mav.addObject("sprintCollegeList", sprintCollegeList);
		
		int ensureCollegeNum=admissionScoreService.selectCountEnsureCollegeNum(province, ranking, collegeNum,science);
		int stablityCollegeNum=admissionScoreService.selectCountStablityCollegeNum(province, ranking, collegeNum,science);
		int sprintCollegeNum=admissionScoreService.selectCountSprintCollegeNum(province, ranking, collegeNum,science);
		
		mav.addObject("ensureCollegeNum", ensureCollegeNum);
		mav.addObject("stablityCollegeNum", stablityCollegeNum);
		mav.addObject("sprintCollegeNum", sprintCollegeNum);
		
		return mav;
	}
}
