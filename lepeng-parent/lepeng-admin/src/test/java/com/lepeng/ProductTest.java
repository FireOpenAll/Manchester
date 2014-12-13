package com.lepeng;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lepeng.admin.service.ProductService;
import com.lepeng.domain.Product;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/app-context.xml"})
@ActiveProfiles("test")
public class ProductTest {

	@Autowired
	private ProductService productService;
	

	@Test
	public void saveProduct(){
		
		Product product = new Product();
		product.setName("admin 881");
		product.setStatus(Product.Status.Enalbe.getstatus());
		productService.save(product);
	}
}
