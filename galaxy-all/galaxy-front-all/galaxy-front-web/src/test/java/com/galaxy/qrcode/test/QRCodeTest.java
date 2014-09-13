package com.galaxy.qrcode.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.core.vcard.VCard;
import net.glxn.qrgen.javase.QRCode;

import org.junit.Test;

public class QRCodeTest {

	@Test
	public void test() throws Exception {
		VCard johnDoe = new VCard("罗立树的名片").setEmail("luolishu@58.com")
				.setAddress("北京市场朝阳区")
				.setTitle("高级架构师").setCompany("58同城.")
				.setPhonenumber("13581837598").setWebsite("www.looktuan.com");
		FileOutputStream fos=new FileOutputStream("/tmp/test.jpg");
		QRCode.from(johnDoe).to(ImageType.JPG).withCharset("UTF-8").writeTo(fos);
		fos.close();
	}
}
