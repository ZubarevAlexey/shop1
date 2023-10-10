package net.javakg.shop1.domain.services;

import net.javakg.shop1.core.contracts.services.IBuyerService;
import net.javakg.shop1.core.exceptions.EntityDuplicateExceptions;
import net.javakg.shop1.core.exceptions.EntityNotFoundException;
import net.javakg.shop1.core.mappers.BuyerMapper;
import net.javakg.shop1.core.models.dtos.buyer.*;
import net.javakg.shop1.data.repo.BuyerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BuyerService implements IBuyerService {

    private final BuyerRepository buyerRepository;
    private final BuyerMapper mapper;

    public BuyerService(BuyerRepository buyerRepository, BuyerMapper mapper) {
        this.buyerRepository = buyerRepository;
        this.mapper = mapper;
    }

    @Override
    public BuyerDto register(CreatedBuyerDto model) throws EntityDuplicateExceptions {
        var buyer = buyerRepository.findByName(model.getName());
        if (buyer.isPresent()) throw new EntityDuplicateExceptions();
        var entity = buyerRepository.save(mapper.fromDomain(model));
        return mapper.toDomain(entity);
    }

    @Override
    public BuyerDto update(UpdateBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = buyer.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .email(model.getEmail())
                .build();
        buyerRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        buyerRepository.delete(buyer);
        return HttpStatus.OK;
    }

    @Override
    public BuyerDto getById(GetByIdBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return mapper.toDomain(buyer);
    }
}
