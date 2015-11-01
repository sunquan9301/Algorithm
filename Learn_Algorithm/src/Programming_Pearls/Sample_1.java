/**
 * n个数中不重复抽取m个数，有许输出
 * 可生成别的一些整数
 * 概率可以用一个很大的数除以N求摸判断是否小于M来表示M/N;
 */
package Programming_Pearls;

public class Sample_1 {
	private static int M=10;
	private static int N=400;
		public static void main(String[] args)
		{
			Sample_1  s=new Sample_1();
			s.sample();
			
		}
		public int bigrand()
		{
			return (int)(Math.random()*1000000);
		}
		public void sample()
		{
			int select=M;          //选择的数
			int remaining=N; //总的数
			for (int i = 0; i < N; i++) {
				if(this.bigrand()%remaining<select)
				{
					System.out.println(i);
					select--;
				}
				remaining--;
			}
		}
}
