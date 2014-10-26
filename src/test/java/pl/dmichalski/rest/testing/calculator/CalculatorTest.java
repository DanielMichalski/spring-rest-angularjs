package pl.dmichalski.rest.testing.calculator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Mock
    private Calculator calc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAbs() throws Exception {
        Mockito.when(calc.abs(20)).thenReturn(20);
        assertEquals(20, calc.abs(20));
    }

}