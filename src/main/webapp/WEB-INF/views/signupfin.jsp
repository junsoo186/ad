<%@page import="com.allduck.model.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp"%>
 <% String id = request.getParameter("id"); %>
	<div class="all">
	<div class= "signup_box">
	<title>가입성공</title>
	
	<h2 class="title">가입 성공</h2>
	<div class="fin_body">
	<form action="/ad/user/signIn" method="get">
	<p>환영합니다.</p>
		<button type="submit"> 로그인</button>
	</form>
	</div>
	</div>
	</div>
	
	<style>
	.signup_box{
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 10%;
	border: 1px,solid,gray;
	width: 300px;
	
	}
	.all{
		display: flex;
    	justify-content: center;
	}
	
	
	
	</style>
<%@ include file="footer.jsp"%>