package springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import springframework.domain.Product;
import springframework.services.ProductService;

/**
 * Created by jeffrey.lima on 4/8/2016.
 */
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    public Product get(Long id){
        return productService.getProduct(id);
    }
}
