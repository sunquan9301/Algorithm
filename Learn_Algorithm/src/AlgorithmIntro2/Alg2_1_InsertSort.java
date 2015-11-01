/**
 * this class include two version insertSort.One is increase the other is decrease
 * @author Sun
 */
package AlgorithmIntro2;

public class Alg2_1_InsertSort {
	public static void main(String[] args)
	{
		Alg2_1_InsertSort ai=new Alg2_1_InsertSort();
		int[] a=new int[]{2,6,23,7,11,5,56,3,14,35};
		ai.decreaseInsertSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
	}
	public void increaseInsertSort(int[] data)
	{
		for (int i = 1; i < data.length; i++) {
			int key=data[i];
			while(i>0&&key<data[i-1])
			{
				data[i]=data[i-1];
				i--;
			}
			data[i]=key;
		}
	}
	public void decreaseInsertSort(int[] data)
	{
		for (int i = 1; i < data.length; i++) {
			int key=data[i];
			while(i>0&&key>data[i-1])
			{
				data[i]=data[i-1];
				i--;
			}
			data[i]=key;
		}
	}
}
