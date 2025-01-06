import java.util.*;
public class subarr {

    public static int getnum(int arr[],int k){
        HashMap<Integer,Integer> sub=new HashMap<>();
        sub.put(0, 1);
        int sum=0;
        int ans=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sub.containsKey(sum-k)){
                ans+=sub.get(sum-k);
            }
            if(sub.containsKey(sum)){
                sub.put(sum, sub.get(sum)+1);
            }else{
                sub.put(sum, 1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={10,2,-2,-20,10};
        System.out.println(getnum(arr, -10));
    }
    
}
