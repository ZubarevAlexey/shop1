package net.javakg.shop1.controllers.v1;

import net.javakg.shop1.core.contracts.facades.IProductFacade;
import net.javakg.shop1.core.exceptions.EntityDuplicateExceptions;
import net.javakg.shop1.core.exceptions.EntityNotFoundException;
import net.javakg.shop1.core.models.dtos.product.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductV1Controller {
    private final IProductFacade productFacade;

    public ProductV1Controller(IProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> add(@RequestBody CreatedProductDto model) {
        try {
            return ResponseEntity.ok(productFacade.register(model));
        } catch (EntityDuplicateExceptions e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ProductDto> update(@RequestBody UpdatedProductDto model) {
        try {
            return ResponseEntity.ok(productFacade.update(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteProductDto model) {
        try {
            return ResponseEntity.ok(productFacade.delete(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/id")
    public ResponseEntity<ProductDto> getById(@RequestBody GetByIdProductDto model) {
        try {
            return ResponseEntity.ok(productFacade.getById(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
