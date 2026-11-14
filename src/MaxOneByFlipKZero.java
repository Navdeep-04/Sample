

public class MaxOneByFlipKZero {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1};
        int k = 1;
        int max = 0;
        int left = 0;
        int zerosCount = 0;
        int n = arr.length;
        for(int right = 0; right < n; right++){
            if(arr[right] == 0){
                zerosCount++;
            }

            while(zerosCount > k){
                if(arr[left] == 0){
                    zerosCount--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
