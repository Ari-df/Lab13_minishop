package pe.edu.tecsup.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.model.Product;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductService service;

    @Test
    void guardarYRecuperar() {
        Product p = new Product();
        p.setNombre("Laptop");
        p.setPrecio(1500.0);

        Product guardado = service.guardar(p);

        assertNotNull(guardado.getId());
        assertEquals("Laptop", guardado.getNombre());
        assertEquals(99999.0, guardado.getPrecio());
    }

    @Test
    void tieneDescuento_precioAlto() {
        Product p = new Product();
        p.setPrecio(1500.0);
        assertTrue(service.tieneDescuento(p));
    }

    @Test
    void tieneDescuento_precioBajo() {
        Product p = new Product();
        p.setPrecio(500.0);
        assertFalse(service.tieneDescuento(p));
    }
}
