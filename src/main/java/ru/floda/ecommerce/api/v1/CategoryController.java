package ru.floda.ecommerce.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.floda.ecommerce.dto.CategoryDto;
import ru.floda.ecommerce.exception.ResourceNotFoundException;
import ru.floda.ecommerce.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.findAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        CategoryDto dto = categoryService.findCategoryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Категория с id: " + id + " не найдена"));
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/new")
    public ResponseEntity<CategoryDto> createNewCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto dto = categoryService.createNewCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        CategoryDto dto = categoryService.updateCategory(id, categoryDto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
