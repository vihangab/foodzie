package foodzie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "foodzie"
})
public class FoodzieApplication {

  public static void main(String[] args) {
    SpringApplication.run(FoodzieApplication.class, args);
  }

}
