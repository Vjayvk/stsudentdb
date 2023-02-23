package sdbms;

public class Student {
  private String id;
  private String name;
  private int age;
  private int marks;
  static int count=100;
  public Student(String name, int age, int marks)
  {
	  this.name=name;
	  this.age=age;
	  this.marks=marks;
	  this.id="AA"+count;
	  count++;
  }
  public String getName()
  {
	  return name;
  }
  public String getId()
  {
	  return id;
  }
  public int getAge()
  {
	  return age;
  }
  public int getMarks()
  {
	  return marks;
  }
  @Override
  public String toString()
  {
	  return " Id : " +id+ "   Age:  "+ age +"  Name : "+ name+ " Marks : "+ marks; 
  }

public void setName(String name) {
	this.name = name;
}
public void setAge(int age) {
	this.age = age;
}
public void setMarks(int marks) {
	this.marks = marks;
}
}
