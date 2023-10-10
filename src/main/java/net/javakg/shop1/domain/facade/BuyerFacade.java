package net.javakg.shop1.domain.facade;

import net.javakg.shop1.core.contracts.facades.IBuyerFacade;
import net.javakg.shop1.core.contracts.services.IBuyerService;
import net.javakg.shop1.core.exceptions.EntityDuplicateExceptions;
import net.javakg.shop1.core.exceptions.EntityNotFoundException;
import net.javakg.shop1.core.models.dtos.buyer.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BuyerFacade implements IBuyerFacade {

    private final IBuyerService buyerService;

    public BuyerFacade(IBuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @Override
    public BuyerDto register(CreatedBuyerDto model) throws EntityDuplicateExceptions {
        return buyerService.register(model);
    }

    @Override
    public BuyerDto update(UpdateBuyerDto model) throws EntityNotFoundException {
        return buyerService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException {
        return buyerService.delete(model);
    }

    @Override
    public BuyerDto getById(GetByIdBuyerDto model) throws EntityNotFoundException {
        return buyerService.getById(model);
    }
}
