public class Arr <T> implements StackADT<T>{
    private int currSize;
    private int top;
    private T[] listArray;
    private int direction;
    private final int defaultSize=10;

    Arr(int... size){
        if(size.length>0)
            currSize=size[0];
        else
            currSize=defaultSize;
        top=0;
        listArray=(T[]) new Object[currSize];
        direction=1;
    }

    Arr(T[] ara,int direction){
        listArray=ara;
        this.direction=direction;
        if(direction==1)
            top=0;
        else
            top=ara.length-1;
        currSize=ara.length;
    }

    private void increase(){
        T[] temp=(T[])new Object[currSize*2];
        for(int i=0;i<currSize;i++){
            temp[i]=listArray[i];
        }
        listArray=temp;
        currSize*=2;
    }

    private void align(){
        for(int i=currSize;i>=currSize/2;i--){
            listArray[i]=listArray[i-currSize/2];
        }
        top=currSize/2-1;
    }

    @Override
    public void clear() {
        if(direction==1)
            top=0;
        else
            top=currSize-1;
    }

    @Override
    public void push(T it) {
        if(direction==1){
            if(top==currSize)
                increase();
            listArray[top++]=it;
        }
        else{
            if(top==-1){
                increase();
                align();
            }
            listArray[top--]=it;
        }
    }

    @Override
    public T pop() {
        if(direction==1){
            assert top>0 : "Stack is empty";
            if(top<=0)
                return null;
            else
                return listArray[--top];
        }
        else{
            assert top<currSize-1 : "Stack is empty";
            if(top>=currSize-1)
                return null;
            else
                return listArray[++top];
        }
    }

    @Override
    public T topValue() {
        if(direction==1){
            assert top>0 : "Stack is empty";
            if(top<=0)
                return null;
            else
                return listArray[top-1];
        }
        else{
            assert top<currSize-1 : "Stack is empty";
            if(top>=currSize-1)
                return null;
            else
                return listArray[top+1];
        }
    }

    @Override
    public int length() {
        if(direction==1){
            return top;
        }
        else{
            return currSize-1-top;
        }
    }

    @Override
    public void setDirection(int direction) {
        if (length()==0){
            this.direction=direction;
            if(direction==1)
                top=0;
            else
                top=currSize-1;
        }
    }
}
