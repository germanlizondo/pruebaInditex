package com.inditex.prueba.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRICES")
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long priceList;

  @ManyToOne
  @JoinColumn(name = "brandId")
  private Brand brand;

  private Timestamp startDate;

  private Timestamp endDate;

  @ManyToOne
  @JoinColumn(name = "productId")
  private Product product;

  private Integer priority;

  private Double price;

  private String currency;

  public Long getProductId() {
    return product.getId();
  }

  public Long getBrandId() {
    return brand.getId();
  }
}
