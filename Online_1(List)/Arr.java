public class Arr <T> implements ListADT<T> {
    private int chunkSize;
    private int currSize;
    private int curr;
    private T[] lAra;

    Arr(){
        currSize=0;
        curr=0;
        chunkSize=10; //Predefined size
        lAra=(T[])new Object[chunkSize];
    }

    Arr(int x) {
        currSize=0;
        curr=0;
        chunkSize=x;
        lAra=(T[])new Object[chunkSize];
    }

    Arr(T ara[],int x){
        currSize=ara.length;
        curr=0;
        chunkSize=x;
        lAra=(T[])new Object[chunkSize];
        for(int i=0;i<ara.length;i++)
            lAra[i]=ara[i];
    }

    private void increase(){
        T[] temp=(T[])new Object[currSize+chunkSize];
        for(int i=0;i<currSize;i++){
            temp[i]=lAra[i];
        }
        lAra=temp;
    }

    @Override
    public void clear() {
        currSize=0;
        curr=0;
        T[] temp=(T[])new Object[chunkSize];
        lAra=temp;
    }

    @Override
    public void insert(T el){
        if(currSize%chunkSize==0 && currSize!=0){
            increase();
        }
        for(int i=currSize;i>curr;i--)
            lAra[i]=lAra[i-1];
        lAra[curr]=el;
        currSize++;
    }

    @Override
    public void append(T el){
        if(currSize%chunkSize==0 && currSize!=0){
            increase();
        }
        lAra[currSize++]=el;
    }

    @Override
    public T remove(){
        T m=lAra[curr];
        for(int i=curr;i<currSize-1;i++)
            lAra[i]=lAra[i+1];
        currSize--;
        if(curr==currSize)
            curr--;
        return m;
    }

    @Override
    public void moveToStart(){
        curr=0;
    }

    @Override
    public void moveToEnd(){
        curr=currSize-1;
    }

    @Override
    public void prev(){
        if(curr==0)
            System.out.println("Curr is already at starting point");
        else
            curr--;
    }

    @Override
    public void next(){
        if(curr==currSize-1)
            System.out.println("Curr is already at end point");
        else
            curr++;
    }

    @Override
    public int length(){
        return currSize;
    }

    @Override
    public int currPos(){
        return curr;
    }

    @Override
    public void moveToPos(int pos){
        if(pos>=0 && pos<currSize)
            curr=pos;
        else
            System.out.println("Invalid position");
    }

    @Override
    public T getValue(){
        if(curr>=0 && curr<currSize)
            return lAra[curr];
        else{
            System.out.println("No current element");
            return null;
        }
    }

    @Override
    public int Search(T item){
        int p=-1;
        for(int i=0;i<currSize;i++)
        {
            if(lAra[i].equals(item)){
                p=i;
                break;
            }
        }
        return p;
    }
}