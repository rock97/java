package rock.nio;

import java.nio.ByteBuffer;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-06-15 15:46
 */
public class ByteBufferTest {
    public static void main(String[] args) {
        byte [] bytes = {'a','b','c','d','e','f'};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

        System.out.println(byteBuffer.toString());

        while (byteBuffer.position()<3){
            byteBuffer.get();
        }
        System.out.println(byteBuffer.toString());
        byteBuffer.flip();
        System.out.println(byteBuffer.toString());
        while (byteBuffer.position()<byteBuffer.limit()){
            byteBuffer.put((byte)2);
        }
        byteBuffer.compact();
        byteBuffer.put((byte)2);
        System.out.println(byteBuffer.toString());
    }
}
