import java.io.*;
import java.util.Scanner;
 
class ring{
    static int n;
    static int pro[] = new int[100];
    static int sta[] = new int[100];
    static int prio[] = new int[100];
    static int co;
     
    public static void main(String args[])throws IOException
    {
        System.out.println("Enter the number of process");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
         
        int i,j,k,l,m;
         
        for(i=0;i<n;i++)
        {
            System.out.println("For process "+(i+1)+":");
            System.out.println("Status:");
            sta[i]=in.nextInt();
            System.out.println("Priority");
            pro[i] = in.nextInt();
        }
        
        System.out.println("The ring formed is: ");
        for (i=1;i<=n;i++) {
        	System.out.print(i + " ->");
        }
        System.out.println("1");
         
        System.out.println("Which process will initiate election?");
        int ele = in.nextInt();
         
        elect(ele);

        System.out.println("Final coordinator is "+co);
    }
     
    static void elect(int ele)
    {
        
        int i;
        int index = 0;
        int max = 0;
        for(i=(ele-1);i<=n;i++) {
        	if(sta[i]==1) {
        		prio[index] = pro[i];
        		index = index + 1;
        	}
        }
        for(i=0;i<=ele;i++) {
        	if(sta[i] == 1) {
        		prio[index] = pro[i];
        		index = index + 1;
        	}
        }
        
        for(i=0;i<=index;i++) {
        	if(prio[i]>max) {
        		max = prio[i];
        	}
        }
        co = max;
    }
}