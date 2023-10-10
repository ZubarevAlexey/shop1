package net.javakg.shop1.domain.facade;

import net.javakg.shop1.core.contracts.facades.IPurchaseFacade;
import net.javakg.shop1.core.contracts.services.IPurchaseService;
import net.javakg.shop1.core.exceptions.EntityDuplicateExceptions;
import net.javakg.shop1.core.exceptions.EntityNotFoundException;
import net.javakg.shop1.core.models.dtos.purchase.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PurchaseFacade implements IPurchaseFacade {

    private final IPurchaseService purchaseService;

    public PurchaseFacade(IPurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    public PurchaseDto register(CreatedPurchaseDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        return purchaseService.register(model);
    }

    @Override
    public PurchaseDto update(UpdatePurchaseDto model) throws EntityNotFoundException {
        return purchaseService.update(model);
    }

    @Override
    public HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException {
        return purchaseService.delete(model);
    }

    @Override
    public PurchaseDto getById(GetByIdPurchaseDto model) throws EntityNotFoundException {
        return purchaseService.getById(model);
    }
}
