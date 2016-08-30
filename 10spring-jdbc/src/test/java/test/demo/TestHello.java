package test.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tkhts.service.HelloService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class TestHello {
	
	@Autowired
	HelloService service;

	@Test
	public void test() {
		//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		//Hello hello = context.getBean("hello", Hello.class);
		service.sayHello("ravi");
	}

}
