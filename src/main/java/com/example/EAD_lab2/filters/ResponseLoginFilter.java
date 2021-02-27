package com.example.EAD_lab2.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ResponseLoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {


        Cookie [] cookies = ((HttpServletRequest)req).getCookies();

        for (Cookie cookie : cookies) {
            cookie.setMaxAge( 1800 );
        }

        filterChain.doFilter(req, resp);

    }

}