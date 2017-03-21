package group.yf.service;

import java.util.List;

import group.yf.po.College;


public 	interface AdmissionScoreService {
	
	List<College> selectEnsureCollege(String localProvince,int ranking,int limitNum,int science);
	
	List<College> selectStablityCollege(String localProvince,int ranking,int limitNum,int science);
	
	List<College> selectSprintCollege(String localProvince,int ranking,int limitNum,int science);
	
	int selectCountEnsureCollegeNum(String localProvince,int ranking,int limitNum,int science);
	
	int selectCountStablityCollegeNum(String localProvince,int ranking,int limitNum,int science);
	
	int selectCountSprintCollegeNum(String localProvince,int ranking,int limitNum,int science);
	
}
