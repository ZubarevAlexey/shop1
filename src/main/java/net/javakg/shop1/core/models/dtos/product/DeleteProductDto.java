package net.javakg.shop1.core.models.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.javakg.shop1.core.models.dtos.base.BaseDto;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class DeleteProductDto extends BaseDto {
}
