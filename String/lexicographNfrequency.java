import java.util.*;
public class lexicographNfrequency {
    public static int[] getRepeatCharOrder(String[] words){
        int n=words.length;
        int[] numOfRepeatChar=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<words[i].length();j++){
                char ch=words[i].charAt(j);
                int count=0;
                for(int k=j+1;k<words[i].length();k++){
                    if(words[i].charAt(k)==ch){
                        count++;
                    }
                }
                if(count!=0){
                    numOfRepeatChar[i]++;//tracking frequency of repeating char
                }
            }
        }
        //checking frquency of each string
        // for(int i=0;i<n;i++){
        //     System.out.print(numOfRepeatChar[i]+" ");
        // }
        return numOfRepeatChar;
    }
    public static int getMaxFreq(int[] repeatedCharInEachString){
        int max=repeatedCharInEachString[0];
        int maxIdx=0;
        for(int i=1;i<repeatedCharInEachString.length;i++){
            if(repeatedCharInEachString[i]>max && repeatedCharInEachString[i]>=0){
                max=repeatedCharInEachString[i];
                
                maxIdx=i;
            }
        }
        repeatedCharInEachString[maxIdx]=-repeatedCharInEachString[maxIdx];//mark as visited by making it negative
        return maxIdx;
    }
    public static void lexiOrderIfSameFreq(String[] sortWords,int[] repeatedCharInEachString){
        for(int i=0;i<sortWords.length;i++){
            String largest=sortWords[i];
            int largestIdx=i;
            for(int j=i+1;j<sortWords.length;j++){
                if((largest.compareTo(sortWords[j])<0) && (repeatedCharInEachString[j]==repeatedCharInEachString[i])){
                    largest=sortWords[j];
                    largestIdx=j;
                }
            }
            //swap
            String temp=sortWords[i];
            sortWords[i]=sortWords[largestIdx];
            sortWords[largestIdx]=temp;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        // String[] words={"strings","character","spoons","apply","programming","rotator","alloy"};
        //user input
        System.out.print("How many words do you have? :- ");
        int n=sc.nextInt();
        String[] words=new String[n];
        System.out.print("Enter words : ");
        for(int i=0;i<n;i++){
            words[i]=sc.next();
        }
        int[]repeatedCharInEachString =getRepeatCharOrder(words);
        //sort the strings according to num of repeating charcaters in it
        String[] sortWords=new String[n];
        for(int i=0;i<n;i++){
            int maxFreqIdx=getMaxFreq(repeatedCharInEachString);
            sortWords[i]=words[maxFreqIdx];
        }
        Arrays.sort(repeatedCharInEachString);
        //since all strings are sorted according to num of repeating characters 
        //now sorting if any two strings have same frequency according to lexicograhical order-->compareTo function
        lexiOrderIfSameFreq(sortWords,repeatedCharInEachString);
        //printing overall result
        System.out.println("Increasing order based on count of repeating characters nad if same count then lexicographical order is taken :-");
        for(int i=0;i<sortWords.length;i++){
            System.out.print(sortWords[i]+"["+Math.abs(repeatedCharInEachString[i])+"] ");
        }

    }
    
}