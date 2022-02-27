import java.util.Scanner;

public class MainOnline {
    public static void main(String[] args) {
        int k;
        Scanner sc=new Scanner(System.in);
        k=sc.nextInt();
        Integer[] ara=new Integer[k];
        Integer[] arr=new Integer[k];
        Integer[] arra=new Integer[2*k];
        for(int i=0;i<k;i++){
            ara[i]=sc.nextInt();
        }
        for(int i=0;i<k;i++){
            arr[i]=sc.nextInt();
        }
        OATS<Integer> marr=new OATS<>(arra);
        for(int i=0;i<k;i++){
            marr.pushA(ara[i]);
        }
        for(int i=0;i<k;i++){
            marr.pushB(arr[i]);
        }
        System.out.println();
        System.out.println(printStack(marr));

        int q,p;
        while(true){
            q=sc.nextInt();
            p=sc.nextInt();
            if(q==0)
                break;
            else if(q==7){
                marr.pushA(q);
                System.out.println(printStack(marr));
                System.out.println(-1);
            }
            else if(q==10){
                marr.pushB(q);
                System.out.println(printStack(marr));
                System.out.println(-1);
            }
            else if(q==8){
                Integer d=marr.popA();
                System.out.println(printStack(marr));
                System.out.println(d);
            }
            else if(q==11){
                Integer d=marr.popB();
                System.out.println(printStack(marr));
                System.out.println(d);
            }
            else if(q==9){
                System.out.println(printStack(marr));
                System.out.println(marr.topValueA());
            }
            else if(q==12){
                System.out.println(printStack(marr));
                System.out.println(marr.topValueB());
            }
        }


    }

    public static <T> String printStack(OATS<T> ara){
        StringBuilder s= new StringBuilder();
        s.append("<");
        StackADT<T> temp=new Arr<>();
        while(ara.length()!=0) {
            temp.push(ara.pop());
        }
        while(temp.length()!=0){
            s.append(temp.topValue()).append(" ");
            ara.push(temp.pop());
        }
        s.append(">");

        return s.toString();
    }
}


