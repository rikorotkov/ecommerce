package ru.floda.ecommerce.api.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.floda.ecommerce.dto.ProductDto;
import ru.floda.ecommerce.exception.ResourceNotFoundException;
import ru.floda.ecommerce.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> finnAllProducts() {
        List<ProductDto> products = productService.findAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long id) {
        ProductDto dto = productService.findProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Товар с id: " + id + "не найден"));
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/new")
    public ResponseEntity<ProductDto> createNewProduct(@RequestBody ProductDto productDto) {
        ProductDto dto = productService.createNewProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping()
    public ResponseEntity<ProductDto> updateProduct(@RequestBody Long id, ProductDto dto) {
        dto = productService.updateProduct(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping()
    public ResponseEntity<ProductDto> deleteProduct(Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
