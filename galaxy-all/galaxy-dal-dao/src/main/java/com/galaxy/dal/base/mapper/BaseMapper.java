package com.galaxy.dal.base.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper<T extends Serializable> {

	public boolean insert(T entity);

	public boolean update(T entity);

	public boolean deleteById(@Param("id") Long id);

	public T getById(@Param("id") Long id);

}
