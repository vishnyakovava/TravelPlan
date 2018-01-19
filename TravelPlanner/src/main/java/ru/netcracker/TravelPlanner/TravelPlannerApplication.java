package ru.netcracker.travelPlanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.netcracker.travelPlanner.config.AppConfig;
import ru.netcracker.travelPlanner.entities.User;
import ru.netcracker.travelPlanner.service.UserService;

import java.util.Date;

//@SpringBootApplication
public class TravelPlannerApplication {

	/*public static void main(String[] args) {
		SpringApplication.run(TravelPlannerApplication.class, args);
	}*/

    public static void main(String[] args) {
        //ApplicationContext это BeanFactory, даёт возможность доступа к бинам, которые
        //инициализ., связаны и управляемы Spring-контейнером Ioc(Inversion Of Control)
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //Начало работы с юзерами(получение бина)
        UserService userService = context.getBean(UserService.class);

        //Добавление юзеров в БД
        userService.add(new User("test3@email.com", "Mask", "Ilon", new Date(),
                                 false, new Date(), "123"));
        userService.add(new User("test2@email.com", "Hocking", "Stiven", new Date(),
                false, new Date(), "1238"));

        context.close();
    }
}
