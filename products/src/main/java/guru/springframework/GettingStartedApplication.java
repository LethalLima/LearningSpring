package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import springframework.controller.ProductController;
import springframework.domain.Product;

@ComponentScan("springframework")
@SpringBootApplication
public class GettingStartedApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GettingStartedApplication.class, args);

		ProductController controller = (ProductController) ctx.getBean("productController");

		Product product = controller.get(1l);

		System.out.println("Result of Controller Action: ");
		System.out.println(product.getDescription());

		System.exit(0);

	}
}