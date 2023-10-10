package net.javakg.shop1.domain.services;

import net.javakg.shop1.core.contracts.services.IPurchaseService;
import net.javakg.shop1.core.exceptions.EntityDuplicateExceptions;
import net.javakg.shop1.core.exceptions.EntityNotFoundException;
import net.javakg.shop1.core.mappers.PurchaseMapper;
import net.javakg.shop1.core.models.dtos.purchase.*;
import net.javakg.shop1.data.repo.BuyerRepository;
import net.javakg.shop1.data.repo.ProductRepository;
import net.javakg.shop1.data.repo.PurchaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PurchaseService implements IPurchaseService {

    private final BuyerRepository buyerRepository;
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

    public PurchaseService(BuyerRepository buyerRepository, ProductRepository productRepository,
                           PurchaseRepository purchaseRepository, PurchaseMapper purchaseMapper) {
        this.buyerRepository = buyerRepository;
        this.productRepository = productRepository;
        this.purchaseRepository = purchaseRepository;
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public PurchaseDto register(CreatedPurchaseDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getBuyerId()).orElseThrow(EntityNotFoundException::new);
        var product = productRepository.findById(model.getProductId()).orElseThrow(EntityNotFoundException::new);
        purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = purchaseMapper.fromDomain(model);
        entity.setBuyer(buyer);
        entity.setProduct(product);
        entity = purchaseRepository.save(entity);
        return purchaseMapper.toDomain(entity);
    }

    @Override
    public PurchaseDto update(UpdatePurchaseDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getBuyerId()).orElseThrow(EntityNotFoundException::new);
        var product = productRepository.findById(model.getProductId()).orElseThrow(EntityNotFoundException::new);
        var purchase = purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = purchase.toBuilder()
                .id(model.getId())
                .product(product)
                .buyer(buyer)
                .build();
        purchaseRepository.save(entity);
        return purchaseMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException {
        var purchase = purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        purchaseRepository.deleteById(purchase.getId());
        return HttpStatus.OK;
    }

    @Override
    public PurchaseDto getById(GetByIdPurchaseDto model) throws EntityNotFoundException {
        var purchase = purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return purchaseMapper.toDomain(purchase);
    }
}
