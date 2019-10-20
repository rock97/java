package rock.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IFilter {
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if(p.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        User user1 = new User("lizhihua1",21);
        User user6 = new User("lizhihua1",20);
        User user7 = new User("lizhihua1",23);
        User user8 = new User("lizhihua1",21);
        User user2 = new User("yuanjiajia1",1);
        User user3 = new User("lizhihua2",11);
        User user4 = new User("yuanjiajia3",25);
        User user5 = new User("yuanjiajia4",31);


        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        list.add(user7);
        list.add(user8);

        list.sort(Comparator.comparing(User::getName).reversed().thenComparing(User::getAge));

        list.forEach(user -> System.out.println("user1 = " + user));

        System.out.println();
        List<User> filter = filter(list, (u) -> u.getAge() > 20 && u.getName().startsWith("yuanjiajia"));

        for (User user : filter) {
            System.out.println("user = " + user);
        }

        System.out.println();
        Predicate<User> predicate = u->u.getAge()>20;
        Predicate<User> negate = predicate.negate();
        Predicate<User> y1 = negate.and(u -> u.getName().startsWith("l"));
        filter(list, y1).forEach(user -> System.out.println("usery = " + user));

        Function<Integer,Integer> f = x -> x + 1;
        Function<Integer,Integer> y = x -> x *2;
        Integer apply = f.andThen(y).apply(2);
        System.out.println("apply = " + apply);
        Integer apply1 = f.compose(y).apply(2);
        System.out.println("apply1 = " + apply1);

        List<Integer> collect = list.stream().filter(u -> u.getAge() > 20).sorted(Comparator.comparing(User::getAge)).map(user -> user.getAge()).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }
}
