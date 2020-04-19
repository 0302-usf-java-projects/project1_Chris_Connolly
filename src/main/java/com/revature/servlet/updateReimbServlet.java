package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.service.Servicer;

@WebServlet(urlPatterns = {"/updateReimb"})
@MultipartConfig
public class updateReimbServlet extends HttpServlet{
  
  Servicer s = new Servicer();
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    
    s.serviceApproveDeny(Integer.parseInt(req.getParameter("imbId")), Integer.parseInt(req.getParameter("status")));
  
  
  }
  
}
