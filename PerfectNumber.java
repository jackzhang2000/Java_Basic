public class PerfectNumber {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int n=1;n<=1000;n++){
			if (isPerfectNumber(n)) {
				System.out.print(n+" ");
			}
		}		
	}
	//判断是否完数的函数
	static boolean isPerfectNumber(int n)
	{
		boolean isperfectnumner=false;
		int sum=0;
		for(int i=1;i<n;i++)//找到这个数的所有因子并求和
		{
			if(n%i==0)
			{
				sum+=i;
			}
		
		}
		if(sum==n)//如果相等
		{

			isperfectnumner=true;//是完数
		}
		return isperfectnumner;
	}
}