import java.util.*;
class trapRainwater {
    public static void calcLeftMax(int [] leftMax,int[] height){
        int max=0;
        for(int i=0;i<height.length;i++){
            if(height[i]>=max){
                max=maximum(height[i],max);
            }
            leftMax[i]=max;
        }
    }
    public static void calcRightMax(int [] rightMax,int[] height){
        int max=0;
        for(int i=height.length-1;i>=0;i--){
            if(height[i]>=max){
                max=maximum(height[i],max);
            }
            rightMax[i]=max;
        }
    }
    public static int minimum(int left,int right){
        if(left<right){
            return  left;
        }
        return right;
    }
    public static int maximum(int left,int right){
        if(left>right){
            return  left;
        }
        return right;
    }
    public static int trap(int[] height) {
        int n=height.length;
        int [] leftMax=new int[n];
        int [] rightMax=new int[n];
        leftMax[0]=0;
        rightMax[n-1]=0;
        calcLeftMax(leftMax,height);
        calcRightMax(rightMax,height);
        int left,right;
        int trapWater=0;
        for(int i=1;i<height.length-1;i++){
            left=leftMax[i];
            right=rightMax[i];
            int minValue=minimum(left,right);
            trapWater+=minValue-height[i];
        }
        return trapWater;
    }
    public static void main(String args[]){
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        int trappedWater=trap(height);
        System.out.print("Total trapped rainwater : "+trappedWater);
    }
}