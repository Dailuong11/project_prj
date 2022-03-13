/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import dao.accountDAO;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.account;

/**
 *
 * @author Vu Dai Luong
 */
@WebFilter(filterName = "Authenticationfilter", urlPatterns = {"/add-to-card", "/admin*"})
public class Authenticationfilter implements Filter {

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        //kiem tra dang nhap
        account ac = (account) session.getAttribute("ac");
        
        if (ac != null) {
            //cho qua
            chain.doFilter(request, response);
        }else{
           // check cookie
                  Cookie[] cookies = req.getCookies();
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
            if (username != null && password != null) {
                account aclogin = new accountDAO().login(username, password);
                if (ac != null) { // cookie hop le
                    session.setAttribute("ac", ac);
                    chain.doFilter(request, response);
                    return;
                }
            }
            res.sendRedirect("login");
        }
        
    }

    /**
 * Destroy method for this filter
 */
@Override
        public void destroy() {        
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
        public void init(FilterConfig filterConfig) {        
       
    }

}