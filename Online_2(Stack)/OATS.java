public class OATS <T>{
    private T[] ara;
    private int top1;
    private int top2;
    private int currSize;
    Arr<T> front;
    Arr<T> back;
    private final int defaultSize=10;

    OATS(T[] a){
        ara=(T[]) new Object[a.length];
        front=new Arr<>(ara,1);
        back=new Arr<>(ara,-1);
        top1=0;
        top2=defaultSize-1;
        currSize=a.length;
    }

    private void increase(){
        T[] temp=(T[])new Object[currSize*2];
        for(int i=0;i<currSize;i++){
            temp[i]=ara[i];
        }
        ara=temp;
        currSize*=2;
    }

    private void align(){
        for(int i=currSize-1;i>=top2+1+currSize/2;i--){
            ara[i]=ara[i-currSize/2];
        }
        top2=top2+currSize/2;
    }


    public void pushA(T item){
        if(top1==top2+1){
            increase();
            align();
        }
        front.push(item);
    }

    public void pushB(T item){
        if(top2==top1-1){
            increase();
            align();
        }
        back.push(item);
    }

    public T topValueA(){
        return front.topValue();
    }

    public T topValueB(){
        return back.topValue();
    }

    public T popA(){
        return front.pop();
    }

    public T popB(){
        return back.pop();
    }
}
