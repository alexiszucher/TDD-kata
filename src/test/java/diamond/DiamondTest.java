package diamond;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiamondTest {

    @Test
    void shouldPrintDiamondWithA() {
        Assertions.assertEquals("A", new Diamond().print("A"));
    }

    @Test
    void shouldPrintDiamondWithB() {
        String expected = """
                 A
                B B
                 A""";
        Assertions.assertEquals(expected, new Diamond().print("B"));
    }

    @Test
    void shouldPrintDiamondWithC() {
        String expected = """
                  A
                 B B
                C   C
                 B B
                  A""";
        Assertions.assertEquals(expected, new Diamond().print("C"));
    }

    @Test
    void shouldPrintDiamondWithF() {
        String expected = """
                      A
                     B B
                    C   C
                   D     D
                  E       E
                 F         F
                  E       E
                   D     D
                    C   C
                     B B
                      A""";
        Assertions.assertEquals(expected, new Diamond().print("F"));
    }
}