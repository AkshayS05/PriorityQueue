import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CheckMaxHeap {
    private static boolean isMaxHeap(int[] arr) {
        //in order to cheeck if the given array represents Max Heap, we will compare thr children with the parent
        // to get the left children: int left= 2 * i +1;
        //to get right children: int right= 2 *i +2;
        //these two will always be plus one of the root, thus giving us children
        for (int i = 0; i < arr.length; i++) {
            //these two will be updated with every call
                int leftChild= 2 * i +1;
                int rightChild= 2 * i +2;
            if (leftChild<arr.length&&arr[i]<arr[leftChild]){
                //if any of the child is greater than the parent, return false from there.
                return false;
            }
            if(rightChild<arr.length&&arr[i]<arr[rightChild]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int arr[]={42, 20, 18, 6, 14, 11, 9, 4};
        System.out.println(isMaxHeap(arr));
    }


}
