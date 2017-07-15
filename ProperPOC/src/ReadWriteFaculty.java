import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class ReadWriteFaculty {

	File log = new File("faculty.txt");
	Faculty faculty=new Faculty();
	public void writeFile(Object object)
	{
		Faculty Faculty=(Faculty)object;
		List<Faculty> list=new ArrayList<Faculty>();
		list.add(Faculty);
		System.out.println("you have added the Faculty objects into list succesfully");
		writeIntoFile((ArrayList<Faculty>) list);
	}
	public void writeIntoFile(ArrayList<Faculty> list)
	{
			
	   try {
			
			Iterator<Faculty> itr = list.iterator();
			while (itr.hasNext()) 
			{
				Faculty obj = (Faculty) itr.next();
				Person person=new Person();
				String getName = obj.person.getName();
				String getAddress = obj.person.getAddress();
				int getEmpId = obj.getEmployeeId();
				String makeLine = getName + "," + getAddress + ","+ getEmpId;
				
				FileWriter file=new FileWriter(log,true);
				
				BufferedWriter br=new BufferedWriter(file);
				br.append(makeLine);
				br.newLine();	
				br.close();
				System.out.println("Faculty information is entered succesfully...!");
				faculty.faculty();
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void writeIntoFileInOverwriteMode(ArrayList<Faculty> list)
	{
		File file = new File("faculty.txt");
		BufferedWriter br;
		
		try {
			br = new BufferedWriter(new FileWriter(file));
			Iterator<Faculty> itr = list.iterator();
			while (itr.hasNext()) {
				Faculty obj = (Faculty) itr.next();
				Person person=new Person();
				String getName = obj.person.getName();
				String getAddress = obj.person.getAddress();
				int getEmpId = obj.getEmployeeId();
				String makeLine = getName + "," + getAddress + ","+ getEmpId;
				br.write(makeLine);
				br.newLine();
			}
			br.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public ArrayList<Faculty> ReadFromFile()
	{
		ArrayList<Faculty> list2=new ArrayList<Faculty>();
		
		
		File file = new File("faculty.txt");
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String details = scan.nextLine();

				String[] data = details.split(",");
				
				Faculty info = new Faculty(data[0], data[1],Integer.parseInt(data[2]));
				list2.add(info);
			}
			scan.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list2;
	}

}
