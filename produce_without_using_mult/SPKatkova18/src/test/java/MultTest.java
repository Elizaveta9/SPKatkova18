import org.junit.Assert;
import org.junit.Test;

public class MultTest {
    Mult mult = new Mult();
    @Test
    public void testMult() {
        mult.readLineFromFile();
        Assert.assertEquals(17550, mult.mult(), 0.1);
    }

    @Test
    public void testSetExpression(){
        mult.setExpression("54*43");
        Assert.assertEquals(2322, mult.mult(), 0.1);
    }

    @Test
    public void testMinusMult(){
        mult.setExpression("2*-3");
        Assert.assertEquals(-6, mult.mult(), 0.1);
    }
}
