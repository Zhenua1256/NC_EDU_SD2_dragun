package com.netcracker.dragun;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NCApplication {
    public static void main(String[] args) {
        SpringApplication.run(NCApplication.class, args);
    }

}
