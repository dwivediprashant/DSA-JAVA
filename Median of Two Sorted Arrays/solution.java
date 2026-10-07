1class Solution {
2    public static int[] mergeTwoSortedArr(int []nums1,int[]nums2){
3        int m=nums1.length;
4        int n=nums2.length;
5        int ptr1=0,ptr2=0;
6        int [] result=new int[m+n];
7        int resultPtr=0;
8        while(ptr1<m && ptr2<n){
9            if(nums1[ptr1]<nums2[ptr2]){
10                result[resultPtr++]=nums1[ptr1++];
11            }else{
12                result[resultPtr++]=nums2[ptr2++];
13            }
14        }
15        while(ptr1<m){
16            result[resultPtr++]=nums1[ptr1++];
17        }
18        while(ptr2<n){
19            result[resultPtr++]=nums2[ptr2++];
20        }
21        return result;
22    }
23    public static double getMedian(int[]arr){
24        int n=arr.length;
25        int midIdx=n/2;;
26        double median=0;
27        if(n%2==0){ 
28            median=((double)arr[midIdx]+arr[midIdx-1])/2;
29        }else{
30            median=arr[midIdx];
31        }
32        return median;
33    }
34    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
35        int[] mergeArr=mergeTwoSortedArr(nums1,nums2);
36        return getMedian(mergeArr);
37    }
38}