package com.lepeng.admin.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.google.common.base.Throwables;
import com.lepeng.admin.exception.BusinessException;
import com.lepeng.admin.exception.ParameterException;


public abstract class BaseController {
	
	protected static final String ERROR = "error/error";
	protected static final String SUCCESS = "success";
	
	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
	


	@Autowired
	@Value(value = "${page.size}")
	protected int pageSize;

    /**
     * 全局异常处理类，错误页面。
     * @param ex 异常。
     * @param request 用户请求。
     * @return 异常显示视图。
     */
    @ExceptionHandler
    protected String handleException(HttpServletRequest request, Exception ex) { 
    	String message = Throwables.getStackTraceAsString(ex);
    	LOGGER.error(Throwables.getStackTraceAsString(ex));
		String description = ex.getMessage();
		request.setAttribute("description", description);
		request.setAttribute("simpleName", Throwables.getRootCause(ex).getClass().getName());
		request.setAttribute("message", message);
		if(ex instanceof IncorrectCredentialsException){
			return "redirect:/login";
		} else if (ex instanceof UnauthorizedException) {
			return "redirect:/login";
		} else if (ex instanceof BusinessException) {
			return "error/error-business";
		} else if (ex instanceof ParameterException) {
			return "error/error-parameter";
		} else {
			return "error/error";
		}
    }

    /**
     * 取当前登录用户的ID
     * @return
     */
    protected Integer getUserId() {
    	Integer userId = 0;
    	return userId;
    }
}