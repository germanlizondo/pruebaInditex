package com.inditex.prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto implements Serializable {

    private static final long serialVersionUID = 8310174587553390801L;

    private Long productId;

    private Long brandId;

    private Long priceList;

    private String startDate;

    private String endDate;

    private Double finalPrice;

}
