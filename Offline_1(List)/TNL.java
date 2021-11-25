import java.util.Scanner;

public class TNL {
    public static void main(String[] args) {
        int k,l,m,task;
        Scanner sc=new Scanner(System.in);
        k=sc.nextInt();
        l=sc.nextInt();
        ListADT<Integer> BusStops= new Arr<>(l);
        //ListADT<Integer> BusStops = new LL<>();
        for(int i=0;i<l;i++){
            int y=sc.nextInt();
            BusStops.append(y);
        }
        m=sc.nextInt();
        ListADT<Integer> TrainStops = new Arr<>(m);
        //ListADT<Integer> TrainStops = new LL<>();
        for(int i=0;i<m;i++){
            int x=sc.nextInt();
            TrainStops.append(x);
        }
        task=sc.nextInt();
        while(task-->0){
            for(int i=0;i<k;i++) {
                if (i != 0)
                    System.out.print(",");
                System.out.print(i);
            }
            System.out.println();
            for(int i=0;i<k;i++){
                if(i!=0)
                    System.out.print(",");
                if(i==0 && BusStops.Search(i)==-1){
                    System.out.print(",");
                }
                if(BusStops.Search(i)!=-1){
                    System.out.print(i);
                }
            }
            System.out.println();
            for(int i=0;i<k;i++){
                if(i!=0)
                    System.out.print(",");
                if(i==0 && TrainStops.Search(i)==-1){
                    System.out.print(",");
                }
                if(TrainStops.Search(i)!=-1){
                    System.out.print(i);
                }
            }
        }
    }
}
