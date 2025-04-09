package com.booky.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        System.out.println("收到帳號：" + user + "，密碼：" + pass);

        if ("bigred".equals(user) && "bigred".equals(pass)) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
