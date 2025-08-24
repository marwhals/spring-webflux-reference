package org.webflux_reference.streaming.mapper;

import org.webflux_reference.streaming.dto.ProductDto;
import org.webflux_reference.streaming.entity.Product;

public class EntityDtoMapper {

    public static Product toEntity(ProductDto dto){
        var product = new Product();
        product.setId(dto.id());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        return product;
    }

    public static ProductDto toDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getDescription(),
                product.getPrice()
        );
    }

}