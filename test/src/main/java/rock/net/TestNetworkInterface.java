package rock.net;

import com.alibaba.fastjson.JSON;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-07-03 23:00
 */
public class TestNetworkInterface {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> enumerations =  NetworkInterface.getNetworkInterfaces();
            while (enumerations.hasMoreElements()){
                NetworkInterface networkInterface = enumerations.nextElement();
                System.out.println("networkInterface = " + networkInterface.getDisplayName());
                System.out.println("networkInterface.getMTU() = " + networkInterface.getMTU());
                System.out.println("networkInterface.getInetAddresses = " + JSON.toJSONString(networkInterface.getInetAddresses()));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
