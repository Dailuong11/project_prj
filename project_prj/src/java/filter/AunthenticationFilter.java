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
@WebFilter(filterName = "AunthenticationFilter", urlPatterns = {"/add-to-card","/admin/*"})
public class AunthenticationFilter implements Filter {

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
        //Kiểm tra đăng nhập
        account a = (account) session.getAttribute("a");

        if (a != null) {
            //cho qua
            chain.doFilter(request, response);
        } else {
            //check cookie
            //kiểm tra cookie
            Cookie[] cookies = req.getCookies();
            String username = null;
            String password = null;
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("user")) {
                    username = cooky.getValue();
                }
                if (cooky.getName().equals("pass")) {
                    password = cooky.getValue();
                }
                if (username != null && password != null) {
                    break;
                }
            }

            if (username != null && password != null) {
                account accountLogin = new accountDAO().login(username, password);
                if (a != null) { //cookie hợp lệ
                    session.setAttribute("a", a);
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
     *
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {

    }

}

