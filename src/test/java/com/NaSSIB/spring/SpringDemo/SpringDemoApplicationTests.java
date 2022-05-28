package com.NaSSIB.spring.SpringDemo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDemoApplicationTests {

  private static final Logger log = LoggerFactory.getLogger(SpringDemoApplicationTests.class);

  @Mock
  static Set<String> mockSet;

  @Test
  void contextLoads() {
    // test case here
  }

  @BeforeAll
  static void setup() {
    log.info("beginning tests: ");
  }

  @AfterAll
  static void done() {
    log.info("tests completed: ");
  }

  //
  // the most rigorous of all tests
  //
  @Test
  static void rigorousTest() {
    assertTrue(true);
    assertFalse(false);
  }

  @Test
  static void trueEmailTest() {
    String goodEmail = "mark@nassib";

    assertTrue(Validation.validEmail(goodEmail));

  }

  @Test
  static void falseEmailTest() {
    String badEmail = "marknasssib";

    assertFalse(Validation.validEmail(badEmail));
  }

  @Test
  static void trueSetTest() {
    Mockito.when(mockSet.size()).thenReturn(42);

    assertTrue(Validation.populatedSet(mockSet));
  }

  @Test
  static void falseSetTest() {
    // Mockito.when(mockSet.size()).thenReturn(0);

    assertFalse(Validation.populatedSet(mockSet));
  }


}
