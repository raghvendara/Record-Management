import java.util.Scanner;


public class HUB {

	public static void main(String[] args) {
		System.out.println("*** Welcome ***");
		System.out.println("press \n1.Manage Student \n2.Manage Faculty \n3.Exit");
		Scanner scan=new Scanner(System.in);
		char c=scan.next().charAt(0);
		Student student =new Student();
		Faculty faculty=new Faculty();
		if (c=='1')
		{
			System.out.println("*** Welcome Student ***");
			student.student();	
		}
		else if (c=='2')
		{
			System.out.println("*** Welcome Faculty ***");
			faculty.faculty();
		}
		else if (c=='3')
		{
			System.out.println(" Bye Thanks for visiting...!");
			System.exit(0);
			
		}
		else 
		{
			System.out.println("choose correct..!");
			main(args);
		}
		scan.close();

	}
	
	
	
	
}
