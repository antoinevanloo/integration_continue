
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
class CalculsTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @ParameterizedTest(name="Multiplication de {0} par {1}, resultat attendu {2}")
    @MethodSource("chargerTestMultiplier")
    void multiplier(int first, int last, int result) {
        Calculs calculs = new Calculs(first,last);
        assertEquals(result,calculs.multiplier());
    }

    static Stream<Arguments> chargerTestMultiplier() throws Throwable {
        return Stream.of(
                Arguments.of(2,2,4),
                Arguments.of(3,3,9),
                Arguments.of(3,4,12));
    }

    @Test
    void additionner() {
        Calculs calculs = new Calculs(2,3);
        assertEquals(5,calculs.additionner());

        calculs = new Calculs(8,3);
        assertEquals(11,calculs.additionner());
    }

    @Test
    void diviser() {
        Calculs calculs = new Calculs(4,2);
        assertEquals(2,calculs.diviser());

        Calculs finalCalculs = new Calculs(10,0);
        assertThrows(ArithmeticException.class,() -> finalCalculs.diviser());
    }

    @Test
    void soustraire() {
        Calculs calculs = new Calculs(2,3);
        assertEquals(-1,calculs.soustraire());

        calculs = new Calculs(8,3);
        assertEquals(5,calculs.soustraire());
    }
}
