package com.revature.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.model.userAccounts;

@WebServlet(urlPatterns = {"/manager"})
public class ManagerServlet extends HttpServlet{
  userAccounts ua = new userAccounts();
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher view = req.getRequestDispatcher("html/manager.html");
    view.forward(req, resp);
    
  }
}