package net.javakg.shop1.domain.services;

import net.javakg.shop1.core.contracts.services.IProductService;
import net.javakg.shop1.core.exceptions.EntityDuplicateExceptions;
import net.javakg.shop1.core.exceptions.EntityNotFoundException;
import net.javakg.shop1.core.mappers.ProductMapper;
import net.javakg.shop1.core.models.dtos.product.*;
import net.javakg.shop1.data.repo.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductDto register(CreatedProductDto model) throws EntityDuplicateExceptions {
        var product = productRepository.findByName(model.getName());
        if (product.isPresent()) throw new EntityDuplicateExceptions();
        var entity = productRepository.save(mapper.fromDomain(model));
        return mapper.toDomain(entity);
    }

    @Override
    public ProductDto update(UpdatedProductDto model) throws EntityNotFoundException {
        var product = productRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = product.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .cost(model.getCost())
                .build();
        productRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteProductDto model) throws EntityNotFoundException {
        var product = productRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        productRepository.delete(product);
        return HttpStatus.OK;
    }

    @Override
    public ProductDto getById(GetByIdProductDto model) throws EntityNotFoundException {
        var product = productRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return mapper.toDomain(product);
    }
}
