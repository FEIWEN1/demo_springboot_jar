package com.dingzhi.demo_springboot_jar.leecode;

import java.util.*;

/**
 * @author feiwen
 * @date 2024/3/18
 */
public class TwoSum {

    /**
     * 两数只和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<=nums.length-1;i++){
            Integer index = map.get(nums[i]);
            if(index!=null){
                return new int[]{i, index};
            }
            map.put(target-nums[i],i);
        }
        return new int[]{-1,-1};
    }

    /**
     * 三数只和
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * 你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int p=i+1;
            int q=nums.length-1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while(p<q){
                if (nums[i] + nums[p] + nums[q] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[p]);
                    list.add(nums[q]);
                    res.add(list);
                }

                if (nums[i] + nums[p] + nums[q] > 0) {
                    int q1 = q - 1;
                    while (q1>p&&nums[q1] == nums[q]) {
                        q1--;
                    }
                    q=q1;
                }else{
                    int p1=p+1;
                    while (p1<q&&nums[p1]==nums[p]){
                        p1++;
                    }
                    p=p1;
                }
            }
        }
        return res;
    }
}
