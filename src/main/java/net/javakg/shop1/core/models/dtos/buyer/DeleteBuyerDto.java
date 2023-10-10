package net.javakg.shop1.core.models.dtos.buyer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.javakg.shop1.core.models.dtos.base.BaseDto;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class DeleteBuyerDto extends BaseDto {
}
