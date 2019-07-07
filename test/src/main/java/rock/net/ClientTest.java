package rock.net;

import java.io.IOException;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-07-07 12:43
 */
public class ClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        TestSocketClient socketClient = new TestSocketClient();
        socketClient.read(8080);
    }
}
