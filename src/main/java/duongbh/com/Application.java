package duongbh.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = { "duongbh.com", "duongbh.com.dao" })
@EntityScan("duongbh.com.entity")
@EnableJpaRepositories(basePackages = { "duongbh.com.repository" })
@EnableSwagger2
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
