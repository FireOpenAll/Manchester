
package com.lepeng.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface BaseMapper<T> {

	/**
	 * 插入一条记录.
	 *
	 * @param entity 实体数据
	 * @return 受影响的行数
	 */
	Integer insert(T entity);

	/**
	 * 修改一条记录.
	 *
	 * @param entity 要修改的实体数据,实体中应包含明确的主键数据
	 * @return 受影响的行数
	 */
	Integer update(T entity);

	/**
	 * 通过主键删除一条记录.
	 *
	 * @param id 主键
	 */
	void delete(Integer id);

	/**
	 * 通过主键获取一条记录.
	 *
	 * @param id 主键
	 * @return 对应的实体
	 */
	T getById(Integer id);

	/**
	 * 分页获取数据.
	 *
	 * @param map 用于存放查询参数的map,必要参数:start,size用于指定开始记录的数组下标和分页大小
	 * @return 指定页的实体数据
	 */
	List<T> getByPage(Map<String, Object> map);

	/**
	 * 获取记录总数,用于配合分页显示.
	 *
	 * @param map 用于存放查询参数的map
	 * @return 指定查询条件下的所有记录数
	 */
	Long getCount(Map<String, Object> map);
	
	/**
	 * Gets the count.
	 *
	 * @param bean the bean
	 * @return the count
	 */
	Long getCount(@Param("bean") T bean);
	
	/**
	 * Gets the by condition.
	 *
	 * @param bean the bean
	 * @param pageable the pageable
	 * @return the by condition
	 */
	List<T> getByCondition(@Param("bean") T bean, @Param("start") int start,@Param("pageSize") int pageSize);
	
}
