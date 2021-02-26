package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/product")
public class ProductController {
    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct (@RequestParam int productId) {
        return new ProductDto(1, "sample product", "sample description", 2.5, 1);
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {

    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return new ProductDto (1, "edited sample product", "edited sample description", 2.5, 1);
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct() {

    }
}
