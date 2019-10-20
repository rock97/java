package rock.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class DishTest {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 400, Dish.Type.MEAT),new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 500, Dish.Type.OTHER),
                new Dish("rice", true, 300, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 500, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),new Dish("salmon", false, 450, Dish.Type.FISH));

        List<String> listName = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .map(dish -> dish.getName())
                .collect(Collectors.toList());
        System.out.println("listName = " + listName);


        Set<String> collect = menu.parallelStream().filter(Dish::isVegetarian).map(dish -> dish.getName()).collect(Collectors.toSet());
        System.out.println("collect = " + collect);

        List<Integer> collect1 = menu.parallelStream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);

        boolean b = menu.stream().anyMatch(dish -> dish.isVegetarian());
        System.out.println("b = " + b);

        Optional<Dish> any = menu.stream().filter(dish -> dish.getCalories() > 500).findAny();
        System.out.println("any.orElse(new Dish()) = " + any.orElse(new Dish()));

        Map<Integer, List<Dish>> listMap = menu.stream().collect(Collectors.groupingBy(dish -> dish.getCalories()));
        System.out.println("listMap = " + listMap);

        String collect2 = menu.stream().map(dish -> dish.getName()).collect(Collectors.joining(","));
        System.out.println("collect2 = " + collect2);

        long count = menu.stream().count();
        System.out.println("count = " + count);

        Integer collect3 = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("collect3 = " + collect3);

        Double collect4 = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("collect4 = " + collect4);

        String reduce = menu.stream().map(Dish::getName).reduce("",(s1, s2) -> s1 + s2);
        System.out.println("reduce = " + reduce);

        Map<Integer, Map<String, List<Dish>>> collect5 = menu.stream().collect(Collectors.groupingBy(Dish::getCalories, Collectors.groupingBy(Dish::getName)));
        Collection<Map<String, List<Dish>>> values = collect5.values();
        System.out.println("values = " + values);

        Map<Integer, HashSet<String>> collect6 = menu.stream().collect(Collectors.groupingBy(Dish::getCalories, Collectors.mapping(dish -> {
            if (dish.getCalories() > 500) {
                return "nihao";
            } else {
                return "buhao";
            }
        }, Collectors.toCollection(HashSet::new))));
        System.out.println("collect6 = " + collect6);

        Map<Boolean, List<Dish>> collect7 = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println("collect7 = " + collect7);
        Map<Boolean, Map<Dish.Type, List<Dish>>> collect8 = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
        System.out.println("collect8 = " + collect8);
    }
}
