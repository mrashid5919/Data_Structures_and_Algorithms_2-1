import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int k;
        Scanner sc=new Scanner(System.in);
        k=sc.nextInt();
        Integer[] ara=new Integer[k];
        Integer[] arr=new Integer[k]; //Dynamcilly allocated array
        for(int i=0;i<k;i++){
            ara[i]=sc.nextInt();
        }
        StackADT<Integer> stack1=new Arr<>(k); //Use of 1st constructor
        //StackADT<Integer> stack1=new Arr<>(arr,-1); //Use of second constructor
        //StackADT<Integer> stack1=new LL<>(); //Use of linked list based implementation
        for(int i=0;i<k;i++){
            stack1.push(ara[i]);
        }

        System.out.println();
        System.out.println(printStack(stack1));

        int q,p;
        while(true){
            q=sc.nextInt();
            p=sc.nextInt();
            if(q==0)
                break;
            else if(q==1){
                stack1.clear();
                System.out.println(printStack(stack1));
                System.out.println(-1);
            }
            else if(q==2){
                stack1.push(p);
                System.out.println(printStack(stack1));
                System.out.println(-1);
            }
            else if(q==3){
                Integer d=stack1.pop();
                System.out.println(printStack(stack1));
                System.out.println(d);
            }
            else if(q==4){
                System.out.println(printStack(stack1));
                System.out.println(stack1.length());
            }
            else if(q==5){
                System.out.println(printStack(stack1));
                System.out.println(stack1.topValue());
            }
            else if(q==6){
                System.out.println(printStack(stack1));
                if(p==1 || p==-1){
                    stack1.setDirection(p);
                    System.out.println(-1);
                }
                else
                    System.out.println("Wrong input");
            }
        }
    }

    public static <T> String printStack(StackADT<T> ara){
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
