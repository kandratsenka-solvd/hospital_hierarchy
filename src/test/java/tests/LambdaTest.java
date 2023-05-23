package tests;

import lambda.IConnector;
import lambda.IFilter;
import lambda.ITransformer;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.LoggerUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.*;

public class LambdaTest {

    final Logger LOGGER = LoggerUtil.getLogger();

    @Test
    public void testIFilter() {
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        IFilter<Integer> filterPredicate = n -> n % 2 == 0;
        intList.forEach(num -> LOGGER.info(filterPredicate.booleanFilter(num)));
    }

    @Test
    public void testITransformer() {
        ITransformer<String, Integer> stringLengthTransformer = s -> s.length();
        LOGGER.info(stringLengthTransformer.transform("Hello"));
    }

    @Test
    public void testIConnector() {
        IConnector<String> totalLength = (str1, str2) -> str1.length() + str2.length();
        String s1 = "Hello";
        String s2 = "world!";
        LOGGER.info(totalLength.totalLength(s1, s2));
    }

    @Test
    public void testCommonLambdas() {
        Consumer<String> printUpperCase = s -> LOGGER.info(s.toUpperCase());
        printUpperCase.accept("Hello");

        Supplier<Double> randomValue = () -> Math.random();
        LOGGER.info(randomValue.get());

        BiPredicate<Integer, Integer> areEqual = (a, b) -> a.equals(b);
        LOGGER.info(areEqual.test(0, 0));

        BiFunction<String, Integer, String> repeatString = (s, count) -> s.repeat(count);
        LOGGER.info(repeatString.apply("Hello", 5));

        DoublePredicate isPositive = d -> d > 0;
        LOGGER.info(isPositive.test(-0.01));
    }
}