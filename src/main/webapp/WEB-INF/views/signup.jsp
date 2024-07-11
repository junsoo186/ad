<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp"%>
<div class="body">
    <div class="signup_body">
        <div class="signup_box">
 <h2 class="title_signup">회원가입</h2>
            <form action="/ad/user/signUp" method="post" class="signup-form">
                <input type="text" name="name" id="name" class="input-field" value="이름">
                <input type="number" name="age" id="age" class="input-field" value="나이">
                <select name="gender" id="gender" class="input-field">
                    <option value="male">남자</option>
                    <option value="female">여자</option>
                </select>
                <input type="text" name="id" id="id" class="input-field" value="아이디">
                <input type="text" name="password" id="password" class="input-field" value="비밀번호">
                <button type="submit">가입하기</button>
            </form>
        </div>
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

.title_signup {
    color: #333;
    text-align: center;
}

.signup_body {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 20px;
}

.signup_box {
    background-color: #fff;
    padding: 30px;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    max-width: 320px;
    width: 100%;
}

.signup-form {
    display: flex;
    flex-direction: column;
}

.input-field {
    margin-bottom: 15px;
    padding: 12px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: #f9f9f9;
    transition: border-color 0.3s ease;
}

.input-field:focus {
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
}

button:hover {
    background-color: #ff8f00;
}
</style>
<%@ include file="footer.jsp"%>