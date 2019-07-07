package rock.net;

import java.io.IOException;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-07-07 12:40
 */
public class ServerTest {
    public static void main(String[] args) throws InterruptedException, IOException {

        TestSocketServer socketServer = new TestSocketServer();

        while (true)
        socketServer.read(8080);

    }
}
