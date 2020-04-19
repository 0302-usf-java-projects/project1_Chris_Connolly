package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.model.userAccounts;
import com.revature.service.Servicer;


@WebServlet(urlPatterns = {"/login"})
@MultipartConfig
public class LoginServlet extends HttpServlet {
  
  Servicer s = new Servicer();
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    userAccounts ua = s.serviceLogin(req.getParameter("username"), req.getParameter("password"));
    System.out.println(req.getParameter("password"));
    resp.setContentType("application/json");
    PrintWriter out = resp.getWriter();
    
    resp.setCharacterEncoding("UTF-8");
    Gson gson = new Gson ();
    
    if(ua != null) {
      
      out.print(gson.toJson(ua).toString());
      out.flush();
    }
    else {
      System.out.println("it's not ok from LoginServlet");
      out.print(gson.toJson(null));
      out.flush();
    }
    
    
  }
  
  
  
  
  
}

