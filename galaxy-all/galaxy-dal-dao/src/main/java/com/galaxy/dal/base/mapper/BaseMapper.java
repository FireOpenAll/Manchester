package com.galaxy.dal.base.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper<T extends Serializable> {

	public boolean insert(T entity);

	public boolean update(T entity);

	public boolean deleteById(@Param("id") Long id);

	public T getById(@Param("id") Long id);

	public List<T> list(PaginationParam paginationParam);

}
