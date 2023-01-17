package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);// Sắp xếp array này theo thứ tự tăng dần

        List<List<Integer>>ans =new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i==0 ||(i>0 && nums[i]!=nums[i-1])){ // phần tử ở vị trí số 0 là phần tử đầu tiên nên sẽ không bị bao hàm
                // bởi bất kì một phép thử nào ở đằng trước
                // từ phần  tử vị trí số 1 trở đi nếu phần tử ở ngay phía trước bằng nó thì khi chạy thuật toán sẽ tốn
                // bộ nhớ do chạy trùng lặp bởi phần tử đằng trước đã bao hàm rồi

                int l=i+1,h=nums.length-1;
                int sum=0-nums[i]; //b+c=-a <=> b+a=sum;

                while(l<h){
                    if(nums[l]+nums[h]==sum){

                        ans.add(Arrays.asList(nums[i],nums[l],nums[h]));

                        while(l<h && nums[l]==nums[l+1]) l++;// Loại bỏ các duplicate của array thỏa mãn
                        while(l<h && nums[h]==nums[h-1]) h--;// Loại bỏ các duplicate của array thỏa mãn

                        l++;
                        h--;
                    }

                    else if(nums[l]+nums[h] < sum) l++; // giảm số trừ hay số hạng âm

                    else h--; // giảm số bị trừ hay số hạng dương
                }

            }
        }
        return ans;

    }
}
