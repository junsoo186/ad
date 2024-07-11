package com.allduck.controller;

import java.io.IOException;

import com.allduck.model.UserDAO;
import com.allduck.model.UserDAOImpl;
import com.allduck.model.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public UserController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		userDAO = new UserDAOImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action : "+action);
		switch (action ) {
		case"/Main":
			request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);
			break;
		case "/signIn" :
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			break;
		case"/signUp":
			request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
		case"/signUpFin":
			request.getRequestDispatcher("/WEB-INF/views/signupfin.jsp").forward(request, response);
		break;
		}
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/signUp":
			signUp(request, response);
			break;
		case "/signIn" :
			signIn(request, response);
			break;
		}

	}

	/*
	 * 
	 * 
	 * */

	private void signIn(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		// 유효성 검사
		if(id==null || password.trim().isEmpty()) {
			response.sendRedirect("signIn?message=invalid");
			return;
		}
		
		// 빠른 검사
		UserDTO user= userDAO.getUserById(id);
		if(user!=null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", user);
			// 로그인 --> todoForm 화면 이동 처리
			response.sendRedirect("/ad/user/main");
			System.out.println("로그인 처리 완료");
		} else {
			response.sendRedirect("signIn?message=invalid");
			
		}
		// null <--- 회원가입 x
		// 비밀번호 == dto.getPassword();
	}
	
	
	
	private void signUp(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String id = request.getParameter("id");
		String password = request.getParameter("passwordd");
		String created_at = request.getParameter("created_at");
		
		
		if(id ==null || id.trim().isEmpty()) {
			request.setAttribute("errorMessage", "사용자 아이디 입력 필요");
			request.getRequestDispatcher("/WEB-INF/views/signUp.jsp").forward(request, response);
			return;
		}
		
		UserDTO userDTO = UserDTO.builder()
				.name(name)
				.age(age)
				.gender(gender)
				.id(id)
				.password(password)
				.build();
		int resultRowCount = userDAO.addUser(userDTO);
		System.out.println(resultRowCount);
		if(resultRowCount == 1) {
			response.sendRedirect("/ad/user/signUpFin");
		}else {
			response.sendRedirect("/ad/user/signUp?message=error");
		}
		
	}
}
