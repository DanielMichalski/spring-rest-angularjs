package pl.dmichalski.rest.testing.calculator;

/**
 * Author: Daniel
 */
public class Calculator {

    public int abs(int arg) {
        if (arg < 0) {
            return -arg;
        } else {
            return arg;
        }
    }

}
