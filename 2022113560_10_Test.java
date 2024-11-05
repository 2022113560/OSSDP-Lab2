import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Solution10Test {
    private final Solution10 solution = new Solution10();

    @Test
    public void testSimpleAdditionAndSubtraction() {
        assertEquals("0/1", solution.fractionAddition("-1/2+1/2"));
        assertEquals("1/3", solution.fractionAddition("-1/2+1/2+1/3"));
        assertEquals("-1/6", solution.fractionAddition("1/3-1/2"));
    }

    @Test
    public void testIntegerConversion() {
        assertEquals("2/1", solution.fractionAddition("2"));
        assertEquals("1/1", solution.fractionAddition("1"));
        assertEquals("0/1", solution.fractionAddition("0"));
    }

    @Test
    public void testMultipleFractions() {
        assertEquals("2/1", solution.fractionAddition("1/1+1/1-1/1+1/1-1/1+1/1"));
        assertEquals("2/3", solution.fractionAddition("1/3-1/6+1/2"));
        assertEquals("-1/1", solution.fractionAddition("-1/2-1/3-1/6"));
    }

    @Test
    public void testEdgeCases() {
        assertEquals("2/1", solution.fractionAddition("1/1+1/1"));
        assertEquals("0/1", solution.fractionAddition("1/2-1/2"));
        assertEquals("0/1", solution.fractionAddition("10/10-9/9"));
    }

    @Test
    public void testMixedPositiveAndNegativeFractions() {
        assertEquals("2/3", solution.fractionAddition("1/3-1/6+1/2"));
        assertEquals("-2/3", solution.fractionAddition("-1/2+1/6-1/3"));
        assertEquals("1/1", solution.fractionAddition("1/2+1/3+1/6"));
    }

    @Test
    public void testComplexExpressions() {
        assertEquals("2/1", solution.fractionAddition("1/1+1/1-1/2-1/2+1/2+1/2"));
        assertEquals("1/1", solution.fractionAddition("1/2+1/3+1/6"));
        assertEquals("2/3", solution.fractionAddition("4/6"));
    }

    @Test
    public void testNegativeFractions() {
        assertEquals("-1/1", solution.fractionAddition("-1/1"));
        assertEquals("-1/1", solution.fractionAddition("-1/2-1/3-1/6"));
    }
}
