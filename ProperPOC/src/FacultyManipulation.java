import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class FacultyManipulation {

	File log = new File("faculty.txt");
	ReadWriteFaculty readWriteFaculty=new ReadWriteFaculty();
	Scanner read=new Scanner(System.in);
	Faculty faculty=new Faculty();
	private Person person;
	
	public void newFaculty()
	{	
		System.out.println("Enter Faculty Name :");
		String studentName=read.nextLine();
		System.out.println("Enter Faculty Address :");
		String address=read.nextLine();
		System.out.println("Enter Faculty Id :");
		int empId=read.nextInt();
		Faculty object =new Faculty(studentName,address,empId);
		
		readWriteFaculty.writeFile(object);
	}
	public void updateFaculty()
	{
		//Scanner read = null;
		System.out.println("Enter Faculty Id :");
		int empId=this.read.nextInt();
		List<Faculty> list=readWriteFaculty.ReadFromFile();
		
			Iterator<Faculty> itr = list.listIterator();
			int count=0,index=0;
			while (itr.hasNext()) 
			{
				Faculty obj = itr.next();
				int getEmpId = obj.getEmployeeId();
				if(getEmpId==empId)
				{
					count++;
					index=list.indexOf(obj);
					itr.remove();
					
				}
			}
			if(count==1)
			{
				System.out.println("faculty got...at index :"+index);
				Scanner read1 = new Scanner(System.in);
				System.out.println("Now enter the new details..");
				System.out.println("Enter new name :");
				String newName = read1.nextLine();
				System.out.println("Enter new address :");
				String newAddress = read1.nextLine();
				Faculty newObject=new Faculty(newName,newAddress,empId);
				list.add(index,newObject);
				readWriteFaculty.writeIntoFileInOverwriteMode((ArrayList<Faculty>) list);
				System.out.println("you succesfully updated the student");
				faculty.faculty();
			}
			else 
				System.out.println("Student not found with rollnumber :"+empId);
	}
	public void deleteFaculty()
	{
		System.out.println("Enter Faculty EmpId to delete :");
		int empId=read.nextInt();
		ArrayList<Faculty> list=readWriteFaculty.ReadFromFile();
		
		Iterator<Faculty> itr = list.listIterator();
		int count=0,index=0;
		while (itr.hasNext()) 
		{
			Faculty obj = itr.next();
			int getEmpId = obj.getEmployeeId();
			if(getEmpId==empId)
			{
				count++;
				index=list.indexOf(obj);
				itr.remove();
				
			}
		}
		if(count==1)
		{
			System.out.println("Faculty got...at index :"+index);
			readWriteFaculty.writeIntoFileInOverwriteMode((ArrayList<Faculty>) list);
			System.out.println("you succesfully deleted the Faculty");
			faculty.faculty();
		}
		else 
			System.out.println("Faculty not found with rollnumber :"+empId);	
	}
	public void searchFaculty()
	{
		System.out.println("Enter Faculty Roll number :");
		int empId=read.nextInt();
		ArrayList<Faculty> list=readWriteFaculty.ReadFromFile();
		Iterator<Faculty> itr = list.listIterator();
		int count=0,index=0;
		Person person=new Person();
		while (itr.hasNext()) 
		{
			Faculty obj = itr.next();
			int getEmpId = obj.getEmployeeId();
			if(getEmpId==empId)
			{
				count++;
				index=list.indexOf(obj);
				System.out.println("Faculty got...at index :"+index);
				System.out.println("name is :"+obj.person.getName()+"\naddress is :"+obj.person.getAddress());
				faculty.faculty();
			}
		}
		if(count==0)
		{
			System.out.println("Faculty not found with rollnumber :"+empId);
		}
	}
	public void viewAllFaculty()
	{
		ArrayList<Faculty> list=readWriteFaculty.ReadFromFile();
		Iterator<Faculty> itr = list.listIterator();
		person = new Person();
		while (itr.hasNext()) 
		{
			Faculty obj = itr.next();
			System.out.println("name is:  "+obj.person.getName()+"	address :  "+obj.person.getAddress()+"	EmployeeId is :  "+obj.getEmployeeId());
			
		}
		faculty.faculty();
		
	}

}
