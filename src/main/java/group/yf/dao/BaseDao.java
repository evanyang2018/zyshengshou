package group.yf.dao;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

/**
 * Dao基本操作 CUID
 * @author Yang Fei
 *
 */
public interface BaseDao<Entity extends Serializable> {
	
	public int insert(Entity entity);
	
	public int updateById(Entity entity);
	
	public Entity selectById(@Param("id") int id);
	 
	public int deleteById(int id);
}
