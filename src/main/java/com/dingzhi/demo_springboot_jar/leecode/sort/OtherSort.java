package com.dingzhi.demo_springboot_jar.leecode.sort;

import java.util.Arrays;

/**
 * @author feiwen
 * @date 2024/4/5
 */
public class OtherSort {

    /**
     * 冒泡排序
     * @param arrs
     */
    public static void bubbleSort(int[] arrs){
        //两层循环 外层循环相当于从右开始设置元素 内层循环遍历数组 i和i+1下标元素比较 i+1元素小 互换元素位置
        for (int i = arrs.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arrs[j]>arrs[j+1]){
                    int tmp=arrs[j];
                    arrs[j]=arrs[j+1];
                    arrs[j+1]=tmp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arrs = {1, 4, 2, 6, 9, 0, 5};
        bubbleSort(arrs);
        System.out.println(Arrays.toString(arrs));
    }

}
