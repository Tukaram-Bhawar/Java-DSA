import java.util.*;

public class union {

    public static void getuni(int arr1[],int arr2[]){
        HashSet<Integer> set=new HashSet<Integer>();
      
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }

        System.out.println(set.size());
    }

    public static void main(String[] args) {
        int arr1[]={1,2,3,4,5};
        int arr2[]={3,4,6,2,7,8,88,66};
        getuni(arr1,arr2);
    }
}
