<%@page import="java.util.StringTokenizer"%>
<%@page import="sun.util.locale.StringTokenIterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
	String source="a,b,d,e,f,g";
	String[] split = source.split(",");
	if(split != null) for(String str : split){
		out.println(str+"<br/>");
	}
	out.println("<hr/>");
	out.print("StringTokenizer : JAVA<br/>");
	
	StringTokenizer tokens = new StringTokenizer(source,",");
	while(tokens.hasMoreTokens()){
		out.println(tokens.nextToken()+"<br/>");
	}

%>

<hr/>
String.split() : JSTL
<c:set var="source" value="a,b,c,d,e,f,g" />
<c:set var="split" value="${source.split(',')}" />
<c:forEach items="${split}" var="str">
	${str} <br/>
</c:forEach>


<hr/>
StringTokenzer : JSTL<br/>
<c:forTokens var="str" items="a,b,c,d,e,f,g" delims="," varStatus="status">
	${str }<br>
</c:forTokens>


