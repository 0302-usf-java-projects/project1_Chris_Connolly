package com.revature.dao;

import java.util.List;

public interface DaoInterface <T, I>{

  T Login(String username, String password);
  List<I> GetAllImbursements(int id);
  boolean addReimbursement(I i);
  boolean approveOrDeny(int reimbData, int status);
  
  
  
}
