public class leetcode88{
    public static void sortBoth(int[]nums1,int[]nums2,int m,int n){
        int i=m-1;//nums1 pointer
        int j=n-1;//nums2 pointer
        int last=m+n-1;//last pointer to fill 
        while(i>=0 && j>=0){
            if(nums2[j]>nums1[i]){
                nums1[last--]=nums2[j--];
            }else{
                nums1[last--]=nums1[i--];
            }
        }
        while(j>=0){//means  nums2's some element still remain so handle them
            nums1[last--]=nums2[j--];
        }
        //printing nums1 that is sorted array
        for(int k=0;k<m+n;k++){
            System.out.print(nums1[k]+" ");
        }
    }
    public static void main(String[]args){
        int[]nums1={-2,3,3,4,6,0,0,0,0,0,0};
        int m=5;
        int[]nums2={-3,0,0,2,12,19};
        int n=6;
        sortBoth(nums1,nums2,m,n);
    }
}
