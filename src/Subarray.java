import java.util.*;
public class Subarray
{
    public static List<Integer> maximumOfAllSubarray(int[] arr,int k){
        int n=arr.length;
        int left=0;
        List<Integer> result=new ArrayList<>();
        while(left < n-k+ 1){
            int right=left + 1;
            List<Integer> temp=new ArrayList<>();
            int max=Integer.MIN_VALUE;
            temp.add(arr[left]);
            while(right < n){
                temp.add(arr[right]);
                if(left - right + 1 ==k){
                    for(int num:temp){
                        max=Math.max(max,num);
                    }
                    result.add(max);
                    temp.remove(arr[left]);
                    left++;
                    break;
                }
                right++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,1,4,5,2,3,6};
        int k=3;
        System.out.println(maximumOfAllSubarray(arr,k));
    }
}
