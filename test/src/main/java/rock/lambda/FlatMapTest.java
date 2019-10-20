package rock.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {
    public static void main(String[] args) {

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        List<String> collect = streamOfwords
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);

        List<Integer> lista = Arrays.asList(2,3,4,5);
        List<Integer> listb = Arrays.asList(3,4,5,6);
        List<Integer> collect1 = lista.stream()
                .flatMap(i -> listb.stream().map(j -> i * j))
                .collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);

        List<Integer> collect2 = lista.stream()
                .flatMap(a -> listb.stream().filter(b -> b == a)).limit(1).collect(Collectors.toList());
        System.out.println("collect2 = " + collect2);



    }
}
