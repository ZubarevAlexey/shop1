package net.javakg.shop1.core.models.dtos.buyer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.javakg.shop1.core.models.dtos.base.BaseDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UpdateBuyerDto extends BaseDto {
    private String name;
    private String email;
}
