package rock.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderProcessorTest {
    public static String processFile(BufferedReaderProcessor p,String fileName) throws IOException {
        BufferedReader br =
                new BufferedReader(new FileReader(fileName));
        return p.process(br);
    }

    public static void main(String[] args) {
        try {
            String s = processFile(br -> br.readLine()+br.readLine(), "/Users/lizhihuamobike/Documents/molack.txt");
            System.out.println("s = " + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
