import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class ReadWriteInfo {

	File log = new File("student.txt");
	Student student=new Student();
	public void writeFile(Object object)
	{
		Student student=(Student)object;
		List<Student> list=new ArrayList<Student>();
		list.add(student);
		System.out.println("you have added the student objects into list succesfully");
		writeIntoFile((ArrayList<Student>) list);
	}
	public void writeIntoFile(ArrayList<Student> list)
	{
			
	   try {
			
			Iterator<Student> itr = list.iterator();
			while (itr.hasNext()) 
			{
				Student obj = (Student) itr.next();
				Person person=new Person();
				String getName = obj.person.getName();
				String getAddress = obj.person.getAddress();
				int getRollNumber = obj.getRollNumber();
				String makeLine = getName + "," + getAddress + ","+ getRollNumber;
				
				FileWriter file=new FileWriter(log,true);
				
				BufferedWriter br=new BufferedWriter(file);
				br.append(makeLine);
				br.newLine();	
				br.close();
				System.out.println("Student information is entered succesfully...!");
				student.student();
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void writeIntoFileInOverwriteMode(ArrayList<Student> list)
	{
		File file = new File("student.txt");
		BufferedWriter br;
		
		try {
			br = new BufferedWriter(new FileWriter(file));
			Iterator<Student> itr = list.iterator();
			while (itr.hasNext()) {
				Student obj = (Student) itr.next();
				Person person=new Person();
				String getName = obj.person.getName();
				String getAddress = obj.person.getAddress();
				int getRollNumber = obj.getRollNumber();
				String makeLine = getName + "," + getAddress + ","+ getRollNumber;
				br.write(makeLine);
				br.newLine();
			}
			br.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public ArrayList<Student> ReadFromFile()
	{
		ArrayList<Student> list2=new ArrayList<Student>();
		
		
		File file = new File("student.txt");
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String details = scan.nextLine();

				String[] data = details.split(",");
				
				Student info = new Student(data[0], data[1],Integer.parseInt(data[2]));
				list2.add(info);
			}
			scan.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list2;
	}
}
