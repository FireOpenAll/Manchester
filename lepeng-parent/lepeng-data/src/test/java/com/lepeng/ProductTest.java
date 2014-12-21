package com.lepeng;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lepeng.domain.Product;
import com.lepeng.repository.ProductMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/app-context.xml"})
@ActiveProfiles("test")
public class ProductTest {

	@Autowired
	private ProductMapper productMapper;

	@Test
	public void saveProduct(){
		
		Product product = new Product();
		product.setName("iphone 7779");
		product.setStatus(Product.Status.Enalbe.getstatus());
		productMapper.insert(product);
	}
}
