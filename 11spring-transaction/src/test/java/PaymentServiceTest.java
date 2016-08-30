

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tkhts.dao.AccountDao;
import com.tkhts.entity.Account;
import com.tkhts.service.PaymentService;


public class PaymentServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testFundsTransfer(){
		
		ApplicationContext context = new 
                ClassPathXmlApplicationContext("beans.xml");
		PaymentService service = (PaymentService) context.getBean("paymentService");
		try {
			service.fundsTransfer(1, 2, 50d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	}
	
	

}
