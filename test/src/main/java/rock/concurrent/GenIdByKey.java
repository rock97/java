package rock.concurrent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lizhihuamobike on 2020/3/3.
 */
public class GenIdByKey {

    private  final DateTimeFormatter format = DateTimeFormatter.ofPattern("_yyyy-MM-dd_HH:mm:ss");


    private  Map<String,AtomicInteger> map = new ConcurrentHashMap<>();
    public  void main1() {
        LocalDateTime arrivalDate  = LocalDateTime.now();
        String landing = arrivalDate.format(format);
    }
    public  Integer getAndIncrementByKey(String key) {
        AtomicInteger integer = map.get(key);
        if(integer == null){
            synchronized (map) {
                if(map.get(key) == null) {
                    map.clear();
                    map.put(key, new AtomicInteger(0));
                }
            }

        }
        //System.out.println("map.size = " + map.size());
        integer = map.get(key);
        return integer.getAndIncrement();
    }
}
