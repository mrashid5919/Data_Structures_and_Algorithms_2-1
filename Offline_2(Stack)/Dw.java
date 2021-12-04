import java.util.Scanner;

import static java.lang.Math.max;

public class Dw {
    public static void main(String[] args) {
        int n, x;
        int k, t, s;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        int[] requiredTime = new int[x];
        for (int i = 0; i < x; i++) {
            requiredTime[i] = sc.nextInt();
        }

        Tasks[] ara=new Tasks[n*x];

        //Array based implementation
        StackADT<Tasks> dirtyStack = new Arr<>(n * x);
        StackADT<Tasks> cleanStack = new Arr<>(n * x);
        StackADT<Integer> fullMeal=new Arr<>(n);

        //Linked list based implementation
        /*StackADT<Tasks> dirtyStack=new LL<>();
        StackADT<Integer> cleanStack=new LL<>();
        StackADT<Integer> fullMeal=new LL<>();*/

        //2 stack 1 array implementation
        /*StackADT<Tasks> dirtyStack=new Arr<>(ara,1);
        StackADT<Tasks> cleanStack = new Arr<>(ara,-1);*/

        while (true) {
            k = sc.nextInt();
            t = sc.nextInt();
            s = sc.nextInt();
            if(s==x)
                fullMeal.push(k);
            if (k == 0){
                //If all inputs have been taken, then the leftover dishes at dirty stack will be cleaned
                while(dirtyStack.length()!=0){
                    Tasks ta=dirtyStack.pop();
                    Tasks tp=new Tasks(max(ta.t, cleanStack.topValue().t + 1) + requiredTime[ta.s - 1] - 1,ta.s);
                    cleanStack.push(tp);
                }
                break;
            }

            Tasks task=new Tasks(t,s);
            //If there is any leftover dish(es) at dirty stack and there is enough time to pop it before pushing another dish to the
            //dirty stack, then they are popped accordingly
            if(dirtyStack.length()!=0){
                while(dirtyStack.topValue().t<=task.t && dirtyStack.topValue().t<=cleanStack.topValue().t && task.t>cleanStack.topValue().t){
                    Tasks tp=new Tasks(max(dirtyStack.topValue().t, cleanStack.topValue().t + 1) + requiredTime[dirtyStack.topValue().s - 1] - 1,dirtyStack.pop().s);
                    cleanStack.push(tp);
                    if(dirtyStack.length()==0)
                        break;
                }
            }
            dirtyStack.push(task);
            if (t == 0) {
                dirtyStack.pop();
                cleanStack.push(new Tasks(requiredTime[task.s - 1] - 1,task.s));
            } else if (t >= cleanStack.topValue().t) {
                dirtyStack.pop();
                Tasks tp=new Tasks(max(t, cleanStack.topValue().t + 1) + requiredTime[task.s - 1] - 1, task.s);
                cleanStack.push(tp);
            }

        }
        System.out.println(cleanStack.topValue().t);
        System.out.println(printStack(cleanStack));
        if(fullMeal.length()==x)
            System.out.println("Y");
        else
            System.out.println("N");
        System.out.println(reversePrint(fullMeal));
    }

    public static String printStack(StackADT <Tasks> ara) {
        StringBuilder s = new StringBuilder();
        StackADT<Tasks> temp = new Arr<>();
        while (ara.length() != 0) {
            temp.push(ara.pop());
        }
        while (temp.length() != 1) {
            s.append(temp.topValue().t).append(",");
            ara.push(temp.pop());
        }
        s.append(temp.pop().t);

        return s.toString();
    }

    public static <T> String reversePrint(StackADT<T> ara){
        StringBuilder s=new StringBuilder();
        while(ara.length()!=1){
            s.append(ara.pop()).append(",");
        }
        s.append(ara.pop());

        return s.toString();
    }
}

class Tasks{
    int t,s;
    Tasks(int t,int s){
        this.t=t;
        this.s=s;
    }
}