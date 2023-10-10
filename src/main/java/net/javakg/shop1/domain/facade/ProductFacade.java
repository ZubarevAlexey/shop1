package net.javakg.shop1.domain.facade;

import net.javakg.shop1.core.contracts.facades.IProductFacade;
import net.javakg.shop1.core.contracts.services.IProductService;
import net.javakg.shop1.core.exceptions.EntityDuplicateExceptions;
import net.javakg.shop1.core.exceptions.EntityNotFoundException;
import net.javakg.shop1.core.models.dtos.product.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductFacade implements IProductFacade {
    private final IProductService productService;

    public ProductFacade(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDto register(CreatedProductDto model) throws EntityDuplicateExceptions {
        return productService.register(model);
    }

    @Override
    public ProductDto update(UpdatedProductDto model) throws EntityNotFoundException {
        return productService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteProductDto model) throws EntityNotFoundException {
        return productService.delete(model);
    }

    @Override
    public ProductDto getById(GetByIdProductDto model) throws EntityNotFoundException {
        return productService.getById(model);
    }
}
