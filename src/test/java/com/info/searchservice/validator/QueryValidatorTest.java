package com.info.searchservice.validator;

import java.util.MissingFormatArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueryValidatorTest {
  @Autowired
  private QueryValidator queryValidator;

  @Test
  public void test_empty_query_expect_exception() {
    Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> queryValidator.validate(""));
    Assertions.assertEquals("query is mandatory request parameter", exception.getMessage());
  }

  @Test
  public void test_invalid_query_separator_expect_exception() {
    Assertions.assertThrows(MissingFormatArgumentException.class, () -> queryValidator.validate("laguange"));
  }

  @Test
  public void test_invalid_query_expect_exception() {
    Assertions.assertThrows(MissingFormatArgumentException.class, () -> queryValidator.validate("abcd:java"));
  }

  @Test
  public void test_valid_query() {
    queryValidator.validate("language:java");
  }
}
