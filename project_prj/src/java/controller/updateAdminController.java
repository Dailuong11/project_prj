/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CompanyDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.company;

/**
 *
 * @author Vu Dai Luong
 */
public class updateAdminController extends HttpServlet {

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
        String id = request.getParameter("sid");
        CompanyDAO dao = new CompanyDAO();
        company cp = dao.getCompanyByID(id);
        request.setAttribute("cp", cp);
        request.getRequestDispatcher("http://localhost:8080/home/admin/dashboard").forward(request, response);
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
        processRequest(request, response);
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
            String sid = request.getParameter("id");
            String sname = request.getParameter("name");
            int squantity = Integer.parseInt(request.getParameter("quantity"));
            double ssalary = Double.parseDouble(request.getParameter("salary"));
            String sdescription = request.getParameter("description");
            String simagine = request.getParameter("imagine");
            String phone = request.getParameter("phone");
            Date screate_date = Date.valueOf(request.getParameter("create_date"));
            String scategory = request.getParameter("Category_id");
            String sprofession = request.getParameter("profession");
            CompanyDAO dao = new CompanyDAO();
            dao.updateStudent(sid, sname, squantity, ssalary, sdescription, simagine, screate_date, phone, squantity, sprofession);
            response.sendRedirect("http://localhost:8080/home/admin/dashboard");
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
