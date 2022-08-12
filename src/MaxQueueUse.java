public class MaxQueueUse {
    public static void main(String[] args) {
        MaxPriorityQueue pq= new MaxPriorityQueue();
        int arr[]= {5,1,9,2,0};
        for (int i = 0; i <arr.length ; i++) {
            pq.insert(arr[i]);
        }
        while(!pq.isEmpty()){
            System.out.print(pq.remove()+  " ");
        }
        System.out.println();
    }
}
