<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <% 
 	pageContext.setAttribute("msg", "안녕하세요");
 %>
 
 
 <!-- 변수공유 됨 -->
 <%@ include file="./header.jsp" %>
 
 <%@ include file="./main.jsp" %>
 
 <%@ include file="./footer.jsp" %>


<!-- 변수공유 안됨 -->
<%-- <jsp:include page="./header.jsp"></jsp:include>

<jsp:include page="./main.jsp"></jsp:include>

<jsp:include page="./footer.jsp"></jsp:include> --%>