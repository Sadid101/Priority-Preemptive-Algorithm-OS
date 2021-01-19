package priority.preemptive;
import java.util.Scanner;
public class PriorityPreemptive {
    //this is round robin
   public static void main(String[] args) {
       Scanner scan=new Scanner(System.in);
       System.out.println("Enter number of processes");
       int pro=scan.nextInt();
       int[] bT=new int[pro];
       for(int i=0; i<pro; i++){
            System.out.println("Enter Burst time of process "+i);
            bT[i]=scan.nextInt();
        }
        System.out.println("Enter Time quantum");
        int quan=scan.nextInt();
        int[] wait=new int[pro];
        int[] flag=new int[pro];
        for(int i=0; i<flag.length; i++){
            flag[i]=0;
        }
        int work=0;
        int bTsum=0;
        for(int i=0; i<pro; i++){
            bTsum+=bT[i];
        }
        int x=0;
        flag[x]=1;
        for(int time=0; time<bTsum; time++){
           for(int tq=0; tq<quan; tq++){
               for(int i=0; i<pro; i++){
                if(flag[i]==0){
                    wait[i]++;
                }
                else if(flag[i]==1){
                    bT[i]--;
                    if(bT[i]==0){
                        tq=quan;
                        flag[i]=2; //done
                    }
                }
            }
            time++;
           }
           x++;
           if(x==pro || flag[x]==2){
               x=0;
           }
           for(int i=0; i<pro; i++){
               if(flag[i]==1){
                   flag[i]=0;
               }
           }
           flag[x]=1;
           
        }
        for(int j=0; j<pro; j++){
           System.out.println("Process "+j+" has a waiting time of "+wait[j]);
        }
        double avgwait=0;
           for(int k=0; k<wait.length; k++){
            avgwait+=wait[k];
           }
           avgwait=avgwait/pro;
           System.out.println("Average waiting time is "+avgwait);
       
   }
}
            
            