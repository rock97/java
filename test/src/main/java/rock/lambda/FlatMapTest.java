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

        List<Integer> lista = Arrays.asList(3,4,5);
        List<Integer> listb = Arrays.asList(3,4,5);
        List<Integer> collect1 = lista.stream()
                .flatMap(i -> listb.stream().map(j -> i * j))
                .collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);

        List<Integer> collect2 = lista.stream()
                .flatMap(a -> listb.stream().filter(b -> b == a)).limit(1).collect(Collectors.toList());
        System.out.println("collect2 = " + collect2);

        Stream<Integer> integerStream = lista.stream().filter(i -> listb.stream().anyMatch(j -> j.equals(i))).distinct();
        integerStream.forEach(System.out::println);

        List<String> stringList1 = Arrays.asList("lizhihua", "lizhihua1", "lizhihua2", "yuanjiajia", "yuanjiajia1", "tianjia");
        List<String> stringList2 = Arrays.asList("lizhihua", "yuanjiajia","232");
        long count = stringList1.stream().filter(i -> stringList2.stream().anyMatch(j -> i.startsWith(j))).limit(1).count();
        System.out.println("count = " + count);

        boolean b = stringList1.stream().anyMatch(i -> stringList2.stream().anyMatch(j -> i.startsWith(j)));
        System.out.println("b = " + b);

        List<String> collect3 = stringList1.stream().filter(i -> stringList2.stream().anyMatch(j -> i.startsWith(j))).collect(Collectors.toList());
       // System.out.println("collect3 = " + collect3);
        boolean b1 = collect3.stream().allMatch(i -> stringList2.stream().allMatch(j -> i.startsWith(j)));
       // System.out.println("b1 = " + b1);

        boolean b2 = stringList2.stream().allMatch(i -> stringList1.stream().anyMatch(j -> j.startsWith(i)));
        System.out.println("b2 = " + b2);


        boolean b3 = stringList2.stream()
                .allMatch(s1 -> stringList1.stream()
                        .filter(i -> stringList2.stream()
                                .anyMatch(j -> i.startsWith(j)))
                        .collect(Collectors.toList()).stream()
                        .anyMatch(s2 -> s2.startsWith(s1)));
        System.out.println("b3 = " + b3);


    }
}
