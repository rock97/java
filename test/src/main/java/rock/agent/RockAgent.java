package rock.agent;


import java.io.File;
import java.util.UUID;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-12-24 21:08
 */
public class RockAgent {
    public static void main(String[] args) {
        /*String oldDir =  "F:\\迅雷下载\\aa";
        File file = new File(oldDir);
        renameFile(file,oldDir);*/

        System.out.println("format.substring(0,7)+\"-01\" = " + "2020-12-00".substring(0, 7) + "-01");
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
