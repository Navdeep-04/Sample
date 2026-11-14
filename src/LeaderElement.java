public class LeaderElement {
    public static void main(String[] args) {
        int[] arr = {4,11,2,3,1};
        boolean check = true;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    check = true;
                }
                else{
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
