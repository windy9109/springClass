package com.jsp.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestParamterAdaper {
	public static <T>T execute(HttpServletRequest request, Class<T> className)throws Exception {
		request.setCharacterEncoding("utf-8");
		
		Method[] methods = className.getMethods();
		T obj = className.newInstance(); //출력때문에 obj를 리턴하기위해
		
		for(Method method : methods) {
			if(method.getName().indexOf("set") == 0) {
				String requestParamName = method.getName().replace("set", "");
				requestParamName = (requestParamName.charAt(0)+"").toLowerCase()+requestParamName.substring(1);
				
				String[] paramValues = request.getParameterValues(requestParamName);
				
				if(paramValues != null && paramValues.length>0) {
					if(method.getParameterTypes()[0].isArray()) {
						method.invoke(obj, new Object[] {paramValues});
					}else {
						method.invoke(obj, paramValues[0]);
					}
				}
			}
			
		}
		return obj;
	}
}
