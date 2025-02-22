package unicam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import unicam.repository.Data;

@SpringBootApplication
public class ProgettoFilieraAgricolaApplication {

    public static void main(String[] args) {
        Data.getIstance();
        SpringApplication.run(ProgettoFilieraAgricolaApplication.class, args);
    }

}
