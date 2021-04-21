package com.webDevelopment.inventorySytemDDD;

import com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Commands.ConsoleCommand;
import com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Commands.TestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
@ImportResource("classpath:dependencies.xml")
public class InventorySytemDddApplication {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		SpringApplication.run(InventorySytemDddApplication.class, args);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("rabbitDependencies.xml");
		ConsoleCommand command = applicationContext.getBean(TestCommand.class);
		command.execute();
	}
}
