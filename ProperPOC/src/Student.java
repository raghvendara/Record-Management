import java.util.Scanner;


public class Student extends Person{
	private int rollNumber;
	Person person=new Person();
	
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	Student(){}
	Student(String name,String address,int rollNumber)
	{
		
		person.setName(name);
		person.setAddress(address);
		this.rollNumber=rollNumber;
	}
	public void student()
	{
		PersonManipulation personManipulation=new PersonManipulation();
		
		System.out.println("CHOOSE : 1.Enter New Student 2.Update Student 3.Delete Student 4.Search Student 5.View All Students 6.Exit");
		Scanner scan=new Scanner(System.in);
		char c2=scan.next().charAt(0);
		
		if(c2=='1')
		{
			personManipulation.newStudent();
		}
		else if(c2=='2')
		{
			personManipulation.updateStudent();
		}
		else if(c2=='3')
		{
			personManipulation.deleteStudent();
		}
		else if(c2=='4')
		{
			personManipulation.searchStudent();
		}
		else if(c2=='5')
		{
			personManipulation.viewAllStudents();
		}
		else if(c2=='6')
		{
			System.out.println(" Bye Thanks for visiting...!");
			System.exit(0);
		}
		else 
		{
			System.out.println("choose correct..!");
			student();
		}
		scan.close();
	}

}
