<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp"%>



<div class="container">
        <section class="main-content">
            <h1>환영합니다! ALL DUCK!</h1>
            <p> 아직 게시된 패이지가 없습니다.</p>
            <a href="#" class="btn">아직없음</a>
        </section>
    </div>
    
    <style>
	
.container {
    max-width: 960px;
    margin: 0 auto;
    padding: 20px;
}

.main-content {
    background-color: #ffffff;
    padding: 20px;
    margin-top: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    text-align: center;
}

.main-content h1 {
    font-size: 2.5em;
    color: #333333;
}

.main-content p {
    font-size: 1.2em;
    color: #666666;
    line-height: 1.6;
}

.btn {
    display: inline-block;
    padding: 10px 20px;
    background-color: #007bff;
    color: #ffffff;
    text-decoration: none;
    border-radius: 5px;
    margin-top: 15px;
    transition: background-color 0.3s ease;
}

.btn:hover {
    background-color: #0056b3;
}
	</style>
<%@ include file="footer.jsp"%>