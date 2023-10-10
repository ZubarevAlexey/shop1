package net.javakg.shop1.controllers.v1;

import net.javakg.shop1.core.contracts.facades.IBuyerFacade;
import net.javakg.shop1.core.exceptions.EntityDuplicateExceptions;
import net.javakg.shop1.core.models.dtos.buyer.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/buyer")
public class BuyerController {

    private IBuyerFacade buyerFacade;

    public BuyerController(IBuyerFacade buyerFacade) {
        this.buyerFacade = buyerFacade;
    }

    @PostMapping("/signup")
    public ResponseEntity<BuyerDto> register(@RequestBody CreatedBuyerDto model) {
        try {
            return ResponseEntity.ok(buyerFacade.register(model));
        } catch (EntityDuplicateExceptions e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BuyerDto> update(@RequestBody UpdateBuyerDto model) {
        try {
            return ResponseEntity.ok(buyerFacade.update(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteBuyerDto model) {
        try {
            return ResponseEntity.ok(buyerFacade.delete(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/id")
    public ResponseEntity<BuyerDto> delete(@RequestBody GetByIdBuyerDto model) {
        try {
            return ResponseEntity.ok(buyerFacade.getById(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
