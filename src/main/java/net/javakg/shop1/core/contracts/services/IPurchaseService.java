package net.javakg.shop1.core.contracts.services;

import net.javakg.shop1.core.exceptions.EntityDuplicateExceptions;
import net.javakg.shop1.core.exceptions.EntityNotFoundException;
import net.javakg.shop1.core.models.dtos.purchase.*;
import org.springframework.http.HttpStatus;

public interface IPurchaseService {
    PurchaseDto register(CreatedPurchaseDto model) throws EntityDuplicateExceptions, EntityNotFoundException;

    PurchaseDto update(UpdatePurchaseDto model) throws EntityNotFoundException;

    HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException;

    PurchaseDto getById(GetByIdPurchaseDto model) throws EntityNotFoundException;
}
