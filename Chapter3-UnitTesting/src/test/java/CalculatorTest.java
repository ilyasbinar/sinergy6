import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    @DisplayName("Do Nothing")
    void testNothing(){
    }

    @Test
    @DisplayName("Positive Test - Hasil Tambah Benar")
    void testTambahKalkulator(){
        Calculator calculator = new Calculator();
        int hasil = calculator.tambah(1, 2);
        Assertions.assertEquals(3, hasil, "Hasil 1+1=2");
    }

    @Test
    @DisplayName("Negative Test - Number di set null")
    void testTambahKalkulatorNullNumber(){
        Calculator calculator = new Calculator();
        Exception e =  Assertions.assertThrows(NullPointerException.class, () -> calculator.tambah(null, 2));
        Assertions.assertEquals("Cannot invoke \"java.lang.Integer.intValue()\" because \"i\" is null", e.getMessage());
    }
}
