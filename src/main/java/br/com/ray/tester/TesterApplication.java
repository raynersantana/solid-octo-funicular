package br.com.ray.tester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
		org.springframework.ai.vectorstore.mongodb.autoconfigure.MongoDBAtlasVectorStoreAutoConfiguration.class
})
public class TesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesterApplication.class, args);
	}

}
