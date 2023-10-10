package net.javakg.shop1.core.models.dtos.purchase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.javakg.shop1.core.models.dtos.buyer.BuyerSearchDataDto;
import net.javakg.shop1.core.models.dtos.product.ProductSearchDataDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PurchaseDto {
    private Long id;
    private BuyerSearchDataDto buyer;
    private ProductSearchDataDto product;
}
