package sdbms;

import java.util.Scanner;

import CustomException.InvalidChoicException;

public class Solution {
	public static void main(String[] args) {
		
	System.out.println(  " Welcome to Student Database Maangement System");
	System.out.println("---------------------");
	Scanner ip=new Scanner(System.in);
	StudentManagementSystem s1=new StudentMangementSystemImpl();
	while(true)
	{
		System.out.println("1.addStudent\n2.displayStudent\n3.displayAllStudents\n4.removeStudent\n5.removeAllStudents\n6.updateStudent\n7.countStudents\n8.sortStudent\n9.getStudentWithHighestMarks\n10.getStudentWithLowestMarks\n 11.Exit");
	  int choice=ip.nextInt();
	  switch(choice)
	  {
	  case 1:
		  s1.addStudent();
	  break;
	  case 2:
		  s1.displayStudent();
	  break;
	  case 3:
		  s1.displayAllStudents();
	  break;
	  case 4:
		  s1.removeStudent();
	  break;
	  case 5:
		  s1.removeAllStudents();
	  break;
	  case 6:
		  s1.updateStudent();
	  break;
	  case 7:
		  s1.countStudents();
	  break;
	  case 8:
		  s1.sortStudent();
	  break;
	  case 9:
		  s1.getStudentWithHighestMarks();
	  break;
	  case 10:
		  s1 .getStudentWithLowestMarks();
	  break;
	 
	  case 11:;System.out.println("Thank You !!!!!");
	  System.exit(0);
	  break;
	  default :
		  try
		  {// String msg="Invalid Choice, Kindly enter the Valid Choice!";
			  // throw new InvalidChoicException(msg);
			  throw new InvalidChoicException(" Invalid Choice, Kindly enter the Valid Choice! ");
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
		  }
	
	  
		  
	  }//end of swith
	  System.out.println("-----------------");
	
	}//end of while
	} //end of main 
}//end of class
