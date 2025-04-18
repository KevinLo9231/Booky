package com.booky.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取得表單資料
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String url = "jdbc:sqlserver://localhost:1433;databaseName=booky_db;encrypt=true;trustServerCertificate=true";
		String dbUser = "sa";
		String dbPassword = "P@ssw0rd"; // 請替換成你實際設的密碼

		try {
			// ✅ 必須手動註冊 driver，JDK 8 不會自動載入
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
					PreparedStatement stmt = conn
							.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");) {
				stmt.setString(1, username);
				stmt.setString(2, password);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					// 登入成功
					HttpSession session = request.getSession();
					session.setAttribute("user", username);
					response.sendRedirect(request.getContextPath() + "/user/home.jsp");
				} else {
					// 登入失敗
					//response.sendRedirect("login.jsp?error=1");
					request.setAttribute("loginFailed", true);
					request.getRequestDispatcher("auth/login.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("login.jsp?error=2");
		}
	}
}
