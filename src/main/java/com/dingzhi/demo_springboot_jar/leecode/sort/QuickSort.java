package com.dingzhi.demo_springboot_jar.leecode.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author feiwen
 * @date 2024/4/5
 */
public class QuickSort {

    //定义通用排序步骤
    static   void sort(int[] arrs,int start,int end){
        //判断输入 递归终止条件
        if (start >= end) {
            return;
        }
        //先处理整个数组
        int middle = partionArrays(start, end, arrs);
        //再递归处理小数组
        sort(arrs,start,middle-1);
        sort(arrs,middle+1,end);

    }

    /**
     * 定义分区函数 输入数组与起始位置 将小元素放到数组左边 大元素放右边 并返回中间元素的下标
     * @param start
     * @param end
     * @param arrs
     * @return
     */
    static int partionArrays(int start,int end,int[] arrs){
        //确定分区元素 可以是随便位置 这里固定选数组最后一个元素
        int partData=arrs[end];
        //确定大区间的下标 初始状态下就是第一个元素 发现一个小元素值就+1
        int partIndex=start;
        //循环数组 做两件事情：1。发现小元素partIndex值+1 2。发现小元素和 partIndex位置元素互换
        for (int i = start; i < end; i++) {
            //判断是否是小元素
            if (partData > arrs[i]) {
                //先互换元素再+1
                if(i==partIndex){
                    partIndex++;
                }else{

                    int tmp=arrs[i];
                    arrs[i]=arrs[partIndex];
                    arrs[partIndex]=tmp;
                    partIndex++;
                }
            }
        }
        //循环完毕 因为上面循环没有遍历到分区判断元素 把大分区第一个元素和它互换完成最后一步
        arrs[end]=arrs[partIndex];
        arrs[partIndex]=partData;
        return partIndex;

    }

    public static void main(String[] args) {
//        int[] a = {3, 1, 7, 0, 4, 3, 2, 8};
////        int[] a = {6, 11, 3, 8, 9};
//        sort(a, 0, 7);
//        System.out.println(Arrays.toString(a));
        TreeMap<Double,String> map=new TreeMap<>();
        map.put(4.0, "d");
        map.put(1.0,"a");
        map.put(2.0,"b");
        map.put(3.0, "c");
        map.put(5.0, "e");
        Double[] arrs = map.keySet().toArray(new Double[0]);
        System.out.println(Arrays.toString(arrs));

        HashMap<Double,String> map1=new HashMap<>();
        map1.put(4.0, "d");
        map1.put(1.0,"a");
        map1.put(2.0,"b");
        map1.put(3.0, "c");
        map1.put(5.0, "e");
        Double[] arrs1 = map1.keySet().toArray(new Double[0]);
        System.out.println(Arrays.toString(arrs1));

    }

}
