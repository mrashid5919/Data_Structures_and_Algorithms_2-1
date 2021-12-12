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
        QueueADT<Integer> queue1=new Aqueue<>(k); //Use of 1st constructor
        //QueueADT<Integer> queue1=new Aqueue<>(arr); //Use of second constructor
        //QueueADT<Integer> queue1=new Lqueue<>(); //Use of linked list based implementation
        for(int i=0;i<k;i++){
            queue1.enqueue(ara[i]);
        }

        System.out.println();
        System.out.println(printQueue(queue1));

        int q,p;
        while(true){
            q=sc.nextInt();
            p=sc.nextInt();
            if(q==0)
                break;
            else if(q==1){
                queue1.clear();
                System.out.println(printQueue(queue1));
                System.out.println(-1);
            }
            else if(q==2){
                queue1.enqueue(p);
                System.out.println(printQueue(queue1));
                System.out.println(-1);
            }
            else if(q==3){
                Integer d=queue1.dequeue();
                System.out.println(printQueue(queue1));
                System.out.println(d);
            }
            else if(q==4){
                System.out.println(printQueue(queue1));
                System.out.println(queue1.length());
            }
            else if(q==5){
                System.out.println(printQueue(queue1));
                System.out.println(queue1.frontValue());
            }
            else if(q==6){
                System.out.println(printQueue(queue1));
                System.out.println(queue1.rearValue());
            }
            else if(q==7){
                Integer d=queue1.leaveQueue();
                System.out.println(printQueue(queue1));
                System.out.println(d);
            }
        }
    }

    public static <T> String printQueue(QueueADT<T> ara){
        StringBuilder s= new StringBuilder();
        s.append("<");
        QueueADT<T> temp=new Lqueue<>();
        while(ara.length()!=0) {
            s.append(ara.frontValue()).append(" ");
            temp.enqueue(ara.dequeue());
        }
        ara.clear();
        while(temp.length()!=0){
            ara.enqueue(temp.dequeue());
        }
        s.append(">");

        return s.toString();
    }

}
