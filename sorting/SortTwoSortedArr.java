public class SortTwoSortedArr {
    public static int[] sort(int[]arr1,int[]arr2){
        int n1=arr1.length;
        int n2=arr2.length;
        int[] sortedArr=new int[n1+n2];
        int ptr1=0;
        int ptr2=0;
        int i=0;
        while(ptr1<n1 && ptr2 < n2){
            if(arr1[ptr1]<arr2[ptr2]){
                sortedArr[i]=arr1[ptr1];
                i++;
                ptr1++;
            }else{
                sortedArr[i]=arr2[ptr2];
                i++;
                ptr2++;
            }
        }
        //remaining ele insertion
        while(ptr1<n1){
            sortedArr[i++]=arr1[ptr1++];
        }
        while(ptr2<n2){
            sortedArr[i++]=arr2[ptr2++];
        }
        return sortedArr;
    }
    public static void main(String []args){
        int[]arr1={-3,15};
        int[]arr2={8,11,13,17};
        int[]sortedArr=sort(arr1,arr2);
        //printing sorted array
        for(int i=0;i<sortedArr.length;i++){
            System.out.print(sortedArr[i]+" ");
        }
    }
}
