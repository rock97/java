package rock.acm;

import java.io.File;
import java.util.UUID;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-12-27 21:00
 */
public class FileTest {
    public static void main(String[] args) {
        String oldDir =  "J:\\迅雷下载\\wewe";
        File file = new File(oldDir);
        renameFile(file,oldDir);
    }
    private static  void renameFile(File file,String dir){
        if(file.isDirectory()){
            for (File listFile : file.listFiles()) {
                renameFile(listFile,dir);
            }
        }else {
            String newName = dir + "\\" + UUID.randomUUID()
                    .toString()
                    .substring(25) + file.getName()
                    .substring(file.getName().lastIndexOf("."));
            file.renameTo(new File(newName));
        }

        String newName = file.getParent() + "\\" + UUID.randomUUID()
                .toString()
                .substring(25);
        file.renameTo(new File(newName));
    }
}
