package ie.atu.week4;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public boolean editProduct(long id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if(existingProduct.isPresent()){
            Product oldProduct = existingProduct.get();

            oldProduct.setName(updatedProduct.getName());
            oldProduct.setPrice(updatedProduct.getPrice());

            productRepository.save(oldProduct);
            return true;
        }
        return false;
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

}
