package rock.acm.dp;

import java.util.Scanner;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-23 17:13
 */
public class Main5 {
    public static void main(String[] args) {
        long[][] array = new long[21][21];
        int[][]con = new int[20][20];
        Scanner cin=new Scanner(System.in);
        array[0][1]=array[1][0] = 1;
        int a = cin.nextInt();
        int b = cin.nextInt();
        int m = cin.nextInt();
        int n = cin.nextInt();

        int[] team_x = {0,-1,1,2,2,1,-1,-2,-2};
        int[] team_y = {0,-2,-2,-1,1,2,2,1,-1};
        for (int i = 0; i < team_x.length; i++) {
            if(m+team_x[i]>=0 && n+team_y[i]>=0){
                con[m+team_x[i]][n+team_y[i]]=1;
            }
        }

        ttt(a,b,array,con);
        System.out.print(array[a][b]);

    }
    public static long ttt(int i,int j,long[][] array,int[][] an){
        if( i <0 ) return 0;
        if(j <0) return 0;
        if(an[i][j]==1) return array[i][j]= 0;
        if(array[i][j]>0) return array[i][j];
        return array[i][j] = ttt(i-1,j,array,an) + ttt(i,j-1,array,an);
    }
}
