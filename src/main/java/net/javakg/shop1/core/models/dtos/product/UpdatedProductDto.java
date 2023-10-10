package net.javakg.shop1.core.models.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.javakg.shop1.core.models.dtos.base.BaseDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdatedProductDto extends BaseDto {
    private String name;
    private Double cost;
}
