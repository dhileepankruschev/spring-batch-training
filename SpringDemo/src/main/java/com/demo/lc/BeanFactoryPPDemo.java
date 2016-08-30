package com.demo.lc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

public class BeanFactoryPPDemo implements BeanFactoryPostProcessor  
{

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();  
		cfg.setLocation(new FileSystemResource("shape.properties"));  
		cfg.postProcessBeanFactory(beanFactory); 
		System.out.println("Bean factory post processor is initialized");

		
	}
//@Override
//public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
// {
// PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();  
// cfg.setLocation(new FileSystemResource("shape.properties"));  
// cfg.postProcessBeanFactory(beanFactory); 
// System.out.println("Bean factory post processor is initialized");
// }
}
