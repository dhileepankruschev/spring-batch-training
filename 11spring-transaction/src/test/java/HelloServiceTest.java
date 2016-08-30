

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tkhts.dao.AccountDao;
import com.tkhts.entity.Account;


public class HelloServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testCreateAccount(){
		
		ApplicationContext context = new 
                ClassPathXmlApplicationContext("beans.xml");
      AccountDao dao = (AccountDao) context.getBean("accountDao");
       
      Account account = new Account();
      account.setAccountName("Arun");
      account.setBalance(1000d);
      dao.createAccount(account);
    
	}
	
//	@Test
	public void testCreditAccount(){
		
		ApplicationContext context = new 
                ClassPathXmlApplicationContext("beans.xml");
      AccountDao dao = (AccountDao) context.getBean("accountDao");
       
  
     // dao.creditAccount(1,1000d);
    
	}

}
