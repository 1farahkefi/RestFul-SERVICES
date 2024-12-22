/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ws.RestService;



/**
 *
 * @author User
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ws.RestService")
@EntityScan(basePackages = "Model")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

