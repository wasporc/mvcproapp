package org.mymvc;

import org.mymvc.entity.Product;
import org.mymvc.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            repository.save(new Product(1L , "Potato", 1.2));
            repository.save(new Product(2L , "Apple", 2.1));
            repository.save(new Product(3L , "Onion", 1.6));
        };
    }
}
