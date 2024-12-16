package ru.floda.ecommerce.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.floda.ecommerce.dto.*;
import ru.floda.ecommerce.exception.ResourceNotFoundException;
import ru.floda.ecommerce.service.AdminService;
import ru.floda.ecommerce.service.CategoryService;
import ru.floda.ecommerce.service.OrderService;
import ru.floda.ecommerce.service.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;
    private final OrderService orderService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.findAllUsers());
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> findAllOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.findAllOrders());
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> findAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAllCategories());
    }

    @PostMapping("/category/new")
    public ResponseEntity<CategoryDto> createNewCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto dto = categoryService.createNewCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        CategoryDto dto = categoryService.findCategoryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Категория с id: " + id + " не найдена"));
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        CategoryDto dto = categoryService.updateCategory(id, categoryDto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllProducts());
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewDto>> findAllReviews() {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.findAllReviews());
    }
}
