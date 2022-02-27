class Link <T>{
    private T elem; //Value for this node
    private Link<T> next; //Pointer to next node in list

    Link(T it, Link<T> nextval){
        elem=it;
        next=nextval;
    }

    Link(Link<T> nextval){
        next=nextval;
    }

    Link<T> next() {return next;} //return next
    Link<T> setNext(Link<T> nextval) {return next=nextval;} //set next
    T element() {return elem;} //return element
    T setElement(T it) {return elem=it;} //set element
}

public class LL <T> implements StackADT<T>{
    private Link<T> top;
    private int size;

    public LL(int... size){
        top=null;
        this.size=0;
    }

    @Override
    public void clear() {
        top=null;
        size=0;
    }

    @Override
    public void push(T it) {
        top=new Link<T>(it,top);
        size++;
    }

    @Override
    public T pop() {
        assert top!=null : "Stack is empty";
        if(top==null)
            return null;
        T it=top.element();
        top=top.next();
        size--;
        return it;
    }

    @Override
    public T topValue() {
        assert top!=null : "Stack is empty";
        if(top==null)
            return null;
        return top.element();
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void setDirection(int direction) {

    }
}
