import java.awt.*;
import javax.swing.*;

public class student extends JButton 
{
		String firstName;
		String lastName;
		int age;

		public student(String a, String b, int x)
		{	
			super();
			firstName = a;
			lastName = b;
			age = x;
			
		}
		
		String getInfo()
		{
			return "NAME = "+firstName+ "  "+lastName+"  "+"Age = "+age;
		}
	
	

	
	

}
