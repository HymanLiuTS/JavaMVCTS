package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

//@ControllerAdvice // 定义全局异常处理的方法二：@ControllerAdvice 该注解定义全局异常处理类
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
		return createModelAndView(request, "500", HttpStatus.INTERNAL_SERVER_ERROR, e);
	}

	private ModelAndView createModelAndView(HttpServletRequest request, String viewName, HttpStatus status,
			Exception e) {
		ModelAndView mav = new ModelAndView();
		if (e != null) {
			mav.addObject("error", request.getAttribute(WebUtils.ERROR_MESSAGE_ATTRIBUTE));
			mav.addObject("servletName", request.getAttribute(WebUtils.ERROR_SERVLET_NAME_ATTRIBUTE));
		}
		mav.setViewName("error");
		return mav;
	}
}
