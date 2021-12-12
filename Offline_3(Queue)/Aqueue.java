public class Aqueue<T> implements QueueADT<T>{
    private static final int defaultSize = 10;
    private int maxSize; // Current maximum size of queue
    private int front; // Index of front element
    private int rear; // Index of rear element
    private T[] listArray; // Array holding queue elements

    Aqueue(int... size){
        if(size.length>0)
            maxSize=size[0]+1;
        else
            maxSize=defaultSize+1;
        rear=0;
        front=1;
        listArray=(T[]) new Object[maxSize];
    }

    Aqueue(T[] ara){
        listArray=ara;
        rear=0;
        front=1;
        maxSize=ara.length;
    }

    private void increase(){
        T[] temp=(T[])new Object[(maxSize-1)*2+1];
        for(int i=front;i<maxSize;i++){
            temp[i]=listArray[i];
        }
        listArray=temp;
        maxSize=(maxSize-1)*2+1;
    }

    //Reinitialize
    @Override
    public void clear() {
        rear=0;
        front=1;
    }

    //Put "it" in queue
    @Override
    public void enqueue(T it) {
        if((rear+2)%maxSize==front){
            increase();
        }
        rear=(rear+1)%maxSize; //Circular increment
        listArray[rear]=it;
    }

    //Remove and return front value
    @Override
    public T dequeue() {
        if(length()==0){
            System.out.println("Queue is empty");
            return null;
        }
        T it=listArray[front];
        front=(front+1)%maxSize;
        return it;
    }

    @Override
    public int length() {
        return ((rear+maxSize)-front+1)%maxSize;
    }

    @Override
    public T frontValue() {
        if(length()==0){
            System.out.println("Queue is empty");
            return null;
        }
        return listArray[front];
    }

    @Override
    public T rearValue() {
        if(length()==0){
            System.out.println("Queue is empty");
            return null;
        }
        return listArray[rear];
    }

    //Remove and return rearValue
    @Override
    public T leaveQueue() {
        if(length()==0){
            System.out.println("Queue is empty");
            return null;
        }
        T it=listArray[rear];
        rear=(rear-1)%maxSize;
        return it;
    }
}
