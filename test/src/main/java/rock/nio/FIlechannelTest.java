package rock.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-06-15 16:19
 */
public class FIlechannelTest {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("D:\\tuning.log");
        FileChannel fileChannel = inputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        fileChannel.read(byteBuffer);
        System.out.println(byteBuffer.toString());

        byteBuffer.flip();
        while (byteBuffer.remaining()>0){
            System.out.println(byteBuffer.getInt());
        }
    }
}
