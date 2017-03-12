package group.yf.service;

import java.util.List;

import group.yf.pojo.College;


public 	interface AdmissionScoreService {
	
	List<College> selectEnsureCollege(String localProvince,String targetProvince,int ranking,int limitNum,int science);
	
	List<College> selectStablityCollege(String localProvince,String targetProvince,int ranking,int limitNum,int science);
	
	List<College> selectSprintCollege(String localProvince,String targetProvince,int ranking,int limitNum,int science);
}
