import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class PersonManipulation {

	File log = new File("student.txt");
	ReadWriteInfo readWriteInfo=new ReadWriteInfo();
	Scanner read=new Scanner(System.in);
	Student student=new Student();
	private Person person;
	
	public void newStudent()
	{	
		System.out.println("Enter Student Name :");
		String studentName=read.nextLine();
		System.out.println("Enter Student Address :");
		String address=read.nextLine();
		System.out.println("Enter Student Roll number :");
		int rollNumber=read.nextInt();
		Student object =new Student(studentName,address,rollNumber);
		
		readWriteInfo.writeFile(object);
	}
	public void updateStudent()
	{
		//Scanner read = null;
		System.out.println("Enter Student Roll number :");
		int rollNumber=this.read.nextInt();
		List<Student> list=readWriteInfo.ReadFromFile();
		
			Iterator<Student> itr = list.listIterator();
			int count=0,index=0;
			while (itr.hasNext()) 
			{
				Student obj = itr.next();
				int getRollNumber = obj.getRollNumber();
				if(getRollNumber==rollNumber)
				{
					count++;
					index=list.indexOf(obj);
					itr.remove();	
				}
			}
			if(count==1)
			{
				System.out.println("student got...at index :"+index);
				Scanner read1 = new Scanner(System.in);
				System.out.println("Now enter the new details..");
				System.out.println("Enter new name :");
				String newName = read1.nextLine();
				System.out.println("Enter new address :");
				String newAddress = read1.nextLine();
				Student newObject=new Student(newName,newAddress,rollNumber);
				list.add(index,newObject);
				readWriteInfo.writeIntoFileInOverwriteMode((ArrayList<Student>) list);
				System.out.println("you succesfully updated the student");
				student.student();
			}
			else 
				System.out.println("Student not found with rollnumber :"+rollNumber);
	}
	public void deleteStudent()
	{
		System.out.println("Enter Student Roll number to delete :");
		int rollNumber=read.nextInt();
		ArrayList<Student> list=readWriteInfo.ReadFromFile();
		
		Iterator<Student> itr = list.listIterator();
		int count=0,index=0;
		while (itr.hasNext()) 
		{
			Student obj = itr.next();
			int getRollNumber = obj.getRollNumber();
			if(getRollNumber==rollNumber)
			{
				count++;
				index=list.indexOf(obj);
				itr.remove();
				
			}
		}
		if(count==1)
		{
			System.out.println("student got...at index :"+index);
			readWriteInfo.writeIntoFileInOverwriteMode((ArrayList<Student>) list);
			System.out.println("you succesfully deleted the student");
			student.student();
		}
		else 
			System.out.println("Student not found with rollnumber :"+rollNumber);	
	}
	public void searchStudent()
	{
		System.out.println("Enter Student Roll number :");
		int rollNumber=read.nextInt();
		ArrayList<Student> list=readWriteInfo.ReadFromFile();
		Iterator<Student> itr = list.listIterator();
		int count=0,index=0;
		Person person=new Person();
		while (itr.hasNext()) 
		{
			Student obj = itr.next();
			int getRollNumber = obj.getRollNumber();
			if(getRollNumber==rollNumber)
			{
				count++;
				index=list.indexOf(obj);
				System.out.println("student got...at index :"+index);
				System.out.println("name is :"+obj.person.getName()+"\naddress is :"+obj.person.getAddress());
				student.student();
			}
		}
		if(count==0)
		{
			System.out.println("Student not found with rollnumber :"+rollNumber);
		}
	}
	public void viewAllStudents()
	{
		ArrayList<Student> list=readWriteInfo.ReadFromFile();
		Iterator<Student> itr = list.listIterator();
		person = new Person();
		while (itr.hasNext()) 
		{
			Student obj = itr.next();
			System.out.println("name is:  "+obj.person.getName()+"	address :  "+obj.person.getAddress()+"	rollnumber is :  "+obj.getRollNumber());
			
		}
		student.student();
		
	}

}
