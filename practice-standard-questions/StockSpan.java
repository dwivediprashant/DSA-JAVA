/*Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day. */
import java.util.*;
public class StockSpan {
    public static int[] calcSpan(int[] stocks){
        int n=stocks.length;
        int[] span=new int[n];
        for(int i=n-1;i>=0;i--){
            int spanCount=0;
            int currStock=stocks[i];
            for(int j=i;j>=0;j--){
                if(stocks[j]<=currStock){
                    spanCount++;
                }else{
                    break;
                }
            }
            span[i]=spanCount;
        }
        return span;
    }
    public static void printArr(int[]arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+"  ");
        }
    }
    public static void main(String[] args) {
        int[] stocks ={100,80,60,70,60,85,105};

        int[] span=calcSpan(stocks);
        printArr(span);
    }
}
