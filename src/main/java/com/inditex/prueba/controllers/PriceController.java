package com.inditex.prueba.controllers;

import com.inditex.prueba.dto.PriceDto;
import com.inditex.prueba.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Objects;

@RestController
@RequestMapping("price")
public class PriceController {

  @Autowired private PriceService priceService;

  @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PriceDto> getPrice(
      @RequestParam(value = "dateApplied") final Date dateApplied,
      @RequestParam(value = "productId") final Long productId,
      @RequestParam(value = "brandId") final Long brandId) {

    PriceDto response = priceService.getPrice(dateApplied, productId, brandId);

    return Objects.isNull(response) ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
  }
}
