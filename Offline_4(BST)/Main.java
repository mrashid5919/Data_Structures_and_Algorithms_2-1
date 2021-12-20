import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Operations> opList=FileOperations.readFromFile();
        BST<Integer> tree=new BST<>();
        for(Operations o: opList){
            if(o.getOp().equals("F")){
                tree.find(Integer.parseInt(o.getType()));
            }
            else if(o.getOp().equals("I")){
                tree.insert(Integer.parseInt(o.getType()));
            }
            else if(o.getOp().equals("D")){
                tree.remove(Integer.parseInt(o.getType()));
            }
            else if(o.getOp().equals("T")){
                if(o.getType().equalsIgnoreCase("Pre")){
                    tree.preorder(tree.getRoot());
                }
                else if(o.getType().equalsIgnoreCase("Post")){
                    tree.postorder(tree.getRoot());
                }
                else
                    tree.inorder(tree.getRoot());
                System.out.println();
            }
        }
    }
}
