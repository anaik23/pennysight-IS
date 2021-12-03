package sjsu.edu.cs151.PennySight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class is the main application to start
 * SpringApplication means @Configuration + @EnableConfiguration + @ComponentScan
 * @author PennySight
 */
@SpringBootApplication
public class PennySightApplication {
    public static void main(String[] args) {
        SpringApplication.run(PennySightApplication.class, args);
    }
}
