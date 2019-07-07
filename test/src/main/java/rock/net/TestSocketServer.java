package rock.net;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-07-03 23:17
 */
public class TestSocketServer {
    public void accept(){
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println(" 阻塞开始 " + System.currentTimeMillis());
            serverSocket.accept();
            System.out.println(" 阻塞结束 " + System.currentTimeMillis());
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
