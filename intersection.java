import java.util.HashSet;

public class intersection {

    public static void getintersection(int arr1[],int arr2[]){
        @SuppressWarnings("rawtypes")
        HashSet<Integer> set=new HashSet();
        int count =0;
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }

        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }

        System.out.println(count);
    }
    public static void main(String[] args) {
        int arr1[]={1,2,3,4,5};
        int arr2[]={1,2,3,4,5,1,2};
        getintersection(arr1,arr2);
    }
}
