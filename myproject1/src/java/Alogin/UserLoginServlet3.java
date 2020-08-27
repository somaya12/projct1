/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alfjer
 */@WebServlet("/login2")
public class UserLoginServlet3 extends HttpServlet {

   

    private static final long serialVersionUID = 1L;
 
    public UserLoginServlet3() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Aid = request.getParameter("Aid");
        String Apassword = request.getParameter("Apassword");
         
        AUserDAO userDao = new AUserDAO();
         
        try {
            Auser user = userDao.checkLogin(Aid,Apassword);
            String destPage = "Adminlogin.jsp";
             
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "adminPage.jsp";
            } else {
                String message = "Invalid id/password";
                request.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }}        }
    
