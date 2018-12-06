package rock.acm.ds;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 线段树
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-27 20:59
 */
public class Main1 {
    private static SegmenTree[] array = new SegmenTree[10];
    public static void main(String[] args) {
        build(1,1,10);
        System.out.println("JSON.toJSONString(array) = " + JSON.toJSONString(array));
    }
    private static int cal(int num){
        if(array[num].cover ==1) return array[num].right - array[num].left;
        if(array[num].left+1 == array[num].right) return 0;
        return cal(2*num) + cal(2*num+1);
    }
    private static void insert(int l,int r,int num){
        if(array[num].left == l && array[num].right == r){
            array[num].cover = 1;
            return;
        }
        if(r <= array[num].mid){
            insert(l,r,2*num);
        }else if(l >= array[num].mid){
            insert(l,r,2*num+1);
        }else{
            insert(l,array[num].mid,2*num);
            insert(array[num].mid,r,2*num+1);
        }
    }
    private static void build(int k,int l,int r){
        array[k].left = l;
        array[k].right = r;
        array[k].mid = (l+r)/2;
        if(l+1!=r){
            build(2*k,l,array[k].mid);
            build(2*k+1,array[k].mid,r);
        }
    }
    private static class SegmenTree{
        public int left =0;
        public int right =0;
        public int mid =0;
        public int cover =0;
        public SegmenTree next_left;
        public SegmenTree next_right;

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public int getCover() {
            return cover;
        }

        public void setCover(int cover) {
            this.cover = cover;
        }

        public SegmenTree getNext_left() {
            return next_left;
        }

        public void setNext_left(SegmenTree next_left) {
            this.next_left = next_left;
        }

        public SegmenTree getNext_right() {
            return next_right;
        }

        public void setNext_right(SegmenTree next_right) {
            this.next_right = next_right;
        }
    }
}
