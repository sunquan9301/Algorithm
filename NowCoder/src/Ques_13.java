
public class Ques_13 {
	public static void main(String[] args)
	{
		int[] a=new int[]{1,2,4,3,5,8,0,2,3,1};
		reOrderArray(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
	 public static  void reOrderArray(int [] array) {
	        int left=0;
	        int right=array.length-1;
	        boolean check=false;
	        while(true)
	        {
	            check=true;
	            for(int i=left;i<array.length-1;i++)
	            {
	                if(array[i]%2==0)
	                {
	                    if(array[i+1]%2!=0)
	                    {
	                        int temp=array[i];
	                        array[i]=array[i+1];
	                        array[i+1]=temp;
	                        check=false;
	                    }
	                }
	            }
	            if(check)
	                break;
	        }
	    	
	    }
}
