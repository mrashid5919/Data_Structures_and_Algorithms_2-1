//Demo main method showcasing the use of Arr and LL classes
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int k,x;
        Scanner sc=new Scanner(System.in);
        k=sc.nextInt();
        x=sc.nextInt();
        Integer[] ara=new Integer[k];
        for(int i=0;i<k;i++)
            ara[i]=sc.nextInt();
        ListADT<Integer> aList = new Arr<>(ara,x); //Array initialization
        //ListADT<Integer> aList= new LL<>(ara); //Linked List initialization
        System.out.println();
        System.out.println(printList(aList));

        int q,p;
        while(true) {
            q = sc.nextInt();
            p = sc.nextInt();
            if (q == 0)
                break;
            else{
                if(q==1){
                    aList.clear();
                    System.out.println(printList(aList));
                    System.out.println(-1);
                }
                else if(q==2) {
                    aList.insert(p);
                    System.out.println(printList(aList));
                    System.out.println(-1);
                }
                else if(q==3){
                    aList.append(p);
                    System.out.println(printList(aList));
                    System.out.println(-1);
                }
                else if(q==4) {
                    int d=aList.remove();
                    System.out.println(printList(aList));
                    System.out.println(d);
                }
                else if(q==5){
                    aList.moveToStart();
                    System.out.println(printList(aList));
                    System.out.println(-1);
                }
                else if(q==6){
                    aList.moveToEnd();
                    System.out.println(printList(aList));
                    System.out.println(-1);
                }
                else if(q==7){
                    aList.prev();
                    System.out.println(printList(aList));
                    System.out.println(-1);
                }
                else if(q==8){
                    aList.next();
                    System.out.println(printList(aList));
                    System.out.println(-1);
                }
                else if(q==9) {
                    System.out.println(printList(aList));
                    System.out.println(aList.length());
                }
                else if(q==10) {
                    System.out.println(printList(aList));
                    System.out.println(aList.currPos());
                }
                else if(q==11){
                    aList.moveToPos(p);
                    System.out.println(printList(aList));
                    System.out.println(-1);
                }
                else if(q==12) {
                    System.out.println(printList(aList));
                    System.out.println(aList.getValue());
                }
                else if(q==13) {
                    System.out.println(printList(aList));
                    System.out.println(aList.Search(p));
                }
                else
                    System.out.println("Invalid value of q");
            }
        }
    }

    public static <T> String printList(ListADT<T> ara){
        StringBuilder s= new StringBuilder();
        s.append("<");
        if(ara.length()!=0)
        {
            int c=ara.currPos();

            for(int i=0;i< ara.length();i++){
                if(i==c)
                    s.append("| ");
                ara.moveToPos(i);
                s.append(ara.getValue());
                if(i!=ara.length()-1)
                    s.append(" ");
            }

            ara.moveToPos(c);
        }
        s.append(">");
        return s.toString();
    }
}
