package com.in28minutes.spring.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.in28minutes.spring.learnspringframework.enterprise.example.web.MyWebController;
import com.in28minutes.spring.learnspringframework.game.GameRunner;

//@ComponentScan(basePackages = "com.in28minutes.spring.learnspringframework")
//@ComponentScan({"com.package1", "com.package2"})

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context 
			= SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
		//MarioGame game = new MarioGame();
		//SuperContraGame game = new SuperContraGame();
		
		//GamingConsole game = new MarioGame();
		//GameRunner runner = new GameRunner(game);
		
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
		
		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());
	}

}
