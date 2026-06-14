package pe.edu.tecsup.service;

import org.springframework.stereotype.Service;
import pe.edu.tecsup.model.Product;
import pe.edu.tecsup.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private static final double PRECIO_MINIMO_DESCUENTO = 1000.0;

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> listarTodos() {
        return repository.findAll();
    }

    public Product guardar(Product product) {
        return repository.save(product);
    }

    public boolean tieneDescuento(Product product) {
        return product.getPrecio() > PRECIO_MINIMO_DESCUENTO;
    }
}
