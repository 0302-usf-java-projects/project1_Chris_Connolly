package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.revature.config.ConnectionUtil;
import com.revature.model.Imbursements;
import com.revature.model.userAccounts;

public class ersDao implements DaoInterface<userAccounts, Imbursements>{

  public String hashPassword(String username,String password) {
    System.out.println(username);
  try(Connection conn = ConnectionUtil.connect()){
    String sql = "{ ? = call hashPass(?,?) }"; 
    CallableStatement cs = conn.prepareCall(sql);
    cs.registerOutParameter(1, Types.VARCHAR);
    cs.setString(2, username);
    cs.setString(3, password);
    cs.execute();
    String pass = cs.getString(1);
    System.out.println(pass);
    cs.close();
    return pass;
  }catch(SQLException e) {
    e.printStackTrace();
  }
  return null;
}
  
  @Override
  public userAccounts Login(String username, String password) {
    String pass = hashPassword(username, password);
    
    try (Connection conn = ConnectionUtil.connect()) {
      String sql2 = "select * from users where username = ? and pass = ?";
      PreparedStatement ps = conn.prepareStatement(sql2);
      ps.setString(1, username);
      ps.setString(2, pass);
      // result set will refer to a record in database
      ResultSet rs = ps.executeQuery();
     
      if(rs.next()) {
        userAccounts ua = new userAccounts(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
        ua.setUsername(rs.getString(2));
        ua.setPassword(rs.getString(3));
        ua.setFirstName(rs.getString(4));
        ua.setLastName(rs.getString(5));
        ua.setEmail(rs.getString(6));
        ua.setUserRole(rs.getInt(7));
        return ua;
      } else {
        return null;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<Imbursements> GetAllImbursements(int id) {
    try(Connection conn = ConnectionUtil.connect()) {
      String sql = "select * from tree_reimbursement INNER JOIN users ON users.userId = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      List<Imbursements> imburseList = new ArrayList<Imbursements>();
      while(rs.next()) {
        imburseList.add(new Imbursements(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
      }
      ps.close();
      return (imburseList);
    } catch(SQLException e) {
      e.printStackTrace();
    }
    return null;
    
    
  }

  @Override
  public boolean addReimbursement(Imbursements i) {
   
    try(Connection conn = ConnectionUtil.connect()) {
      String sql = "insert into tree_reimbursement (imb_amount, imb_submitted, imb_description, imb_author, imb_statusid, imb_typeId) values (?,?,?,?,?,?)";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setDouble(1, i.getImbAmount());
      
      Date now = new java.util.Date();
      Timestamp current = new java.sql.Timestamp(now.getTime());
      
      ps.setTimestamp(2, current);
      ps.setString(3, i.getImbDescription());
      ps.setInt(4, i.getImbAuthor());
      ps.setInt(5, 1);
      ps.setInt(6, i.getImbType());
      ps.executeUpdate();

      ps.close();
      return true;
     
    } catch(SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean approveOrDeny(int reimbData, int status) {
    try(Connection conn = ConnectionUtil.connect()) {
      String sql = "update tree_reimbursement set imb_statusId = " + status + " where imb_id = " + reimbData;
      Statement s =  conn.createStatement();
      int rs = s.executeUpdate(sql);
      return true;
      
    } catch(SQLException e){
      e.printStackTrace();
    }
    return false;
    }
  
  
  
  
  
  
  
  
  }
    
    
    


