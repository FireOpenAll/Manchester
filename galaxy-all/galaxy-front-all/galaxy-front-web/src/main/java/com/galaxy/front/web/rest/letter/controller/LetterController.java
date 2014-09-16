package com.galaxy.front.web.rest.letter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.letter.LetterModel;
@RestController
@RequestMapping(value = "api/v1/letter")
public class LetterController {
	
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET})
	public Object post(){
		ResultModel result=new ResultModel();
		LetterModel model=new LetterModel();
		result.setData(model);
		return result;
		
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list(){
		LetterModel model=new LetterModel();
		return model;
	}

}
