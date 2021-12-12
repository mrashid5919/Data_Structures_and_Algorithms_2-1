import java.util.Scanner;

class Customer{
    int enterTime; //The person enters the bank
    int serviceTime; //The amount of time taken to serve the person
    int endTime; //The person's task gets completed

    Customer(int a,int b){
        this.enterTime=a;
        this.serviceTime=b;
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,p,q;
        n= sc.nextInt();
        Customer[] ara=new Customer[n];
        for(int i=0;i<n;i++){
            p= sc.nextInt();
            q= sc.nextInt();
            ara[i]=new Customer(p,q);
        }
        int time=0;
        int count=0;

        //Array implementation
        Aqueue<Customer> queue1=new Aqueue<>(n);
        Aqueue<Customer> queue2=new Aqueue<>(n);

        //LL implementation
        //Lqueue<Customer> queue1=new Lqueue<>();
        //Lqueue<Customer> queue2=new Lqueue<>();

        int q1Time=0;
        int q2Time=0;

        while(true){
            //Dequeueing
            if(queue1.length()!=0){
                if(queue1.frontValue().endTime==time){
                    queue1.dequeue();
                    q1Time=time;
                    if(queue1.length()!=0)
                        queue1.frontValue().endTime=time+queue1.frontValue().serviceTime;
                }
            }
            if(queue2.length()!=0){
                if(queue2.frontValue().endTime==time){
                    queue2.dequeue();
                    q2Time=time;
                    if(queue2.length()!=0)
                        queue2.frontValue().endTime=time+queue2.frontValue().serviceTime;
                }
            }

            //New Comer
            while(count!=n && ara[count].enterTime==time){
                if(queue1.length()<=queue2.length()){
                    queue1.enqueue(ara[count]);
                    if(queue1.length()==1){
                        queue1.frontValue().endTime=time+queue1.frontValue().serviceTime;
                    }
                }
                else{
                    queue2.enqueue(ara[count]);
                    if(queue2.length()==1){
                        queue2.frontValue().endTime=time+queue2.frontValue().serviceTime;
                    }
                }
                count++;
            }

            //Switching
            if(queue1.length()<=queue2.length()-2){
                queue1.enqueue(queue2.leaveQueue());
                if(queue1.length()==1){
                    queue1.frontValue().endTime=time+queue1.frontValue().serviceTime;
                }
            }
            if(queue2.length()<= queue1.length()-2){
                queue2.enqueue(queue1.leaveQueue());
                if(queue2.length()==1){
                    queue2.frontValue().endTime=time+queue2.frontValue().serviceTime;
                }
            }
            if(count==n && queue1.length()==0 && queue2.length()==0){
                break;
            }
            time++;
        }
        System.out.println("Booth 1 finishes service at t="+q1Time);
        System.out.println("Booth 2 finishes service at t="+q2Time);
    }
}
