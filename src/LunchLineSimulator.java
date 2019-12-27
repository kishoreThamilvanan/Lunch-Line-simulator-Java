import java.util.Scanner;

/**
 * Class LunchLineSimulator - 
 * This class contains the two realities of the simulator game 
 * 
 * @author Kishore Thamilvanan
 * E-mail : kishore.thamilvanan@stonybrook.edu
 * I.D.   : 111373510
 *
 */
public class LunchLineSimulator extends StudentLine{

	private static StudentLine realityA = new StudentLine(); // Default reality of the game	
	private static StudentLine realityB = new StudentLine(); // The other reality of the game
	
	/**
	 * method to return reality A (default reality)
	 * 
	 * @return
	 * returns reality A
	 */
	public static StudentLine getRealityA()
	{
		return realityA;
	}
	
	/**
	 * method to return reality B (other reality)
	 * 
	 * @return
	 * returns reality B
	 */
	public static StudentLine getRealityB()
	{
		return realityB;
	}
	
	/**
	 * Method to set received reality to the reality A
	 * 
	 * @param s
	 * s receives an instance of StudentLine helps to assign it to reality A
	 */
	public static void setRealityA(StudentLine s)
	{
		realityA = s;
	}
	
	/**
	 *Method to set received reality to the reality B
	 *
 	 * @param s
	 * s receives an instance of StudentLine helps to assign it to reality B
	 */
	public static void setRealityB(StudentLine s)
	{
		realityB = s;
	}
	
	/**
	 * menu method - prints all the UI Functions.
	 */
	public static void menu()
	{
		System.out.print("\n\n\t\t** UI  FUNCTIONS **\n");
		System.out.print("\t\t^^ ^^ ^^^^^^^^^ ^^\n\n\n");
		
		System.out.print("A) Add a student to the line at the end.\n");
		System.out.print("B) Have a new Student cut a friend.\n");
		System.out.print("C) Have two students trade places.\n");
		System.out.print("D) Have the bully remove a student.\n");
		System.out.print("E) Update a student's money account.\n");
		System.out.print("F) Print the current reality's lunch line.\n");
		System.out.print("G) Serve a Student.\n");
		System.out.print("H) Switch to the other reality.\n");
		System.out.print("I) Check if the realities are equal.\n");
		System.out.print("J) duplicate realities.\n");
		System.out.print("Q) To quit.\n\n");
		
		System.out.print("Please select an option: ");
	
	}
	
	
	/**
	 * Main Method does all the User Interface functions of the game.
	 *  
	 * @param args
	 * 
	 * 
	 * @throws deanException
	 * a custom exception which is thrown when a student 
	 * 			is added when the line is full.
	 */
	public static void main(String[] args) throws deanException
	{
		StudentLine s = getRealityA();// object of StudentLine.
		Student temp = new Student();//A temporary student object 
											//	for purposes of swapping
		char currentReality = 'A';	 // paramater to indicate the current reality. 
			
		Scanner input = new Scanner(System.in);
			char choice;		// Paramter to accept the user's choice.
		do
		{
			menu();
			 choice = input.next().charAt(0);
		
			if(choice == 'A' || choice == 'a')
			{
				System.out.print("\nEnter details of the student: ");
					
				System.out.print("\nName       : ");
				String name = input.next();
				
				System.out.print("Lunch Money: ");
				double money = input.nextDouble();
				
				Student k = new Student(name,money);
				
				temp = s.addStudent(k);
				
				s.setnumStudents(s.getnumStudents()+1);
				System.out.print(temp.toString());
				System.out.print("The Student has been added to the line.");
				
				
			}
			
			
			else if(choice == 'B' || choice == 'b')
			{
				
				System.out.print("\nEnter the index position where to be inserted :");
				
				int index = input.nextInt();
				
				System.out.print("\nEnter details of the student: ");
				
				System.out.print("\nName       : ");
				String name = input.next();
				
				System.out.print("Lunch Money: ");
				double money = input.nextDouble();
				
				Student k = new Student(name,money);
				
				s.insertStudent(index-1, k);
				System.out.print("The Student has been added to the line.");
				
				s.setnumStudents(s.getnumStudents()+1);
			
			}
			
			
			
			else if(choice == 'C'|| choice == 'c')
			{
				System.out.print("Enter the indices: ");
				
				System.out.print("\nIndex 1: ");
				int index1 = input.nextInt();
				
				System.out.print("Index 2: ");
				int index2 = input.nextInt();
				
				s.swapStudents(index1-1,index2-1);
				System.out.print("The Students are swapped.");
			}
			
			
			else if(choice == 'D' || choice == 'd')
			{
				System.out.print("\nEnter the index: ");
				int index = input.nextInt();
				
				s.removeStudent(index);
				System.out.print("The student has been removed.");
				s.setnumStudents(s.getnumStudents()-1);
			}
			
			
			else if(choice == 'E' || choice =='e')
			{
				System.out.print("\nEnter the folowing details: ");
				
				System.out.print("\nLunch Money: ");
				double money = input.nextDouble();
				
				System.out.print("Index      : ");
				int index = input.nextInt();
				
				Student t = s.getStudent(index);
				
				t.setlunchmoney(money);
				
				System.out.print("The lunch money has been updated.");
			}
			
			
			else if(choice == 'F' || choice =='f')
				System.out.print(s.toString());
		
			
			else if(choice == 'G' || choice == 'g')
			{
								
				s.removeStudent(1);
				System.out.print("The student has been served.");
				s.setnumStudents(s.getnumStudents()-1);
			}
			
			else if(choice == 'H' || choice == 'h')
			{
				if(currentReality == 'A')
				{	
					currentReality = 'B';
					System.out.print("\nSwitching to reality B.");
					s = getRealityB();
				}
				
				else if(currentReality == 'B')
				{	
					currentReality = 'A';
					System.out.print("\nSwitching to reality A.");
					s = getRealityA();
				}
			}
			
			else if(choice == 'I' || choice == 'i')
			{
				StudentLine a = getRealityA();
				StudentLine b = getRealityB();
			
				if(a.getnumStudents() == b.getnumStudents())
				{		
					Student[] s1 = a.getStudentArray();
					Student[] s2 = b.getStudentArray();

					int flag=0;
					for(int i=0;i<a.getnumStudents();i++)
						if(s1[i]!=s2[i])
							flag++;
					
					if(flag==0)
						System.out.print("Both the realities are equal.");
				
					else 
						System.out.print("The realities does not match.");
				}	
				
				else 
					System.out.print("The realities does not match.");
				
			}	
			
			else if(choice== 'j' || choice =='J')
			{
				StudentLine clone = s.clone();
				System.out.print("The realities has been cloned.");
			    
				if(currentReality == 'A')
					setRealityB(s);
				
				
				else if(currentReality == 'B')
					setRealityA(s);
			
			}
			
			
			else if(choice == 'Q' || choice == 'q')
				break;
			
			else 
				System.out.print("\nWe are sorry please enter a valid option...");
			
			
			if(choice == 'Q' || choice == 'q')
				break;
			
	}while(choice !='Q' || choice != 'q' );
	
	
		System.out.print("\nThe simulator has been shutdown. Thank you for using it :) ");
	}
	
}
