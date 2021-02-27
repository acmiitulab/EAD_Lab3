package com.example.EAD_lab2.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {


        Cookie[] cookies = ((HttpServletRequest)req).getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("logined")) {
                if (cookie.getValue().equals("true"))  {
                    System.out.println(cookie.getName() + ": " + cookie.getValue() );
                }
            }
        }
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " " + password);

        filterChain.doFilter(req, resp);



    }

    public void destroy() {

    }
}
