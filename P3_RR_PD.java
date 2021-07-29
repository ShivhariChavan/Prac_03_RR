import java.util.Scanner;

class P3_RR_PD
{
public static void main(String args[]){ Scanner input=new Scanner(System.in); int i,j,k,q,sum=0;
System.out.print("Enter number of process:"); int n=input.nextInt(); int burstTime[]=new int[n]; int waitingTime[]=new int[n]; int turnAroundTime[]=new int[n]; int a[]=new int[n];
System.out.println("Enter the burst time of each process: "); for(i=0;i<n;i++){
System.out.print("enter the burst time for process-p"+(i+1)+":"); burstTime[i]=input.nextInt();

a[i]=burstTime[i];

}
System.out.print("Enter time quantum: ");
q=input.nextInt(); for(i=0;i<n;i++) waitingTime[i]=0; int timer=0; do{ for(i=0;i<n;i++){ if(burstTime[i]>q){ timer +=q; burstTime[i] -=q; for(j=0;j<n;j++){ if ((j!=i) && (burstTime[j]!=0)) waitingTime[j]+=q;
} } else{ timer +=burstTime[i]; for(j=0;j<n;j++){ if((j!=i) && (burstTime[j]!=0)) waitingTime[j] +=burstTime[i];
} burstTime[i]=0;
}
}
sum=0; for(k=0;k < n;k++) sum +=burstTime[k];
}while(sum!=0);

for(i=0;i<n;i++)  turnAroundTime[i]=waitingTime[i]+a[i]; float total=0; for(int m: waitingTime) { total += m;
}
float averageWaitingTime=total/n; total=0;
for(int m:turnAroundTime){ total +=m;
}

float averageTurnAroundTime=total/n;
System.out.println(" RR Algorithm:");
System.out.format("%20s%20s%20s%20s\n","ProcessId","BurstTime"
,"WaitingTime","TurnAroundTime"); for( i=0;i<n;i++){
System.out.format("%20s%20d%20d%20d\n", "p"+(i+1), a[i],waitingTime[i],turnAroundTime[i]);
}
System.out.format("%40s%20f%20f\n", "Average",averageWaitingTime,averageTurnAroundTime);

}
}
