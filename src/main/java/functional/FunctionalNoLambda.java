package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalNoLambda {

    public static void main(String... args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> output = input.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        }).collect(Collectors.toList());

        System.out.print(output);
    }

}
