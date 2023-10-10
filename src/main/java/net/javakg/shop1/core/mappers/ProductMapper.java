package net.javakg.shop1.core.mappers;

import net.javakg.shop1.core.models.dtos.product.CreatedProductDto;
import net.javakg.shop1.core.models.dtos.product.ProductDto;
import net.javakg.shop1.core.models.dtos.product.UpdatedProductDto;
import net.javakg.shop1.core.models.entities.ProductEntity;

public class ProductMapper {

    public ProductDto toDomain(ProductEntity model) {
        return ProductDto.builder()
                .id(model.getId())
                .name(model.getName())
                .cost(model.getCost())
                .build();
    }

    public ProductEntity fromDomain(CreatedProductDto model) {
        return ProductEntity.builder()
                .name(model.getName())
                .cost(model.getCost())
                .build();
    }

    public ProductEntity fromDomain(UpdatedProductDto model) {
        return ProductEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .cost(model.getCost())
                .build();
    }

}
