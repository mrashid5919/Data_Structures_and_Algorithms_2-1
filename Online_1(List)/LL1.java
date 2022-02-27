public class LL1 <T> implements ListADT<T> {
    private Link<T> head; //Pointer to list header
    private Link<T> tail; //Pointer to last element
    protected Link<T> curr; //Access to current element
    private int cnt; //Size of list

    LL1(){
        curr=tail=head=new Link<T>(null); //Create header
        cnt=0;
    }

    LL1(T ara[]){
        curr=tail=head=new Link<T>(null); //Create header
        cnt=0;
        for(int i=0;i< ara.length;i++){
            tail=tail.setNext(new Link<T>(ara[i],null));
            cnt++;
        }
    }

    @Override
    public void clear() {
        head.setNext(null);
        curr=tail=head=new Link<T>(null);
        cnt=0;
    }

    @Override
    public void insert(T item) {
        curr.setNext(new Link<T>(item,curr.next()));
        /*if(tail==curr)
            tail=curr.next();*/
        cnt++;
    }

    @Override
    public void append(T item) {
        tail=tail.setNext(new Link<T>(item,null));
        cnt++;
    }

    @Override
    public T remove() {
        if(curr.next()==null)
            return null;
        T it=curr.next().element();
        if(tail==curr.next())
            tail=curr;
        curr.setNext(curr.next().next());
        cnt--;
        return it;
    }

    @Override
    public void moveToStart() {
        curr=head;
    }

    @Override
    public void moveToEnd() {
        curr=head;
        for(int i=0;i<cnt-1;i++)
            curr=curr.next();
    }

    @Override
    public void prev() {
        if(curr==head)
            return;
        Link<T> temp=head;
        while(temp.next()!=curr)
            temp=temp.next();
        curr=temp;
    }

    @Override
    public void next() {
        if(curr!=tail)
            curr=curr.next();
    }

    @Override
    public int length() {
        return cnt;
    }

    @Override
    public int currPos() {
        Link<T> temp=head;
        int i;
        for(i=0;curr!=temp;i++)
            temp=temp.next();
        return i;
    }

    @Override
    public void moveToPos(int pos) {
        if(pos>=0 && pos<cnt){
            curr=head;
            for(int i=0;i<pos;i++)
                curr=curr.next();
        }
    }

    @Override
    public T getValue() {
        if(curr.next()==null)
            return null;
        return curr.next().element();
    }

    @Override
    public int Search(T item) {
        int i=-1;
        Link<T> temp=head;
        for(int j=0;j<cnt;j++){
            if(temp.next().element().equals(item)){
                i=j;
                break;
            }
            temp=temp.next();
        }
        return i;
    }

    public void swap(int pos){
        T temp=getValue();
        int c=currPos();
        moveToPos(pos);
        T temp2=getValue();
        curr.next().setElement(temp);
        moveToPos(c);
        curr.next().setElement(temp2);
    }

    public Integer findMaxUptoCur(){
        Integer mx=(Integer) head.next().element();
        int c=currPos();
        moveToStart();
        for(int i=0;i<=c;i++){
            if((Integer)getValue()>mx){
                mx=(Integer)getValue();
            }
            curr=curr.next();
        }
        moveToPos(c);
        return mx;
    }

    public Integer findMinUptoCur(){
        Integer mn=(Integer) head.next().element();
        int c=currPos();
        moveToStart();
        for(int i=0;i<=c;i++){
            if((Integer)getValue()<mn){
                mn=(Integer)getValue();
            }
            curr=curr.next();
        }
        moveToPos(c);
        return mn;
    }
}
