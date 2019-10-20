package rock.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Optional<Integer> reduce = integerList.stream().reduce(Integer::sum);
        System.out.println("reduce = " + reduce.get());
    }
}
