package com.inditex.prueba.mappers;

import com.inditex.prueba.dto.PriceDto;
import com.inditex.prueba.models.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceToDtoMapper {

  public PriceDto priceModelToDto(final Price price) {
    return new PriceDto(
        price.getProductId(),
        price.getBrandId(),
        price.getPriceList(),
        price.getStartDate().toString(),
        price.getEndDate().toString(),
        price.getPrice());
  }
}
