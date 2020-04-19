package project1;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.revature.dao.ersDao;
import com.revature.service.Servicer;

public class JunitTests {
  
  Servicer s = new Servicer();
  ersDao dao = new ersDao();
  
  @Test
  public void testManagerLogin(){
    assertTrue(s.serviceLogin("Theo", "password") !=null);
  }
  
  @Test
  public void testEmployeeLogin() {
    assertTrue(s.serviceLogin("ryan", "password") != null);
  }
  
  @Test
  public void hashPasswordTest() {
   String hpass = dao.hashPassword("Moe", "password");
   assertTrue(hpass.equals("password") != true);
    
  }
  
  
  

}
