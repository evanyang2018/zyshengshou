package group.yf.dao;

import org.apache.ibatis.annotations.Param;

import group.yf.pojo.ScoreSegment;

/**
 * @author Yang Fei
 *
 */
public interface ScoreSegmentMapper extends BaseDao<ScoreSegment>{
	
	public int selectRanking(@Param("province")String province,@Param("score")int score,@Param("science")int science);
	
}
