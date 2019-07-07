package rock.net;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

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

    public void http(int port){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println(" 阻塞开始 " + System.currentTimeMillis());
            Socket socket = serverSocket.accept();
            System.out.println(" 阻塞结束 " + System.currentTimeMillis());

            InputStream inputStream = socket.getInputStream();
            InputStreamReader bf = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(bf);
            String getLine = "";
            while (true){
                getLine = bufferedReader.readLine();
                if(getLine == null || "".equals(getLine)){
                    break;
                }
                System.out.println("getLine = " + getLine);
            }
            inputStream.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(int port) throws IOException {
        char[] bytes = new char[1024];
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        System.out.println("read 阻塞开始");
        int leng = inputStreamReader.read(bytes);
        while (leng!=-1){
            System.out.println(JSON.toJSONString(bytes));
            leng = inputStreamReader.read(bytes);
        }
        System.out.println("read 阻塞end" + JSON.toJSONString(bytes));
        is.close();
        socket.close();
    }
}
