package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.revature.model.Imbursements;
import com.revature.service.Servicer;

@WebServlet(urlPatterns = {"/getAllReimbursements"})
@MultipartConfig
public class populateTableServlet extends HttpServlet{
    
    Servicer s = new Servicer();
    Gson gson = new Gson();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
      List<Imbursements> myReimbursements = s.serviceGetAllReimbursements(Integer.parseInt(req.getParameter("id")));
      
      PrintWriter out = resp.getWriter();
      resp.setContentType("application/json");
      resp.setCharacterEncoding("UTF-8");
     if(myReimbursements !=null) {
         Type listType = new TypeToken<List<Imbursements>>() {}.getType();
          Gson gson = new Gson();
          String json = gson.toJson(myReimbursements, listType);
          List<Imbursements> target2 = gson.fromJson(json, listType);
          out.print(json);
          out.flush();
     } else {
         out.print(this.gson.toJson(null).toString());
         out.flush();  
     }
     }
 
      
    }

