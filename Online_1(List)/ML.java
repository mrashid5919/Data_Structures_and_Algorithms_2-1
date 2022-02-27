import java.util.Scanner;

class Student{
    int x,y;
    Student(int a,int b){
        x=a;
        y=b;
    }
    public void setx(Integer x){
        this.x=x;
    }
    public void sety(Integer y){
        this.y=y;
    }
    public Integer getx(){
        return x;
    }
    public Integer gety(){
        return y;
    }
}

public class ML {
    public static void main(String[] args) {
        ListADT<Student> Stulist=new Arr1<>();
        //ListADT<Student> Stulist=new LL1<>();
        int x,y;
        Scanner sc=new Scanner(System.in);
        while(true){
            x = sc.nextInt();
            y = sc.nextInt();
            if(x==0 && y==0)
                break;
            Stulist.append(new Student(x,y));
        }
        printList(Stulist);
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
