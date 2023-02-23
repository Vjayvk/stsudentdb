package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import CustomException.InvalidChoicException;
import CustomException.StudentNotFoundException;
import customSorting.SortStudentByAge;
import customSorting.SortStudentById;
import customSorting.SortStudentByMarks;
import customSorting.SortStudentByName;




public class StudentMangementSystemImpl implements StudentManagementSystem {


	Scanner ip=new Scanner(System.in);
	Map<String ,Student> db=new LinkedHashMap<String, Student>();

	@Override
	public void addStudent()
	{ 
		System.out.println(" Enter the Student Age");
		int age=ip.nextInt();

		System.out.println(" Enter the Student name");

		String name=ip.next();

		System.out.println("Enter the Student marks");


		int marks =ip.nextInt();

		Student s=new Student(name, age, marks);
		db.put(s.getId(), s);
		System.out.println("Student Data Registered ");
		System.out.println("Student id "+ s.getId());

	}
	@Override
	public void displayStudent()
	{
		System.out.println(" Enter the Student Id Correctly");
		String id =ip.next();
		id=id.toUpperCase();//String id=ip.next().toUppercase();
		if(db.containsKey(id)) 
		{
			Student std=db.get(id);
			System.out.println(" ID : "+std.getId());
			System.out.println(" Age : "+std.getAge());
			System.out.println(" Name : "+std.getName());
			System.out.println(" Marks : "+std.getMarks());
			//  System.out.println(std); beacuse toStrimng() is Overriden
		}
		else
		{
			try
			{
				String message =" Student  with the Id "+id+ " is not Found !";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayAllStudents()
	{

		if(db.size()!=0) {System.out.println("Students Details are as follows");
		System.out.println("-----------------");

		Set<String> keys=db.keySet(); //AA100 AA101 AA102

		for(String key: keys)
		{
			Student std=db.get(key);
			System.out.println(std);
			// System.out.println(db.get(key));
		}
		}
		else
		{

			try
			{
				String message =" Student Data Base is Empty, Nothing to To display";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeStudent()
	{
		System.out.println(" Enter the id ");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println(" student Record found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student record Deleted Successfully!");
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("Student Record wth the  "+id+ " not present cant able remove");

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}


	}
	@Override
	public void removeAllStudents()
	{
		if(db.size()!=0)
		{
			System.out.println(" Student Records Available :"+db.size());
			db.clear();
			System.out.println(" All Student Records Deleted Successfully");
			System.out.println(" Student Records Available :"+db.size());
		}
		else
		{
			try
			{
				String message =" Student Data Base is Empty, Nothing to Do deleted";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateStudent()
	{
		System.out.println(" Enter the id :");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Student Record Found  ");
			Student s1=db.get(id);
			System.out.println(s1);

			System.out.println("1.Update Age \n2.Update Name \n3.Update Marks \n4.Exit ");
			System.out.println("Enter The Choice");
			int choice=ip.nextInt();
			switch(choice)
			{
			case 1:System.out.println("Enter The Age");
			int age=ip.nextInt();
			s1.setAge(age);//s1.setAge(ip.nextInt());
			break;
			case 2: 
				System.out.println(" Enter The Name");
				String name=ip.next();
				s1.setName(name);//s1.setAge(ip.next());
				break;
			case 3: System.out.println("Enter The Marks");
			int marks=ip.nextInt();
			s1.setMarks(marks);
			break;
			default:
				try
				{String msg=" Invalid choice ,Kindly Enter  the Valid Choice!!";
				throw new  InvalidChoicException(msg);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}

			}
			System.out.println(" Student data Updated ");
			System.out.println(db.get(id));

		}
		else
		{
			try
			{
				throw new StudentNotFoundException("Student Record wth the  "+id+ " not present cant able update");

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
		
			}
		}
	}
	@Override
	public void countStudents()
	{
		System.out.println("No of Students Records :"+ db.size() );
	}
	private static void display(List<Student> l)
	{
		
		// used to  avoid multiple for  loop in sorting students by calling method name
		for(Student s: l)
		{
			System.out.println(s);
		}
	}
	@Override
	public void sortStudent()

	{
		if(db.size()>=2)
		{
		Set<String> keys=db.keySet();
		List<Student> l=new ArrayList<Student>();
		for(String key:keys)
		{
			l.add(db.get(key));
		}

		System.out.println("1.SortStudnetById\n2.SortStudentByAge\n3.SortStudentByName\n4.SortStudentByMarks");
		System.out.println("Enter the Choice");
		int choice=ip.nextInt();
		switch(choice)
		{
		case 1: Collections.sort(l,new SortStudentById());
		display(l);
		break;
		case 2: Collections.sort(l,new SortStudentByAge());
		display(l);
		break;
		case 3: Collections.sort(l,new SortStudentByName());
		display(l);
		break;
		case 4: Collections.sort(l,new SortStudentByMarks());
		display(l);
		break;
		default:
			try
			{
				String msg="Invalid Choice , Kindly Enter The Correct choice!!";
				throw new InvalidChoicException(msg);

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		}
		 else
	       {
	    	   try
				{
					throw new StudentNotFoundException("No Student Sufficient  records to Compare! ");

				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
			
				}
	       }
		
	}
	@Override
	public void getStudentWithHighestMarks()
	{
       if(db.size()>=2)
       {
		Set<String> keys=db.keySet();
		List<Student> l=new ArrayList<Student>();
		for(String key:keys)
		{
			l.add(db.get(key));
		}
		Collections.sort(l,new SortStudentByMarks());
		System.out.println(l.get(l.size()-1));
       }
       else
       {
    	   try
			{
				throw new StudentNotFoundException("No Student Sufficient  records to Compare! ");

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
		
			}
       }
	}
	@Override
	public void getStudentWithLowestMarks()
	{
		if(db.size()>=2)
		{
		Set<String> keys=db.keySet();
		List<Student> l=new ArrayList<Student>();
		for(String key:keys)
		{
			l.add(db.get(key));
		}
		Collections.sort(l,new SortStudentByMarks());
		
		System.out.println(l.get(0));// getting student object
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("No Suffiecient Student Records to Compare! ");

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
		
			}
		}
	}


}







