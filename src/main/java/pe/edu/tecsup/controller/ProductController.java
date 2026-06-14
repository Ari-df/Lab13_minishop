package pe.edu.tecsup.controller;

import org.springframework.web.bind.annotation.*;
import pe.edu.tecsup.model.Product;
import pe.edu.tecsup.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Product crear(@RequestBody Product product) {
        return service.guardar(product);
    }
}
