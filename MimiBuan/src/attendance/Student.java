package attendance;

public class Student implements Attendee {
	
	private String firstName;
	private String lastName;
	private boolean studentPresent;
	
	public Student (String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentPresent = false;
	}

	public boolean isPresent() {
		return studentPresent;
	}

	public void setPresent(boolean present) {
		studentPresent = present;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean mathces(String inputFirst, String inputLast) {
		
		String firstLower = inputFirst.toLowerCase();
		String lastLower = inputLast.toLowerCase();
		
		String tempFirstName = firstName.toLowerCase();
		String tempLastName = lastName.toLowerCase();
		
		if (firstLower.equals(tempFirstName) && lastLower.equals(tempLastName))
			return true;
		else
			return false;
	}

	public boolean matches(String inputLast) {
		String lastLower = inputLast.toLowerCase();
		String tempLastName = lastName.toLowerCase();
		
		if (lastLower.equals(tempLastName))
			return true;
		else
			return false;
	}

	public String getReportString() {
		String result;
		
		char[]arr = new char[40];
		
		// last name
		for (int i=0; i<20; i++) {
			if(i<lastName.length())
				arr[i]=lastName.charAt(i);
			else
				arr[i]=' ';
		}
		
		// first name
		for (int i=0; i<20; i++) {
			if(i<firstName.length())
				arr[i+20]=firstName.charAt(i);
			else
				arr[i+20]=' ';
		}
		
		// present or absent
		String presString;
		if(studentPresent)
			presString = "PRESENT\n";
		else
			presString = "ABSENT\n";
		
		result = String.valueOf(arr) + presString;
		
		return result;
	}
	
	// replace w/ "..." if longer than 20 characters
	public String shortenName(String s1, int strlength) {
		if (s1.length()>strlength)
			s1 = s1.substring(0,17)+"...";
		
		while(s1.length()<strlength)
			s1 += " ";

		return s1;
	}
}
