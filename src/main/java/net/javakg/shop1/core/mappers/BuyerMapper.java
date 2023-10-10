package net.javakg.shop1.core.mappers;

import net.javakg.shop1.core.models.dtos.buyer.BuyerDto;
import net.javakg.shop1.core.models.dtos.buyer.CreatedBuyerDto;
import net.javakg.shop1.core.models.dtos.buyer.UpdateBuyerDto;
import net.javakg.shop1.core.models.entities.BuyerEntity;

public class BuyerMapper {
    public BuyerDto toDomain(BuyerEntity model) {
        return BuyerDto.builder()
                .id(model.getId())
                .email(model.getEmail())
                .name(model.getName())
                .build();
    }

    public BuyerEntity fromDomain(CreatedBuyerDto model) {
        return BuyerEntity.builder()
                .email(model.getEmail())
                .name(model.getName())
                .build();
    }

    public BuyerEntity fromDomain(UpdateBuyerDto model) {
        return BuyerEntity.builder()
                .id(model.getId())
                .email(model.getEmail())
                .name(model.getName())
                .build();
    }

}
