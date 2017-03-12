package group.yf.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import group.yf.dao.AdmissionScoreMapper;
import group.yf.pojo.College;
import group.yf.service.AdmissionScoreService;

@Controller
public class AdmissionScoreServiceImpl implements AdmissionScoreService{

	Logger log=Logger.getLogger(this.getClass());
	@Autowired
	private AdmissionScoreMapper admissionScoreMapper;

	/**
	 * 获取 保底学校List
	 */
	@Override
	public List<College> selectEnsureCollege(String localProvince, String targetProvince, int ranking, int limitNum,int science) {
		List<College> ensureCollegeList=admissionScoreMapper.selectEnsureCollege(localProvince, targetProvince, ranking, limitNum,science);
		return ensureCollegeList;
	}

	/**
	 * 获取 稳定学校List
	 */
	@Override
	public List<College> selectStablityCollege(String localProvince, String targetProvince, int ranking, int limitNum,int science) {
		List<College> stablityCollegeList=admissionScoreMapper.selectStablityCollege(localProvince, targetProvince, ranking, limitNum,science);
		return stablityCollegeList;
	}

	/**
	 * 获取 冲刺学校List
	 */
	@Override
	public List<College> selectSprintCollege(String localProvince, String targetProvince, int ranking, int limitNum,int science) {
		List<College> sprintCollegeList=admissionScoreMapper.selectSprintCollege(localProvince, targetProvince, ranking, limitNum,science);
		return sprintCollegeList;
	}
	
	
}
