package tech.hidetora.nativeimagedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import tech.hidetora.nativeimagedemo.entity.Customer;
import tech.hidetora.nativeimagedemo.repository.CustomerRepository;

import java.util.List;

@SpringBootApplication
@Slf4j
public class NativeImageDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NativeImageDemoApplication.class, args);
    }

    @Bean
    @Profile("!test")
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        log.info("================= Initialization ================");
        return args -> {
            List<Customer> customers = List.of(
                    Customer.builder()
                            .firstName("Mohamed").lastName("Youssfi").email("med@gmail.com").build(),
                    Customer.builder()
                            .firstName("Ahmed").lastName("Yassine").email("ahmed@gmail.com").build(),
                    Customer.builder()
                            .firstName("Hanane").lastName("yamal").email("hanane@gmail.com").build()
            );
            customerRepository.saveAll(customers);
        };
    }
}
