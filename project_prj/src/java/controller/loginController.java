/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.accountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.account;

/**
 *
 * @author Vu Dai Luong
 */
@WebServlet(name = "loginController", urlPatterns = {"/login"})
public class loginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        boolean remember = request.getParameter("remember") != null;
        accountDAO dao = new accountDAO();
        account a = dao.login(username, password);
        if (a != null) {
            if (remember) {
                Cookie usernameCookie = new Cookie("user", username);
                usernameCookie.setMaxAge(60*60*24);
                Cookie passwordCookie = new Cookie("pass", password);
                passwordCookie.setMaxAge(60*60*24);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }
         
             request.getSession().setAttribute("a", a);
             response.sendRedirect("dashboard");
        }
      
  
        
        else {
            request.setAttribute("error", "Username or password incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cookie[] cookies = request.getCookies();
            String username = null;
            String password = null;
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("username")) {
                    username = cooky.getValue();
                }
                if (cooky.getName().equals("password")) {
                    password = cooky.getValue();
                }
                if (username != null && password != null) {
                    break;
                }
            }
            if (username != null && password != null ) {
                account a = new accountDAO().login(username, password);
                if (a != null && a.getRole().equals(account.ADMIN)) { 
                      
                    
                    request.getSession().setAttribute("a", a);
                    response.sendRedirect("../dashboard.jsp");
                    return;
                }
                if (a != null) {
                    request.getSession().setAttribute("a", a);
                    response.sendRedirect("index.jsp");
                    return;
                }
            }
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}