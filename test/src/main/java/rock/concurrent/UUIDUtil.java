package rock.concurrent;

import java.util.UUID;

/**
 * Created by lizhihuamobike on 2020/3/3.
 */
public class UUIDUtil {
    public static String creatUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
