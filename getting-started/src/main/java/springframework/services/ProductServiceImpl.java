package springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springframework.domain.Product;
import springframework.repositories.ProductRepository;

/**
 * Created by jeffrey.lima on 4/8/2016.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.getProduct(id);
    }
}
