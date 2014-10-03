package com.galaxy.dal.base.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper<T extends Serializable> {

	public boolean insert(T entity);

	public boolean update(T entity);

	public boolean deleteById(@Param("id") Long id);

	public T getById(@Param("id") Long id);

	public List<T> list(PaginationParam paginationParam);
	
	public int countAll(@Param("id")Map params);

}
