import java.util.Scanner;


public class Faculty extends Person{
	private int employeeId;
	Person person=new Person();
	Faculty(){}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	Faculty(String name,String address,int rollNumber)
	{
		
		person.setName(name);
		person.setAddress(address);
		this.employeeId=rollNumber;
	}
	public void faculty()
	{
		System.out.println("CHOOSE : 1.Enter New Faculty 2.Update Faculty 3.Delete Faculty 4.Search Faculty 5.View All Faculty 6.Exit");
		Scanner scan=new Scanner(System.in);
		char c2=scan.next().charAt(0);
		FacultyManipulation facultyManipulation=new FacultyManipulation();
		
		if(c2=='1')
		{
			facultyManipulation.newFaculty();
		}
		else if(c2=='2')
		{
			facultyManipulation.updateFaculty();
		}
		else if(c2=='3')
		{
			facultyManipulation.deleteFaculty();
		}
		else if(c2=='4')
		{
			facultyManipulation.searchFaculty();
		}
		else if(c2=='5')
		{
			facultyManipulation.viewAllFaculty();
		}
		else if(c2=='6')
		{
			System.out.println(" Bye Thanks for visiting...!");
			System.exit(0);
		}
		else 
		{
			System.out.println("choose correct..!");
			faculty();
		}
		scan.close();

	}
	
}
	

