package test.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.Hello;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestHello {
	
	@Autowired
	Hello hello;

	@Test
	public void test() {
		//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		//Hello hello = context.getBean("hello", Hello.class);
		hello.sayHello();
	}

}
