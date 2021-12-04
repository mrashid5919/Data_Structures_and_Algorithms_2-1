public interface StackADT<T>{
    //Reinitialize the stack. The user is responsible for reclaiming the storage used by the stack elements
    public void clear();

    //Push an element onto the top of the stack
    public void push(T it);

    //Remove and return the element at the top of the stack
    public T pop();

    //Return a copy of the top element
    public T topValue();

    //Return the number of elements in the stack
    public int length();

    public void setDirection(int direction);
}
