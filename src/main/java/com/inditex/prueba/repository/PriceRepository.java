package com.inditex.prueba.repository;

import com.inditex.prueba.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

  @Query(
      value =
          "SELECT * FROM PRICES p WHERE ?1 BETWEEN p.start_date AND p.end_date  AND p.product_id = ?2 AND p.brand_id = ?3 ORDER BY p.priority DESC LIMIT 1",
      nativeQuery = true)
  Optional<Price> getPriceByDate(Timestamp dateToApplied, Long productId, Long brandId);
}
