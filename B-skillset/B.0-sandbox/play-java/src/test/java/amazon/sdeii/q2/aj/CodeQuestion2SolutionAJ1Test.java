package amazon.sdeii.q2.aj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class CodeQuestion2SolutionAJ1Test {

    private CodeQuestion2SolutionAJ1 codeQuestion2SolutionAJ1;

    @BeforeEach
    void setUp() {
        codeQuestion2SolutionAJ1 = new CodeQuestion2SolutionAJ1();
    }

    @Test
    @Order(1)
    void testLevel1Case01AddTwoNumbers() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            Assertions.assertEquals(2, CodeQuestion2SolutionAJ1.findMaximumSustainableClusterSize(
                    new ArrayList<>(
                            List.of(3, 6, 1, 3, 4) // processingPower
                    ),
                    new ArrayList<>(
                            List.of(2, 1, 3, 4, 5) // bootingPower
                    ),
                    25 // powerMax
            ));
        });
    }
}