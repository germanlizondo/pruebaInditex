package com.inditex.prueba;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.prueba.dto.PriceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class PruebaInditexApplicationTests {

  public static final String URI = "/price";

  public static final String DATE_PARAM = "dateApplied";
  public static final String PRODUCT_PARAM = "productId";
  public static final String BRAND_PARAM = "brandId";

  @Autowired protected WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
  }

  @Test
  void test1() throws Exception {

    PriceDto expected =
        new PriceDto(35455L, 1L, 1L, "2020-06-14 00:00:00.0", "2020-12-31 23:59:59.0", 35.5);

    makeTestPetition("2020/06/14 10:00:00", "35455", "1", expected);
  }

  @Test
  void test2() throws Exception {

    PriceDto expected =
        new PriceDto(35455L, 1L, 2L, "2020-06-14 15:00:00.0", "2020-06-14 18:30:00.0", 25.45);

    makeTestPetition("2020/06/14 16:00:00", "35455", "1", expected);
  }

  @Test
  void test3() throws Exception {

    PriceDto expected =
        new PriceDto(35455L, 1L, 1L, "2020-06-14 00:00:00.0", "2020-12-31 23:59:59.0", 35.5);

    makeTestPetition("2020/06/14 21:00:00", "35455", "1", expected);
  }

  @Test
  void test4() throws Exception {

    PriceDto expected =
            new PriceDto(35455L, 1L, 3L, "2020-06-15 00:00:00.0", "2020-06-15 11:00:00.0", 35.5);

    makeTestPetition("2020/06/15 10:00:00", "35455", "1", expected);
  }

  @Test
  void test5() throws Exception {

    PriceDto expected =
            new PriceDto(35455L, 1L, 4L, "2020-06-15 16:00:00.0", "2020-12-31 23:59:59.0", 38.95);

    makeTestPetition("2020/06/16 21:00:00", "35455", "1", expected);
  }

  private void makeTestPetition(
      final String dateParam,
      final String productParam,
      final String brandParam,
      final PriceDto expected)
      throws Exception {

    MultiValueMap<String, String> queryparams = new LinkedMultiValueMap<>();
    queryparams.add(DATE_PARAM, dateParam);
    queryparams.add(PRODUCT_PARAM, productParam);
    queryparams.add(BRAND_PARAM, brandParam);

    mockMvc
        .perform(MockMvcRequestBuilders.get(URI).queryParams(queryparams))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(expected)));
  }
}
