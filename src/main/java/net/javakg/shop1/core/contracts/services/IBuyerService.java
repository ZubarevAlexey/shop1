package net.javakg.shop1.core.contracts.services;

import net.javakg.shop1.core.exceptions.EntityDuplicateExceptions;
import net.javakg.shop1.core.exceptions.EntityNotFoundException;
import net.javakg.shop1.core.models.dtos.buyer.*;
import org.springframework.http.HttpStatus;

public interface IBuyerService {
    BuyerDto register(CreatedBuyerDto model) throws EntityDuplicateExceptions;

    BuyerDto update(UpdateBuyerDto model) throws EntityNotFoundException;

    HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException;

    BuyerDto getById(GetByIdBuyerDto model) throws EntityNotFoundException;
}
