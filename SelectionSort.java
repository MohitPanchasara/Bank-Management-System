package SelectionSort; 
import java.util.*; 
public class SelectionSort
{

public static void main(String args[])
{
Scanner sc=new Scanner(System.in); int i,j,k,flag=0,x,fla=0,y=0;
long sum1=0,sum2=0,sum3=0,average1,average2,average3; long [] call= new long[15];
long [] cal= new long[15]; long [] ca= new long[15];
 
System.out.println("Enter no. of elements in the array:");
 int n=sc.nextInt();
Random rd = new Random(); for( x=0;x<15;x++)
{
int[] arr = new int[1001]; for (i = 0; i < n; i++)
{
arr[i] = rd.nextInt(1000*(y+1) - 1000*y)+1000*y;
}
int [] a = new int[1001]; for (k = 0; k < n;k++)
{
a[k]=k+n*(fla);
}
int [] b = new int[1001]; for (j = n; j > 0;j--)
{
b[n-j]=j+n*flag;
}


long startTime = System.nanoTime(); int first=0;
 
int last = 0; int tem,ind=0;
for (first = 0; first < ( n-1 ); first++)
{
ind=first;
for (last = first+1; last < (n); last++)
{


if (arr[last]<arr[ind])
{
ind=last;
}
tem = arr[ind]; arr[ind] = arr[first]; arr[first] = tem;
}
}
long endTime=System.nanoTime()-startTime; call [x] = endTime*1000;
System.out.println("time for random array in micro:"+endTime*1000);
long begTime = System.nanoTime(); int firs=0;
 
int las = 0; int te,inde=0;
for (firs = 0; firs < ( n-1 ); firs++)
{
inde=firs;
for (las = firs+1; las < (n); las++)
{
if (a[las] < a[inde])
{
inde=las;
}


te = a[inde]; a[inde] = firs; a[firs] = te;

}
}
long finTime=System.nanoTime()-begTime; cal [x] = finTime*1000;
System.out.println("time for ascending array micro:"+finTime*1000);
long beginTime = System.nanoTime();
 
int fir=0; int la = 0;
int t,index=0;
for (fir = 0; fir < ( n-1 ); fir++)
{
index=fir;
for (la = fir+1; las < (n); la++)
{
if ( b[la]<b[index] )
{
index=la;
}


t = b[index];
b[index] = fir; b[fir] = t;

}
}
long finalTime=System.nanoTime()-beginTime; ca [x] = finalTime*1000;
flag++; fla++;
 
y++;
System.out.println("time for descending array micro:"+finalTime*1000);


System.out.println("");
}
for(x=0;x < 15;x ++)
{
sum1= sum1+call[x]; sum2=sum2+cal[x]; sum3=sum3+ca[x];
}
average1=sum1/15; average2=sum2/15; average3=sum3/15;
System.out.println("The average time for random array is " +average1);
System.out.println("The average time for ascending array is "+average2);
System.out.println("The average time for descending array is "+average3);
}
}
