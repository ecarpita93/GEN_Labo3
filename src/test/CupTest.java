/* ------------------------------------------------------
GEN- LAB 3
File : DieTest
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implement the tests on the Die class.

---------------------------------------------------------*/

import main.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CupTest {

    @Test
    public void aNewCupShouldBeCreated() {
        Cup cup = new Cup(2);
        assertNotNull(cup);
    }

    @ParameterizedTest(name="Run {index}: numberOfDices{0}")
    @MethodSource("rollValueMustBeBetweenMinAndMax_Parameters")
    public void rollValueMustBeBetweenMinAndMax(int numberOfDices) {
        Cup cup = new Cup(numberOfDices);
        cup.roll();
        int max = cup.getDices().size() * 6;
        int min = cup.getDices().size();
        assertTrue(cup.getTotal() < max && cup.getTotal() > min);
    }

    static Stream<Arguments> rollValueMustBeBetweenMinAndMax_Parameters() throws Throwable {
        return Stream.of(Arguments.of(2), Arguments.of(3), Arguments.of(4));
    }
}