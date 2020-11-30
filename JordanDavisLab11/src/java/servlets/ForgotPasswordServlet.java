/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

/**
 *
 * @author User
 */
public class ForgotPasswordServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        
        
        if (email == null) {
            request.setAttribute("message", "Please enter a valid email");
            getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
            return;
        }
        
        AccountService as = new AccountService();
        String path = getServletContext().getRealPath("/WEB-INF");
        
        as.forgotPassword(email, path);
        request.setAttribute("message", "An email has been sent");
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
        
        
        
    }

    
    

}
