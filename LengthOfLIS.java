class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int [] LIS = new int[nums.length];  
        for(int i= 0; i < nums.length; i++){                                    // initialize every entry as 1 
            LIS[i] = 1;
        }
        int maxVal = 1;
        for(int j = nums.length - 1; j >= 0; j--){                              // traverse from end to beginning using         
            for (int k = j - 1; k >= 0; k--){                                   // previous values to update LIS list 
                if(nums[k] < nums[j]){
                    LIS[k] = Math.max(LIS[k],1 + LIS[j]);
                    if (LIS[k] > maxVal) maxVal = LIS[k];
                }
            }
        }
        return maxVal;                                                          // returns maximum # of subsequence
    }
    public void test0(){                                                       
        int[] nums = {4,7,9,8};
        int a = lengthOfLIS(nums);
        assert(a == 3);
    } 
    public void test1(){
        int[] nums = {10,9,2,5,3,7,101,18};
        int a = lengthOfLIS(nums);
        assert(a == 4);
    }
    public void test2(){
        int[] nums = {7,7,7,7,7,7,7};
        int a = lengthOfLIS(nums);
        assert(a == 1);
    }
    public void test3(){
        int[] nums = {0,1,0,3,2,3};
        int a = lengthOfLIS(nums);
        assert(a == 4);
    }

    public static void main(String args[]){
        LengthOfLIS l = new LengthOfLIS();
        l.test0();
        l.test1();
        l.test2();
        l.test3();
    }
}