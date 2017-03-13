package group.yf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import group.yf.pojo.AdmissionScore;
import group.yf.pojo.College;

/**
 * 关联大学录取排名表
 * @author Yang Fei
 *
 */
public interface AdmissionScoreMapper extends BaseDao<AdmissionScore> {
	
	public List<College> selectEnsureCollege(@Param("localProvince")String localProvince,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
	public List<College> selectStablityCollege(@Param("localProvince")String localProvince,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
	public List<College> selectSprintCollege(@Param("localProvince")String localProvince,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
	public int selectCountEnsureCollegeNum(@Param("localProvince")String localProvince,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
	public int selectCountStablityCollegeNum(@Param("localProvince")String localProvince,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
	public int selectCountSprintCollegeNum(@Param("localProvince")String localProvince,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
}
