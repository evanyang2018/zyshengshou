package group.yf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import group.yf.po.AdmissionScore;
import group.yf.po.College;

/**
 * 关联大学录取排名表
 * @author Yang Fei
 *
 */
public interface AdmissionScoreMapper extends BaseDao<AdmissionScore> {
	
	public List<College> selectEnsureCollege(@Param("province")String province,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
	public List<College> selectStablityCollege(@Param("province")String province,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
	public List<College> selectSprintCollege(@Param("province")String province,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
	public int selectCountEnsureCollegeNum(@Param("province")String province,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
	public int selectCountStablityCollegeNum(@Param("province")String province,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
	public int selectCountSprintCollegeNum(@Param("province")String province,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
}
