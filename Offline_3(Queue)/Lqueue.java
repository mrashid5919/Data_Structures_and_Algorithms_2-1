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

public class Lqueue <T> implements QueueADT<T>{
    private Link<T> front;
    private Link<T> rear;
    private int size;

    public Lqueue(int... size){
        front=rear= new Link<>(null);
        this.size=0;
    }

    @Override
    public void clear() {
        front=rear= new Link<>(null);
        this.size=0;
    }

    @Override
    public void enqueue(T it) {
        rear.setNext(new Link<>(it,null));
        rear=rear.next();
        size++;
    }

    @Override
    public T dequeue() {
        if(size==0){
            System.out.println("Queue is empty");
            return null;
        }
        T it=front.next().element();
        front.setNext(front.next().next());
        if(front.next()==null){
            rear=front;
        }
        size--;
        return it;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public T frontValue() {
        if(size==0){
            System.out.println("Queue is empty");
            return null;
        }
        return front.next().element();
    }

    @Override
    public T rearValue() {
        if(size==0){
            System.out.println("Queue is empty");
            return null;
        }
        return rear.element();
    }

    @Override
    public T leaveQueue() {
        if(size==0){
            System.out.println("Queue is empty");
            return null;
        }
        T it=rear.element();
        Link<T> temp=front;
        while(true){
            if(temp.next()==rear){
                rear=temp;
                rear.setNext(null);
                break;
            }
            temp=temp.next();
        }
        size--;
        return it;
    }
}
