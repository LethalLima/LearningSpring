package springframework.services;

import org.springframework.stereotype.Service;
import springframework.domain.Product;

/**
 * Created by jeffrey.lima on 4/8/2016.
 */
@Service
public interface ProductService {
    Product getProduct(Long id);
}
