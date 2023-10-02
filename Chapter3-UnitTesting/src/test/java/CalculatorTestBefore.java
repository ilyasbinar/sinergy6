import org.example.Calculator;
import org.junit.jupiter.api.*;

public class CalculatorTestBefore {

    Calculator calculator;
    @BeforeEach
    void beforeTest(){
        System.out.println("beforeTest dipanggil");
        calculator = new Calculator();
    }
    @Test
    @DisplayName("Do Nothing")
    void testNothing(){
    }

    @Test
    @DisplayName("Positive Test - Hasil Tambah Benar")
    void testTambahKalkulator(){
        int hasil = calculator.tambah(1, 2);
        Assertions.assertEquals(3, hasil, "Hasil 1+1=2");
    }

    @Test
    @DisplayName("Negative Test - Number di set null")
    void testTambahKalkulatorNullNumber(){
        Exception e =  Assertions.assertThrows(NullPointerException.class, () -> calculator.tambah(null, 2));
        Assertions.assertEquals("Cannot invoke \"java.lang.Integer.intValue()\" because \"i\" is null", e.getMessage());

    }

    @AfterEach
    void afterTestEach(){
        System.out.println("afterTestEach");
    }

    @AfterAll
    static void afterTestAll(){
        System.out.println("afterTestAll");
    }

}
