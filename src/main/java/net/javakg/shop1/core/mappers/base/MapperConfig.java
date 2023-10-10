package net.javakg.shop1.core.mappers.base;

import net.javakg.shop1.core.mappers.BuyerMapper;
import net.javakg.shop1.core.mappers.ProductMapper;
import net.javakg.shop1.core.mappers.PurchaseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public BuyerMapper buildBuyerMapper() {
        return new BuyerMapper();
    }

    @Bean
    public ProductMapper buildProductMapper() {
        return new ProductMapper();
    }

    @Bean
    public PurchaseMapper buildPurchaseMapper() {
        return new PurchaseMapper();
    }
}
