package newDI.DI;

import newDI.DI.Config.AppConfig;
import newDI.DI.Entity.Person;
import newDI.DI.Enum.Grade;
import newDI.DI.service.ConvenienceStore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DiApplication implements CommandLineRunner {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

	ConvenienceStore convenienceStore = applicationContext.getBean("cs", ConvenienceStore.class);

	public static void main(String[] args) {
		SpringApplication.run(DiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person person = new Person(23L, "이충현", Grade.HIGH);
		convenienceStore.join(person);
		System.out.println(convenienceStore.FindPeople(person.getPersonid()));

	}
}
