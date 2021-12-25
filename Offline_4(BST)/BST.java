public class BST <T extends Comparable<T>>{
    private BSTNode<T> root;
    private int nodecount;

    BST() {
        root=null;
        nodecount=0;
    }

    public BSTNode<T> getRoot() {return root;}

    public void clear(){
        root=null;
        nodecount=0;
    }

    private T findhelp(BSTNode<T> rt,T e){
        if(rt==null)
            return null;
        if(rt.element().compareTo(e)>0)
            return findhelp(rt.left(),e);
        else if (rt.element().compareTo(e) == 0)
            return rt.element();
        else
            return findhelp(rt.right(),e);
    }

    private BSTNode<T> inserthelp(BSTNode<T> rt, T e){
        if(rt==null)
            return new BSTNode<>(e);
        if(rt.element().compareTo(e)>0)
            rt.setLeft(inserthelp(rt.left(),e));
        else
            rt.setRight(inserthelp(rt.right(),e));
        return rt;
    }

    private BSTNode<T> deletemin(BSTNode<T> rt){
        if(rt.left()==null)
            return rt.right();
        rt.setLeft(deletemin(rt.left()));
        return rt;
    }

    private BSTNode<T> deletemax(BSTNode<T> rt){
        if(rt.right()==null)
            return rt.left();
        rt.setRight(deletemax(rt.right()));
        return rt;
    }

    private BSTNode<T> getmin(BSTNode<T> rt){
        if(rt.left()==null)
            return rt;
        return getmin(rt.left());
    }

    private BSTNode<T> getmax(BSTNode<T> rt){
        if(rt.right()==null)
            return rt;
        return getmax(rt.right());
    }

    private BSTNode<T> removehelp(BSTNode<T> rt,T k){
        if(rt==null)
            return null;
        if(rt.element().compareTo(k)>0)
            rt.setLeft(removehelp(rt.left(),k));
        else if (rt.element().compareTo(k)<0)
            rt.setRight(removehelp(rt.right(), k));
        else{
            if(rt.left()==null)
                return rt.right();
            else if(rt.right()==null)
                return rt.left();
            else{
                //BSTNode<T> temp=getmin(rt.right());
                BSTNode<T> temp=getmax(rt.left());
                rt.setElement(temp.element());
                //rt.setRight(deletemin(rt.right()));
                rt.setLeft(deletemax(rt.left()));
            }
        }
        return rt;
    }

    public void insert(T e){
        root=inserthelp(root,e);
        nodecount++;
        print(root);
        System.out.println();
    }

    public T remove(T k){
        T temp=findhelp(root,k);
        if(temp!=null){
            root=removehelp(root,k);
            nodecount--;
            print(root);
            System.out.println();
        }
        else{
            System.out.println("Invalid operation");
        }
        return temp;
    }


    public void find(T k){
        T temp= findhelp(root,k);
        if(temp==null)
            System.out.println("False");
        else
            System.out.println("True");
    }

    public int size(){
        return nodecount;
    }

    public void preorder(BSTNode<T> rt){
        if(rt!=null){
            System.out.print(rt.element()+" ");
            preorder(rt.left());
            preorder(rt.right());
        }
    }

    public void postorder(BSTNode<T> rt){
        if(rt!=null){
            postorder(rt.left());
            postorder(rt.right());
            System.out.print(rt.element()+" ");
        }
    }

    public void inorder(BSTNode<T> rt){
        if(rt!=null){
            inorder(rt.left());
            System.out.print(rt.element()+" ");
            inorder(rt.right());
        }
    }

    private void print(BSTNode<T> rt){
        if(rt!=null) {
            System.out.print(rt.element());
            if (rt.left() != null || rt.right() != null)
                System.out.print("(");
            if (rt.left() != null)
                print(rt.left());
            if (rt.left() != null || rt.right() != null)
                System.out.print(")(");
            if (rt.right() != null)
                print(rt.right());
            if (rt.left() != null || rt.right() != null)
                System.out.print(")");
        }
    }
}
