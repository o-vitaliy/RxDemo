package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Imperative {

    public static void main(String ... args){
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> output = new ArrayList<>();
        for (Integer x : input) {
            if (x % 2 == 0) {
                output.add(x);
            }
        }

        System.out.print(output);
    }

}
