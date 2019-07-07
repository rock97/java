package rock.net;

import java.io.IOException;
import java.io.OutputStream;
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
    public void read(int port) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost",port);
        OutputStream os = socket.getOutputStream();
        Thread.sleep(1000*1);
        os.write("lizhihua  erer  er".getBytes());
        os.close();
        socket.close();
    }
}
