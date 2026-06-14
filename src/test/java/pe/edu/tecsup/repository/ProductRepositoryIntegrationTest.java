package pe.edu.tecsup.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.model.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductRepositoryIntegrationTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void guardarYListar() {
        Product p = new Product();
        p.setNombre("Mouse");
        p.setPrecio(50.0);
        repository.save(p);

        List<Product> lista = repository.findAll();
        assertFalse(lista.isEmpty());
    }
}
