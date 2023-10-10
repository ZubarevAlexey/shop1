package net.javakg.shop1.core.models.dtos.purchase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdatePurchaseDto {
    private Long id;
    private String name;
    private Double cost;
    private Long buyerId;
    private Long productId;
}
