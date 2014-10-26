package pl.dmichalski.rest.testing.vehicle.car;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CarTest {

    @Mock
    private Engine engine;

    @InjectMocks
    private Car car;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testWarning() throws Exception {
        when(engine.getRpm()).thenReturn(6000);
        car.accelerate();

        assertEquals( "Slow down!", car.getWarningMessage());
    }
}