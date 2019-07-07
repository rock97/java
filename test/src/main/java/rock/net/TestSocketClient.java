package rock.net;

import java.io.IOException;
import java.net.Socket;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-07-03 23:17
 */
public class TestSocketClient {
    public void socket(){
        System.out.println(" 连接准备 ");
        try {
            Socket socket = new Socket("127.0.0.1",8088);
            System.out.println("连接完成");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
