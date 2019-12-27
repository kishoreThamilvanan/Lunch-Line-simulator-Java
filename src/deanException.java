/**
 * deanException Class - custom exception class which is called when
 * 		an student is added to full student line.
 * @author Kishore Thamilvanan
 * E-mail : kishore.thamilvanan@stonybrook.edu
 * I.D.   : 111373510
 */
public class deanException extends Exception{
	
	/**
	 * default constructor
	 */
	public deanException()
	{
		
	}
	
	/**
	 * constructor
	 * @param message
	 * The message is the custom exception message
	 * 		designed by the programmer.  
	 */
	 public deanException(String message)
	 {
		 super(message);
	 }

}
