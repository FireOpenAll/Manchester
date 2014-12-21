package com.lepeng.admin.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lepeng.admin.service.ProductService;
import com.lepeng.admin.web.domain.PageBean;
import com.lepeng.admin.web.domain.Pageable;
import com.lepeng.domain.Product;


@Controller
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;
	
	/**
	 * 商品列表
	 * @param queryCondition
	 * @param pageable
	 * @param model
	 * @param map
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Product queryCondition, Pageable pageable, ModelMap model,Map<String, Object> map){
		PageBean<Product> page = productService.getPageBean(queryCondition, pageable);
		model.addAttribute("page", page);
		model.addAttribute("queryCondition", queryCondition);
		return "list";
	}
	
	/**
	 * 进入登陆页面
	 * @return
	 */
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	
	/**
	 * 加载商品
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/load")
	public String load(@RequestParam(value="id",required=false)Integer id,ModelMap model) {
		Product product = null;
		if (id != null) {
			product = productService.load(id);
		}
		model.addAttribute("product", product);
		model.addAttribute("id", id);
		return "/productInput";
	} 
	
	/**
	 * 删除商品.
	 * 
	 * @param id
	 *            the id
	 * @return the string
	 */
	@RequestMapping("/delete")
	public String delete(int id){
		
		Product product = new Product();
		product.setId(id);
		productService.delete(product);
		return "redirect:/list";
	}
	
	/**
	 * 保存商品
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Product product, ModelMap model){
		
		product.setStatus(Product.Status.Enalbe.getstatus());
		if (product.getId() != null) {
			productService.update(product);
		}else {
			productService.save(product);
		}
		return "redirect:/list";
	}
	

}
