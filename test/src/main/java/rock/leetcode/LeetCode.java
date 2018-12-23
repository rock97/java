package rock.leetcode;

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
 * @Create: 2018-12-06 18:16
 */
public class LeetCode {
    int[][]result = new int[4][4];
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = 999999;
        for (int i = 0; i < triangle.size(); i++) {
            result[i][0] = triangle.get(i).get(0);
        }
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 1; j < triangle.get(i).size(); j++) {
                if(j==i){
                    result[i][j] = result[i-1][j-1]+triangle.get(i).get(j);
                }else {
                    result[i][j] = Math.min(result[i - 1][j - 1], result[i - 1][j]) + triangle.get(i)
                            .get(j);
                }
                min = Math.min(min,result[i][j]);
            }
        }
        for (int[] ints : result) {
            System.out.println(JSON.toJSONString(ints));
        }
        return min;

    }

    /**
     * https://www.cnblogs.com/Revenent-Blog/p/7587654.html
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int [][] result = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            result[i][0] = matrix[i][0] - '0';
            max = Math.max(max,result[i][0]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            result[0][i] = matrix[0][i] - '0';
            max = Math.max(max,result[0][i]);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1'){
                    result[i][j] = Math.min(result[i-1][j-1],Math.min(result[i][j-1],result[i-1][j]))+1;
                    max = Math.max(max,result[i][j]);
                }
            }
        }
        return max*max;
    }
    /**
     * 最大子序和
     * f(i) = max(a[i]加不加f(i-1)) 因为f(i-1)是连续的
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1) return nums[0];
        int[]result = new int[nums.length];
        return  maxSubArray_1(nums,result,nums.length-1);
    }

   public int maxSubArray_1(int[] nums ,int[]result,int i){
        if(i<0) return 0;
       if(result[i] !=0 ) return result[i];
       result[i] = Math.max(maxSubArray_1(nums,result,i-1)+nums[i],nums[i]);
       System.out.println(JSON.toJSONString(result));
       return result[i];
   }
    public int maxProfit_2(int[] prices,int[][] result,int n) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j]>prices[i]){
                    max = Math.max(max,prices[i]-prices[j]);
                }
            }
        }
        return max;
    }
    /**
     * 反转链表
     * url:https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1038/
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null ) return head;

        List<Integer> array = new ArrayList<Integer>();
        while (head!=null){
            array.add(head.val);
            head = head.next;
        }
        ListNode list = new ListNode(array.get(array.size() -1 ));
        ListNode head_1 = list;
        for (int i = array.size() -2 ; i >= 0; i--) {
            ListNode next = new ListNode(array.get(i));
            list.next = next;
            list = next;
        }
        return head_1;
    }
    public ListNode reverseList_1(ListNode head) {
        if(head.next == null) return head;
        ListNode next = new ListNode(head.val);
        return reverseList_1(head.next).next = next;
    }
    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 ==null) return l2;
        if(l2 == null ) return l1;
        ListNode head = null;
        if(l1.val <= l2.val){
            head = new ListNode(l1.val);
            l1 = l1.next;
        }else{
            head = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode first = head;

        while (l1!=null || l2 !=null){
            if(l2 == null && l1!=null){
                head.next = l1;
                l1 = null;
            }else if(l1==null && l2!=null){
                head.next = l2;
                l2 = null;
            }else{
                ListNode next = null;
                if(l1.val <= l2.val){
                    next = new ListNode(l1.val);
                    head.next = next;
                    head = next;
                    l1 = l1.next;
                }else{
                    next = new ListNode(l2.val);
                    head.next = next;
                    head = next;
                    l2 = l2.next;
                }
            }

        }
        return first;
    }

    /**
     * 接雨水
     * url:https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1047/
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if(height.length<3) return 0;
        int max_index = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i]>height[max_index]) max_index = i;
        }
        int sum = 0;
        int l_h = height[0];
        int r_h = height[height.length-1];
        for (int i = 1; i < max_index; i++) {
            if(height[i] < l_h){
                sum += l_h - height[i];
            }else{
                l_h = height[i];
            }
        }
        for (int i = height.length -1 ; i > max_index; i--) {
            if(height[i] < r_h){
                sum += r_h - height[i];
            }else{
                r_h = height[i];
            }
        }
        return sum;
    }
    /**
     * 合并区间
     * url:https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1046/
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList();
        if(intervals.size() ==0) return list;
        if(intervals.size() ==1) return intervals;
        for (Interval interval : intervals) {
            boolean flag= true;
            for (Interval merge : list) {
                if(merge.start <= interval.start && interval.end<= merge.end) {
                    flag = false;
                    continue;
                }else if((merge.start <= interval.start && interval.start<= merge.end)
                        ||(merge.start <= interval.end && interval.end<= merge.end)
                        ||(interval.start <= merge.start && merge.end<= interval.end)){
                    merge.end = Math.max(merge.end,interval.end);
                    merge.start = Math.min(merge.start,interval.start);
                    flag = false;
                    list = merge(list);
                }
            }
            if(flag){
                list.add(interval);
            }

        }
        return list;
    }
    /**
     * 最长回文串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        char [] array = s.toCharArray();
        int [][] result = new int[array.length][array.length];
        int max = 0;
        int index_i=0,index_j=0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if(array[i]==array[j]) {
                    result[i][j] = result[i-1][j+1]+1;
                    if(max < result[i][j]){
                        max = result[i][j];

                            index_i = i;
                            index_j = j;

                    }
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(JSON.toJSONString(result[i]));
        }

        return s.substring(index_j, index_i + 1);
    }
    /**
     *  朋友圈
     *  https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1036/
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
           /*  int[][]M = {{1,0,0,1},
                    {0,1,1,0},
                    {0,1,1,1},
                    {1,0,1,1}};*/
        int sum =0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if(M[i][j] ==1 ){
                    sum++;
                    System.out.println("sum = " + sum);
                    findCircleNum_1(M,i,j);
                }
            }
        }
        return sum;
    }

    private void findCircleNum_1(int[][] M, int i, int j) {
      //  if (i == j) return;
        if (i < 0 || i > M.length || j < 0 | j > M.length) return;
        if (M[i][j] == 1) {
            M[i][j] = 0;
            for (int i1 = 0; i1 < M.length; i1++) {
                System.out.println(JSON.toJSONString(M[i1]));
            }
            System.out.println("");
            for (int k = 0; k < M.length; k++) {
                findCircleNum_1(M, i, k);
            }
            for (int l = 0; l < M.length; l++) {
                findCircleNum_1(M, l, j);
            }
        }
    }
    private void findCircleNum_2(char[][] M,int i,int j) {
        //int[] x = {0,1,1,1,0,-1,-1,-1};
       // int[] y = {1,1,0,-1,-1,-1,0,1};
        int[] x = {0,1,0,-1};
        int[] y = {1,0,-1,0};
        int next_i = 0;
        int next_j = 0;
        for (int k = 0; k < x.length; k++) {
            next_i = i+x[k];
            next_j = j+y[k];
            if(0<=next_i && next_i<M.length && 0<=next_j && next_j<M[0].length  &&M[next_i][next_j]=='1'){
                M[next_i][next_j] = '0';
                findCircleNum_2(M,next_i,next_j);
            }
        }
    }
    /**
     * 链表两数之和
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int mul = 1;
        int sum = 0;

        ListNode head = new ListNode( sum%10);
        ListNode head_1 = head;

        while (l1!=null || l2!=null){
            if(l1!=null){
                sum+=l1.val*mul;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.val*mul;
                l2 = l2.next;
            }
            ListNode next = new ListNode(sum%10);
            sum/=10;
            head.next = next;
            head = next;

        }

        if(sum!=0){
            ListNode next = new ListNode(sum%10);
            head.next = next;
            head = next;
        }
        return head_1.next;
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

    /**
     * 折叠数查询
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 三数之和
     * @param nums
     * @return
     */

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

    /**
     * 最大岛屿面积
     * @param grid
     * @return
     */
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

    /**
     * 最大岛屿面积
     * @param grid
     * @return
     */
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

    /**
     * 最大岛屿面积
     * @param grid
     * @param i
     * @param j
     * @param sum
     * @return
     */
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


    /**
     * 一组数和等于sum
     * @param result
     * @param list
     * @param nums
     * @param i
     * @param sum
     */
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

    /**
     * 还原ip地址
     * @param s
     * @return
     */
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

    /**
     * 单词个数
     * @param s
     * @return
     */
    public  String reverseWords(String s){
        if(" ".equals(s) || "".equals(s)){
            return "";
        }
        String[] array = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            if(array[i].equals(""))continue;
            sb.append(array[i].trim());
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 大数乘法
     * @param num1
     * @param num2
     * @return
     */
    public  String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        char[]arrar_1 =  num1.toCharArray();
        char[]arrar_2 =  num2.toCharArray();
        int[] result_1 = new int[250];
        int[] result_2 = new int[250];
        for (int i = arrar_2.length - 1; i >= 0; i--) {
            for (int j = arrar_1.length - 1; j >= 0; j--) {
                result_2[i+j+1] = result_2[i+j+1]+(arrar_1[j]-'0')*(arrar_2[i]-'0');
                result_2[i+j] = result_2[i+j+1] / 10;
                result_2[i+j+1] = result_2[i+j+1] % 10;

            }
            for (int k = result_2.length - 1; k >= 0; k--) {
                result_1[k] += result_2[k];
                if(k!=0)
                    result_1[k-1] += result_1[k]/10;
                result_1[k] = result_1[k] % 10;
                result_2[k] = 0;
            }

        }


        StringBuilder sb = new StringBuilder();

        if(result_1[0]!=0){
            sb.append(result_1[0]);
        }
        for (int i = 1 ; i < arrar_1.length + arrar_2.length; i++) {
            sb.append(result_1[i]);
        }

        return sb.toString();
    }
}
