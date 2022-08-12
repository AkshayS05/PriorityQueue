import java.util.ArrayList;

public class PriorityQueue {
    //ArrayList, which will be used as a PriorityQueue
    private ArrayList<Integer> heap;
    PriorityQueue(){
        this.heap= new ArrayList<>();
    }
    //getMin()
     int getMin(){
        if(heap.isEmpty()){
            //throws an exception
        }
        return heap.get(0);
    }
    //isEmpty
    boolean isEmpty(){
        return heap.size()==0;
    }
    //insert()
     void insert(int data){
        heap.add(data);
        //required up heapify to check whether the element added is less than the parent or not.
        //if element added is not smaller then we will swap
        int childIndex= heap.size()-1;
        int parentIndex= (childIndex-1)/2;
        while(childIndex>0){
            if(heap.get(childIndex)<heap.get(parentIndex)){
                int temp= heap.get(childIndex);
                heap.set(childIndex,heap.get(parentIndex));
                heap.set(parentIndex,temp);
                childIndex=parentIndex;
                parentIndex= (childIndex-1)/2;
            }else{
                return;
            }
        }
    }
     int remove(){
        if(heap.isEmpty()){
            //throws an exception

        }
        //storing the value which needs to be removed and returned
        int temp= heap.get(0);
        //setting up the last elem value to the root
        heap.set(0,heap.get(heap.size()-1));
        //removing the last element, this way the root which has the smallest data will be removed
        heap.remove(heap.size()-1);
        //requires to check if the data at root is the smallest by comparing it with the children
        //thus, we need to do down heapify
        int index=0;
        int minIndex=index;
        int leftChild= 1; //2 * 0 +1=1;
        int rightChild= 2; // 2* 0 +2=2;

        while(leftChild<heap.size()){
            if(heap.get(leftChild)<heap.get(minIndex)){
                minIndex= leftChild;
            }
            if(rightChild<heap.size()&&heap.get(rightChild)<heap.get(minIndex)){
                minIndex= rightChild;
            }
            //if any of the child element is smaller, we will get that index, otherwise index will be same..
            //if index is same then we can simply return that index
            if(minIndex==index){
                break;
            }
            //swapping
            else{
                int temp1= heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex, temp1);
                //now we will check for the lower ones
                index= minIndex;
                leftChild= 2*index+1;
                rightChild= 2* index+2;
                }
            }

        return temp;
    }
    //size()
     int size(){
        return heap.size();
    }
}
