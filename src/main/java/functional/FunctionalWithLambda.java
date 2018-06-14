package functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalWithLambda {

    public static void main(String... args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> output = input.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());

        System.out.print(output);
    }

}
