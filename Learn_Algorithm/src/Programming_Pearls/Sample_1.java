/**
 * n�����в��ظ���ȡm�������������
 * �����ɱ��һЩ����
 * ���ʿ�����һ���ܴ��������N�����ж��Ƿ�С��M����ʾM/N;
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
			int select=M;          //ѡ�����
			int remaining=N; //�ܵ���
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
