package com.examen.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.lang.NonNull;

public class SesionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, 
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) 
    throws Exception {
        
        HttpSession sesion = request.getSession(false);

        // Permitir acceso a login y recursos estáticos 
        String uri = request.getRequestURI();
        if (uri.equals("/") || uri.equals("/login") || uri.equals("/logout") || uri.startsWith("/css") || uri.startsWith("/js")) {
            return true;
        }

        if (sesion != null && sesion.getAttribute("usuario") != null) {
            return true;
        }

        response.sendRedirect("/"); 
        return false;
    }
}
