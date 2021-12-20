public interface BinNode<T>{
    public T element();

    public BinNode<T> left();

    public BinNode<T> right();

    public boolean isLeaf();
}
