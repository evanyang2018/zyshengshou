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
	
	List<College> selectEnsureCollege(@Param("localProvince")String localProvince,@Param("targetProvince")String targetProvince,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
	List<College> selectStablityCollege(@Param("localProvince")String localProvince,@Param("targetProvince")String targetProvince,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
	List<College> selectSprintCollege(@Param("localProvince")String localProvince,@Param("targetProvince")String targetProvince,@Param("ranking")int ranking,@Param("limitNum")int limitNum,@Param("science")int science);
	
}
