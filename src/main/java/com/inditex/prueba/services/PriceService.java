package com.inditex.prueba.services;

import com.inditex.prueba.dto.PriceDto;
import com.inditex.prueba.mappers.PriceToDtoMapper;
import com.inditex.prueba.models.Price;
import com.inditex.prueba.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class PriceService {

  @Autowired private PriceRepository priceRepository;
  @Autowired private PriceToDtoMapper priceToDtoMapper;

  public PriceDto getPrice(final Date dateApplied, final Long productId, final Long brandId) {

    Optional<Price> price =
        priceRepository.getPriceByDate(new Timestamp(dateApplied.getTime()), productId, brandId);

    log.info("Respository return data: [{}]", price);
    return price.map(value -> priceToDtoMapper.priceModelToDto(value)).orElse(null);
  }
}
