package springframework.repositories;

import org.springframework.stereotype.Repository;
import springframework.domain.Product;

/**
 * Created by jeffrey.lima on 4/8/2016.
 */
@Repository
public class ProductRepository {
    public Product getProduct(Long id){
        Product product = new Product();
        product.setDescription("Spring Guru in Action!");
        return product;
    }
}
