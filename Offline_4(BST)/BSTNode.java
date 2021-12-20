public class BSTNode<T> implements BinNode<T>{
    private T element;
    private BSTNode<T> left;
    private BSTNode<T> right;

    public BSTNode() {left=right=null;}
    public BSTNode(T val){
        left=right=null;
        element=val;
    }

    public BSTNode(T val,BSTNode<T> l,BSTNode<T> r){
        left=l;
        right=r;
        element=val;
    }

    @Override
    public T element() {return element;}
    public void setElement(T val){element=val;}

    public BSTNode<T> left() {
        return left;
    }
    public void setLeft(BSTNode<T> p) {left=p;}

    public BSTNode<T> right() {
        return right;
    }
    public void setRight(BSTNode<T> p) {right=p;}

    @Override
    public boolean isLeaf() {
        return (left==null) && (right==null);
    }
}
