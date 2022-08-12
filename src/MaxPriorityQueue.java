import java.util.ArrayList;

public class MaxPriorityQueue {
    private ArrayList<Integer> heap;

    MaxPriorityQueue(){
        this.heap= new ArrayList<>();
    }
    //getMax
    //removeMax
    //insert
    //size
    //isEmpty

    int size(){
        return heap.size();
    }
    boolean isEmpty(){
        return heap.size()==0;
    }
    int getMax(){
        if(heap.isEmpty()){
            return -1;
        }
        return heap.get(0);
    }
    void insert(int data){
        heap.add(data);
        int childIndex= heap.size()-1;
        int parentIndex= (childIndex-1)/2;

        while(childIndex>0){
            if(heap.get(childIndex)>heap.get(parentIndex)){
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
            return -1;
        }
        int temp= heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int index=0;
        int maxIndex=index;
        int leftChild= 1;
        int rightChild=2;

        while(leftChild<heap.size()){
            if(heap.get(maxIndex)<heap.get(leftChild)){
                maxIndex= leftChild;
            }
            if(rightChild<heap.size()&&heap.get(maxIndex)<heap.get(rightChild)){
                maxIndex= rightChild;
            }
            if(maxIndex==index){
                break;
            }else{
                int temp1= heap.get(maxIndex);
                heap.set(maxIndex, heap.get(index));
                heap.set(index,temp1 );
                index= maxIndex;
                leftChild= 2 * index+1;
                rightChild= 2 * index+2;
            }
        }
        return temp;
    }
}
