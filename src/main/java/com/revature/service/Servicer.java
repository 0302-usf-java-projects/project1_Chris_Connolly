package com.revature.service;

import java.util.List;
import com.revature.dao.ersDao;
import com.revature.model.Imbursements;
import com.revature.model.userAccounts;

public class Servicer {

  ersDao ed = new ersDao();
  
    public userAccounts serviceLogin(String username, String password) {
      return ed.Login(username, password);
    }
  
    public boolean serviceAddReimbursement(Imbursements i) {
      return ed.addReimbursement(i);
    }
    
    public List<Imbursements> serviceGetAllReimbursements(int id){
      return ed.GetAllImbursements(id);
    }
    
    public boolean serviceApproveDeny(int reimbData, int status) {
      return ed.approveOrDeny(reimbData, status);
    }
    
}
