package net.javakg.shop1.core.contracts.services;

import net.javakg.shop1.core.exceptions.EntityDuplicateExceptions;
import net.javakg.shop1.core.exceptions.EntityNotFoundException;
import net.javakg.shop1.core.models.dtos.product.*;
import org.springframework.http.HttpStatus;

public interface IProductService {
    ProductDto register(CreatedProductDto model) throws EntityDuplicateExceptions;

    ProductDto update(UpdatedProductDto model) throws EntityNotFoundException;

    HttpStatus delete(DeleteProductDto model) throws EntityNotFoundException;

    ProductDto getById(GetByIdProductDto model) throws EntityNotFoundException;
}
