public class PerfectNumber {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int n=1;n<=1000;n++){
			if (isPerfectNumber(n)) {
				System.out.print(n+" ");
			}
		}		
	}
	//�ж��Ƿ������ĺ���
	static boolean isPerfectNumber(int n)
	{
		boolean isperfectnumner=false;
		int sum=0;
		for(int i=1;i<n;i++)//�ҵ���������������Ӳ����
		{
			if(n%i==0)
			{
				sum+=i;
			}
		
		}
		if(sum==n)//������
		{

			isperfectnumner=true;//������
		}
		return isperfectnumner;
	}
}