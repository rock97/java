package rock;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-12-05 10:18
 */
public class Main1 {
    public static void main(String[] args) {
        int [] nums = {-7,-5,5,-6,-2,1,7,3,-4,-2,-2,-4,-8,-1,8,8,-2,-7,3,2,-7,8,-3,-10,5,2,8,7,7};
        System.out.println(JSON.toJSONString(threeSum(nums)));
    }

    public static int longestConsecutive(int[] nums){
        int array[] = new int[nums.length];
        if(nums.length<=1) return nums.length;
        int max = 1;
        int length = 1;
        Map<Integer,Integer> list = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer mid = list.get(nums[i]);
            if(mid == null){
                list.put(i,2*nums[i]+1);
                list.put(i+1,2*nums[i]+1);
                list.put(i-1,2*nums[i]+1);
            }else{
                list.put(i,mid);
                list.put(i+1,mid);
                list.put(i-1,mid);
            }
        }
        System.out.println("list = " + list);
        return max;
    }
    public static int findKthLargest(int[] nums, int k) {
        int [] array = new int[nums.length];
        array[k-1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > array[k-1])
            insertfindKthLargest(array,k,nums[i]);
        }

        return array[k-1];
    }

    public static void insertfindKthLargest(int[] array, int k,int val){

        for (int i = 0; i <k ; i++) {
            if(array[i]<val){
                for (int j = k-1; j >=i; j--) {
                    if(array[i]==0) break;
                    array[j] = array[j-1];
                }
                array[i] =val;
                break;
            }
        }
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length ==0) return 0;
        if(nums.length ==1) return 1;
        int len = 1;
        int max = 1 ;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i]<nums[i+1]){
                len++;
                max = Math.max(max,len);
            }else{
                len = 1;
            }
        }
        return max;
    }
    public static int search(int[] nums, int target) {
        if(nums.length ==0) return -1;
        if(nums.length == 1){
            if(nums[0] == target) return 0;
            return -1;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]>nums[i+1]){
                return Math.max(searchBin(nums,target,0,i),searchBin(nums,target,i+1,nums.length));
            }
        }
        return searchBin(nums,target,0,nums.length);
    }
    public static int searchBin(int[] nums, int target,int l,int r){
        int low = l;
        int high = r - 1;

        if(l==r){
            if(nums[r] == target) return r;
        }

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -1;  // key not fou

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<List<Integer>> lists_1 = new ArrayList<List<Integer>>();
        if(nums.length <3){
            return lists;
        }
        List<Integer> res = new ArrayList<Integer>();
        int result[][] = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {

                    if(i==j || j==k || i==k) continue;

                    if (result[i][j] == 0)
                        result[i][j] = nums[i] + nums[j];

                    if (result[i][j] + nums[k] == 0) {

                        int m = nums[i]*nums[j]*nums[k];
                        if(m!=0) {
                            if (!res.contains(m)){
                                List<Integer> l = new ArrayList<Integer>();
                                l.add(nums[i]);
                                l.add(nums[j]);
                                l.add(nums[k]);
                                res.add(m);
                                lists.add(l);
                            }
                        }else{
                            List<Integer> l = new ArrayList<Integer>();
                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(nums[k]);
                            Collections.sort(l);
                            if (!lists_1.contains(l)){
                                 lists.add(l);
                                lists_1.add(l);
                            }
                        }
                    }
                }
            }
        }
        return lists;
    }
    public static int maxAreaOfIsland(int[][] grid) {
       /* int[][] grid  = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int[][] a= {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int[][] b= {{0,1,1},{1,1,0}};
        System.out.println("maxAreaOfIsland(grid) = " + maxAreaOfIsland_g(b));
        for (int i = 0; i < grid.length; i++) {
            System.out.println(JSON.toJSONString(grid[i]));
        }*/

        if(grid.length==0){
            return 0;
        }
        Integer max = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1) {
                    grid[i][j] = 0;
                    maxAreaOfIsland_1(grid, i, j, 1);
                }
                max = Math.min(max,grid[i][j]);
            }
        }
        return 0-max;
    }

    public static int maxAreaOfIsland_g(int[][] grid){
        if(grid.length ==0){
            return 0;
        }
         class AAA {
            public int i;
            public int j;
        }
        int max = 0;
        List<AAA> list = new ArrayList<AAA>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1) {
                    AAA a1 = new AAA();
                    a1.i = i;
                    a1.j = j;
                    list.add(a1);
                    for (int k = 0; k <list.size() ; k++) {
                        AAA aaa = list.get(k);
                        grid[aaa.i][aaa.j] = 0;
                        if (aaa.i - 1>=0 && grid[aaa.i - 1][aaa.j] == 1 ) {
                            grid[aaa.i - 1][aaa.j] = 0;
                            AAA a = new AAA();
                            a.i = aaa.i - 1;
                            a.j = aaa.j;
                            list.add(a);
                        }
                        if (aaa.i + 1<grid.length && grid[aaa.i + 1][aaa.j] == 1 ) {
                            AAA a = new AAA();
                            grid[aaa.i + 1][aaa.j] = 0;
                            a.i = aaa.i + 1;
                            a.j = aaa.j;
                            list.add(a);
                        }
                        if (aaa.j - 1>=0 && grid[aaa.i ][aaa.j- 1] == 1 ) {
                            AAA a = new AAA();
                            grid[aaa.i ][aaa.j- 1] = 0;
                            a.i = aaa.i ;
                            a.j = aaa.j - 1;
                            list.add(a);
                        }
                        if (aaa.j+1<grid[aaa.i].length && grid[aaa.i][aaa.j+1] == 1) {
                            AAA a = new AAA();
                            a.i = aaa.i;
                            a.j = aaa.j+1;
                            grid[aaa.i][aaa.j+1]=0;
                            list.add(a);
                        }
                        max = Math.max(max,list.size());

                    }
                    list.clear();
                }
            }
        }
        return max;
    }

    public static int maxAreaOfIsland_1(int[][] grid,int i,int j,int sum) {
        grid[i][j] = 0 - sum;
        if(i-1>=0 && grid[i-1][j]==1){
            sum++;
            grid[i-1][j] = 0;
            maxAreaOfIsland_1(grid,i-1,j,sum);
        }
        if(i+1<grid.length && grid[i+1][j]==1){
            grid[i+1][j] =0;
            ++sum;
            maxAreaOfIsland_1(grid,i+1,j,sum);
        }
        if( j-1 >= 0 && grid[i][j-1]==1 ){
            grid[i][j-1] = 0;
            ++sum;
            maxAreaOfIsland_1(grid,i,j-1,sum);
        }
        if(j+1<grid[i].length && grid[i][j+1]==1 ){
            grid[i][j+1] =0;
            ++sum;
            maxAreaOfIsland_1(grid,i,j+1,sum);
        }
        return sum;
    }


    public  static void threeSum_1(List<List<Integer>>result ,List<Integer> list,int[] nums,int i,int sum) {
        if(i>=nums.length){
            return ;
        }

        if(sum ==0 && list.size() ==3 ){
            result.add(list);
        }

        for (int j = i+1; j < nums.length; j++) {
            List<Integer> list1 = new ArrayList<Integer>();
            list1.addAll(list);
            list1.add(nums[j]);
            threeSum_1(result,list1,nums,j,nums[j]+sum);
        }

        return;
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < 4; i++) {
            for (int j = i+1 ; j < i+4; j++) {
                for (int k = j+1; k < j+4; k++) {
                    if(0<s.length()-k && s.length()-k<=3){
                        String addr1 = s.substring(0,i);
                        String addr2 = s.substring(i,j);
                        String addr3 = s.substring(j,k);
                        String addr4 = s.substring(k);
                        if(Integer.valueOf(addr1)<=255 && Integer.valueOf(addr2)<=255 && Integer.valueOf(addr3)<=255 && Integer.valueOf(addr4)<=255){
                            if((!addr1.equals("0") && addr1.charAt(0)=='0')
                                    || (!addr2.equals("0") && addr2.charAt(0)=='0')
                                    || (!addr3.equals("0") && addr3.charAt(0)=='0')
                                    || (!addr4.equals("0") && addr4.charAt(0)=='0'))
                                continue;

                            StringBuilder sb = new StringBuilder();
                            sb.append(addr1).append(".").append(addr2).append(".").append(addr3).append(".").append(addr4);
                            list.add(sb.toString());

                        }
                    }else{
                        continue;
                    }
                }
            }
        }
        return list;
    }
}
