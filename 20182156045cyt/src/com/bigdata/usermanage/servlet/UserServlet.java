package com.bigdata.usermanage.servlet;

import com.bigdata.usermanage.entity.User;
import com.bigdata.usermanage.service.UserService;
import com.bigdata.usermanage.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//
//@WebServlet("/userServlet")
//public class UserServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//
//        UserService service = new UserServiceimpl();
//        User user = new User();
//        request.setAttribute("user",user);
//        //转发到list.jsp
//        request.getRequestDispatcher("/list.jsp").forward(request,response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
//}
