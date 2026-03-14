package Webdriver;

public class largestOfNumber {

	public static void main(String[] args) {
		
		int a=2,b=3,c=4;
		
		if(a>c)
		{
			if(a>b)
			{
				System.out.println(a + "is the largest number");
			}
			else if(b>c)
				System.out.println(b+ "is the largest number");
			
		}
		else
		System.out.println(c+ "is the largest number");

	}

}
