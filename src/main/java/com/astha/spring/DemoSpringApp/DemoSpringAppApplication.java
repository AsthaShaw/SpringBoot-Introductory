package com.astha.spring.DemoSpringApp;

import com.astha.spring.DemoSpringApp.enterprise.example.web.MyWebController;
import com.astha.spring.DemoSpringApp.game.GameRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoSpringAppApplication {

	public static void main(String[] args) {

	    //Application context will manage the lifecycle of the created instances
        ConfigurableApplicationContext context = SpringApplication.run(DemoSpringAppApplication.class, args);// creates the application context
//MarioGame game=new MarioGame();

        //Spring framework through component and autowired will manage the creation of the these classes
       // GamingConsole game =new SuperContraGame();
       // GameRunner runner=new GameRunner(game);
       // runner.run();

        GameRunner runner = context.getBean(GameRunner.class);
        runner.run();

        MyWebController controller = context.getBean(MyWebController.class);
        System.out.println(controller.returnValueFromBusinessService());

    }

}
