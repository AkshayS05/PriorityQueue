import java.util.Arrays;
import java.util.PriorityQueue;

public class KSortedElements {
    private static void sortKSorted(int[] arr, int k) {
        //create a heap
        PriorityQueue<Integer> pq= new PriorityQueue<>();

        //add k elements into the heap from the input array
        int i=0;
        for (; i < k; i++) {
            pq.add(arr[i]);
        }
        //remove from the heap and add in the array on its right position
        //also add the remaining elements into the heap
        //this step will add k elements in a sorted manner inside the array
        for(;i<arr.length; i++){
            arr[i-k]= pq.remove();
            pq.add(arr[i]);
        }
        //now we are left with the length- k elements, thus add them in the array by removing
        //from the heap
        for (int j = arr.length-k; j <arr.length ; j++) {
            arr[j]= pq.remove();
        }
    }
    public static void main(String[] args) {
        int arr[]= {2,4,1,9,6,8};
        int k=3;
        sortKSorted(arr, k);
        System.out.println(Arrays.toString(arr));
    }

}
