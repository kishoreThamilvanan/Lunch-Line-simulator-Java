/**
 * StudentLine Class - contains the array of objects of class Student,
 * 		StudentLine manipulation methods, toString  and Clone method.
 *
 * StudentLine Class - Extends Student
 * 
 * @author Kishore Thamilvanan
 * E-mail : kishore.thamilvanan@stonybrook.edu
 * I.D.   : 111373510
 */
public class StudentLine extends Student
{

//private data fields
	private final int capacity = 20; 	//MAX number of Students in a line. 
	private Student[] students;			//Array of of objects of class Student.
	private int studentCount=0;			//number of students present in line.
	

	/**
	 * Constructor - initializes number of students and students array.
	 * 	
	 */
	public StudentLine()
	{
		studentCount = 0;
		students = new Student[20];
	}
	
	
	/**
	 *returns the number of student present in line. 
	 *
	 * @return
	 * returns number of Students in line.
	 */
	public int getnumStudents()
	{
		return studentCount;
	}
	
	/**
	 * sets the user defined number of students.
	 * 
	 * @param i
	 * the parameter i is assigned to number of students.
	 */
	public void setnumStudents( int i)
	{
		studentCount = i;
	}
	
	

	/**
	 * Method allows user to access a particular student's details 
	 * 
	 * @param index
	 * index - is the position of the student in the line.
	 * 
	 * <dt>Precondition
	 * <dd>check if there are any students in line.
	 * 			<dd>if no return null
	 * 			
	 * 			<dd>if yes 
	 * 					<dd>check for validity of index
	 * 						<dd>and return the Student.
	 * 
	 * @return
	 * returns the Student of the corresponding index.
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 * Exception thrown when index is out of bounds.
	 * 
	 */
	public Student getStudent(int index) throws 
									ArrayIndexOutOfBoundsException
	{
		if(studentCount == 0)
		{
			System.out.print("There no students in the line.");
			return null;
		}
		
		else
			{	// index check for validity.
				if(index > 0 && index <= studentCount)
					return students[index-1];
		
				else 
					throw new ArrayIndexOutOfBoundsException
					("The index position is not valid.");
			}
	}
	
	
	/**
	 * Method removes the student present in the entered index position
	 * 
	 * @param index
	 * position of the Student in the line.
	 * 
	 * @return
	 * returns the Student to be deleted.
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 * Exception thrown when the index is out of bounds.
	 * 
	 */
	public Student removeStudent(int index) throws 
									ArrayIndexOutOfBoundsException
	{
		Student studentToBeRemoved = new Student();
		
		if(index == 0)
		{
			System.out.println("There are no students on the line.");
			return null;
		}
		
		else
		{
			// index check for validity.
			if(index > 0 && index <= studentCount)
			{
				studentToBeRemoved = students[index-1];
			
				for(int i=1;i<=studentCount-index;i++)
					students[i-1] = students[i];
				
				return studentToBeRemoved;
			}
			
			else 
				throw new ArrayIndexOutOfBoundsException
									("The index position is not valid.");

		}
	
	}
	
	
	/**
	 * Method adds a Student in the Student Line.
	 * 
	 * @param student
	 * object of the class Student which is to be added.
	 * 
	 * @return
	 * returns the object of the added Student.
	 */
	public Student addStudent(Student student)
	{
		students[studentCount] = student;
		
		return student;
	}
	
	/**
	 * Method inserts Student at the entered index position.
	 * 
	 * 		<dt>Precondition
	 * 		<dd>checks for validity of the index position.
	 * 		<dd>checks whether the line is full or not.
	 *  
	 * @param index
	 * index - position of the student in the line.
	 * 
	 * @param student
	 * object of the Student Class which is to be added.
	 * 
	 * @return
	 * returns object of the added student.
	 * 
	 * @throws IllegalArgumentException
	 * Exception thrown when the index entered is an illegal argument.
	 */
	public Student insertStudent(int index, Student student)	
												throws deanException
	{
		
		int length = studentCount;
		
		
		if(index < 0)
			throw new IllegalArgumentException
										("The index position is not valid.");
				
			
		else if(index > 0 && index <= studentCount)
		{
			if(studentCount == capacity)
				throw new deanException("The queue is already full !!"
						+ " you cannot add another student.");
		
			else
			{
				for(int i=length-1; i>=index; i--)
				{
					students[length] = students[i];
					length--;
				}
				students[index] = student;
				
			}
		
		}
		return student;
		
	}	
	
	
	/**
	 * Method checks for the validity of the index.
	 * 
	 * @param index
	 * index - position of the Student in the Line.
	 * 
	 * @return
	 * returns boolean value of the result.
	 */
	public boolean indexCheck(int index)
	{
		
		if(index>=0 && index <=studentCount)
			return true;
		
		else 
			return false;
	}
	
	/**
	 * Method Swaps Students with the entered indices.
	 * 
	 * @param index1
	 * Position of the first student to be swapped.
	 * 
	 * @param index2
	 * position of the second Student to be swapped.
	 */
	public void swapStudents(int index1, int index2)
	{
		
		if(!indexCheck(index1) && indexCheck(index2))
		 throw new IllegalArgumentException
		 						("The index position is not valid.");
			
		else if(index1 == index2)
			return;
		
		else 
		{
			Student tempstu = new Student();
			
			tempstu = students[index1];
			students[index1] = students[index2];
			students[index2] = tempstu;
			
		}
		
	}
	
	/**
	 * Method Clones an object of Class StudentLine.
	 * 
	 * @return 
	 * returns the copied object of the Class StudentLine.
	 */
	public StudentLine clone()
	{
		StudentLine copyStudentLine = new StudentLine();
		
		copyStudentLine.studentCount = this.studentCount; 
		
		for(int i=studentCount-1;i>=0;i--)
		{
			copyStudentLine.students[i] = this.students[i];
		}
		
		return copyStudentLine;
		
	}
	
	
	/**
	 * Method checks for equality of the given object with 
	 * 		the current object of Class StudentLine.
	 *
	 *@return
	 *returns the boolean value corresponding to the equality.
	 */
	public boolean equals(Object o)
	{
		if(o instanceof StudentLine)
			return this.equals(o);     
				
		else 
			return false;
	
	}
	
	
	/**
	 * Method returns array of objects of class Student.
	 * 
	 * @return
	 * returns the the Student array
	 */
	public Student[] getStudentArray()
	{
		return students;
	}
	
	
	/**
	 * Method prints the details of the CAPACITY, number of students
	 * 		and details of individual Student.
	 * 
	 * @return
	 * returns the String of all the details.
	 */
	public String toString()
	{
		String s ="\n\nCAPACITY = "+ capacity+
							"\nStudent Count = "+ studentCount +"\n\n";
		for(int i=0;i<studentCount;i++)
			 System.out.print(students[i].toString());
		
		return s;
	
	}
}
