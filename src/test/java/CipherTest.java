import models.Cipher;
import org.junit.*;

import static org.junit.Assert.*;

public class CipherTest {
    @Test
    public void newCipher_instantiatesCorrectly() {
        Cipher testCipher = new Cipher(2, 4);
        assertEquals(true, testCipher instanceof Cipher);
    }
    

    @Test
    public void newCipher_getsLength_2() {
        Cipher testCipher = new Cipher(2, 4);
        assertEquals(0, testCipher.getLength());
    }


    @Test
    public void getWidth_getsCipherWidth_4() {
        Cipher testCipher = new Cipher(2, 4);
        assertEquals(0, testCipher.getWidth());
    }

    @Test
    public void isCipher_whenNotASquare_false() {
        Cipher testCipher = new Cipher(2, 4);
        assertEquals(true, testCipher.isCipher());
    }

    @Test
    public void isSquare_allSidesEqual_true() {
        Cipher testRectangle = new Cipher(2, 2);
        assertEquals(true, testRectangle.isCipher());
    }

}
