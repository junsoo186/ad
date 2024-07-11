<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp"%>

<title>로그인 창</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div class= "body">
	<div class="login-container">
		<form action="/ad/user/signIn"class="login-form" method="post">
			<h2>로그인</h2>
			<div class="input-container">
				<label for="id">아이디</label> <input type="text" id="id" name="id" required>
			</div>
			<div class="input-container">
				<label for="password">비밀번호</label> <input type="password" id="password" name="password" required>
			</div>
			<button type="submit">로그인</button>
		</form>
	</div>
	</div>
	<style>
	
.body {
    background-color: #f0f0f0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}


.login-container {
    background-color: #fff;
    padding: 30px;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    max-width: 320px;
    width: 100%;
}

.login-form {
    display: flex;
    flex-direction: column;
}

.login-form h2 {
    color: #000;
    text-align: center;
    margin-bottom: 20px;
    font-size: 24px;
}

.input-container {
    margin-bottom: 15px;
}

.input-container label {
    color: #000;
    margin-bottom: 8px;
    font-weight: bold;
    display: block;
}

.input-container input {
    padding: 12px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: #f9f9f9;
    transition: border-color 0.3s ease;
    width: 100%;
    box-sizing: border-box;
}

.input-container input:focus {
    outline: none;
    border-color: #f9a825;
}

button {
    padding: 12px;
    font-size: 16px;
    color: #fff;
    background-color: #f9a825;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s ease;
    width: 100%;
}

button:hover {
    background-color: #ff8f00;
}
</style>
	<%@ include file="footer.jsp"%>