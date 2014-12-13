
package com.lepeng.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lepeng.admin.web.domain.PageBean;
import com.lepeng.admin.web.domain.Pageable;
import com.lepeng.domain.Product;
import com.lepeng.repository.ProductMapper;


@Service
public class ProductService extends BaseService {

	
	@Autowired
	private ProductMapper productMapper;
	
	/**
	 * 查询产品列表
	 * @param queryCondition
	 * @param pageable
	 * @return
	 */
	public PageBean<Product> getPageBean(Product queryCondition, Pageable pageable) {
		PageBean<Product> page = new PageBean<Product>(pageable.getPageNo(), pageable.getPageSize());
		List<Product> list = findList(queryCondition, pageable);
		page.setTotal(this.getTotal(queryCondition));
		page.setResultList(list);
		return page;
	}
	
	/**
	 * 获取总数.
	 *
	 * @param queryCondition the query condition
	 * @return the total
	 */
	public Long getTotal(Product queryCondition){
		return this.productMapper.getCount(queryCondition);
	}
	
	/**
	 * 分页查找商品列表.
	 *
	 * @param queryCondition the query condition
	 * @param pageable the pageable
	 * @return the list
	 */
	public List<Product> findList(Product queryCondition, Pageable pageable){
		return productMapper.getByCondition(queryCondition, pageable.getStart(),pageable.getPageSize());
	}

	/**
	 * 保存商品
	 * @param product
	 */
	public void save(Product product){
		productMapper.insert(product);
	}
	
	/**
	 * 更新商品
	 * @param product
	 */
	public void update(Product product){
		productMapper.update(product);
	}

	/**
	 * 删除商品
	 * @param product
	 */
	public void delete(Product product){
		product.setStatus(Product.Status.Disable.getstatus());
		productMapper.delete(product);
	}
	
	/**
	 * 查询商品
	 * @param id
	 * @return
	 */
	public Product load(Integer id) {
		return productMapper.getById(id);
	}
}
