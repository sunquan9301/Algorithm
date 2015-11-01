/**
 * input: two arrays which length is n;
 * operation: plus
 * output:a arrays which length is n+1;
 */
package AlgorithmIntro2;

public class Alg2_1_BitDigitPlus {
	public static int N=10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alg2_1_BitDigitPlus ab=new Alg2_1_BitDigitPlus();
		ab.process();
		
	}
	public void process()
	{
		int[] data1=new int[N];
		for (int i = 0; i < data1.length; i++) {
			data1[i]=(int)(Math.random()+0.5);
		}
		int[] data2=new int[N];
		for (int i = 0; i < data2.length; i++) {
			data2[i]=(int)(Math.random()+0.5);
		}
		
		int[] result=this.plus(data1,data2);

		print(data1);	
		print(data2);
		print(result);
		
	}
	public int[] plus(int[] data1,int[] data2)
	{
		int result[]=new int[N+1];
		int C=0;
		for (int i = 0; i < result.length-1; i++) {
			result[i]=data1[i]+data2[i]+C;
			if(result[i]>=2)
			{	
				result[i]=result[i]%2;
				C=1;
			}else
			{
				C=0;
			}
		}
		result[result.length-1]=C;
		return result;
	}
	public void print(int[] data)
	{
		for (int i = data.length-1; i >=0; i--) {
			System.out.print(data[i]);
		}
		System.out.println("\n");
	}
}
