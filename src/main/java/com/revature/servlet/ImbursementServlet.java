package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.model.Imbursements;
import com.revature.service.Servicer;

@WebServlet(urlPatterns = {"/addImbursement"})
@MultipartConfig
public class ImbursementServlet extends HttpServlet{
    
    Servicer s = new Servicer();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
      s.serviceAddReimbursement(new Imbursements(Double.parseDouble(req.getParameter("amount")), req.getParameter("desc"), Integer.parseInt(req.getParameter("author")), Integer.parseInt(req.getParameter("type"))));
      
    }
    
    
    
    
    
  }
