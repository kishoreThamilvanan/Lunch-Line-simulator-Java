/**
 * 
 * @author Kishore Thamilvanan
 * E-mail : kishore.thamilvanan@stonybrook.edu
 * I.D.   : 111373510
 *
 *Class Student - contains details of individual Student.
 *		implements Cloneable
 */
public class Student implements Cloneable {

//private datafields
	private String Stuname; 	// Name of the Student.
	private double lunmoney;	// Lunch money of the Student.
	
	
	/**
	 * Constructor
	 * assigns default name and default lunch money.
	 */
	public Student()
	{
		Stuname = "Stewie";
		lunmoney = 10.11;
	}
	
	/**
	 * Constructor assigns user defined name and lunch money
	 * 		 to the Student.
	 * 
	 * @param name
	 * User entered name for the Student.
	 * 
	 * @param money
	 * User Entered lunch money for the student.
	 */
	public Student(String name, double money)
	{
		
			Stuname = name;
			lunmoney = money;
	}
	
	
	/**
	 * Method returns the name of the Student.
	 * 
	 * @return
	 * returns Stuname
	 */
	public String getStuname()
	{
		return Stuname;
	}

	/**
	 * Method sets the user defined name to the Student.
	 *  
	 * @param name
	 * User defined name for the Student.
	 */
	public void setStuname(String name)
	{
		Stuname = name;
	}
	
	/**
	 * Method returns lunch money.
	 * 
	 * @return
	 * returns lunmoney.
	 */
	public double getlunchmoney()
	{
		return lunmoney;
	}

	/**
	 * Method sets user defined lunch money to the student.
	 * 
	 * @param lunchmoney
	 * User defined lunch money for the Student.
	 */
	public void setlunchmoney(double lunchmoney)
	{
		lunmoney = lunchmoney;
	}
	
		
	/**
	 * Method returns the details of the Student as a String.
	 * 
	 * @return
	 * returns Students details.
	 */
	public String toString()
	{ 
		
		return "\nName: "+Stuname+"\tLunch Money: "+ lunmoney+"\n";
		
	}
	
	
	/**
	 * Method clones the Student Object.
	 * 
	 * @return
	 * returns the super.Clone() of the Student class.
	 */
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
		
	}
	
	
	
	/**
	 * Method checks for equality of the given Student object 
	 * 		with the current Student object.
	 * 
	 * @param s
	 *User entered Student for the purpose of checking for equality. 
	 * 
	 * @return
	 * returns the boolean value for the equality.
	 */
	public boolean equals(Student s)
	{
		if(this.Stuname == s.Stuname && this.lunmoney == lunmoney)
			return true;
		
		else 
			return false;
		 
			
		
	}
	

}
