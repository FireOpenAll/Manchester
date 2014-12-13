package com.lepeng.repository;

import com.lepeng.domain.Product;


public interface ProductMapper extends BaseMapper<Product> {

	/**
	 * 删除产品
	 * @param product
	 */
	public void delete(Product product);

	
}
