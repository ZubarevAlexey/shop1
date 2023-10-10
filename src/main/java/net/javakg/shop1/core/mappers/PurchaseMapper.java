package net.javakg.shop1.core.mappers;

import net.javakg.shop1.core.models.dtos.buyer.BuyerSearchDataDto;
import net.javakg.shop1.core.models.dtos.product.ProductSearchDataDto;
import net.javakg.shop1.core.models.dtos.purchase.CreatedPurchaseDto;
import net.javakg.shop1.core.models.dtos.purchase.PurchaseDto;
import net.javakg.shop1.core.models.dtos.purchase.UpdatePurchaseDto;
import net.javakg.shop1.core.models.entities.PurchaseEntity;

public class PurchaseMapper {
    public PurchaseDto toDomain(PurchaseEntity model) {
        var buyer = model.getBuyer();
        var product = model.getProduct();
        return PurchaseDto.builder()
                .id(model.getId())
                .buyer(BuyerSearchDataDto.builder()
                        .name(buyer.getName())
                        .build())
                .product(ProductSearchDataDto.builder()
                        .name(product.getName())
                        .cost(product.getCost())
                        .build())
                .build();
    }

    public PurchaseEntity fromDomain(CreatedPurchaseDto model) {
        return PurchaseEntity.builder().build();
    }

    public PurchaseEntity fromDomain(UpdatePurchaseDto model) {
        return PurchaseEntity.builder()
                .id(model.getId())
                .build();
    }

}
