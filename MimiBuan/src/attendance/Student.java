package attendance;

public class Student implements Attendee {
	
	private String first;
	private String last;
	
	public Student (String firstName, String lastName){
		String first = firstName;
		String last = lastName;
	}

	public boolean isPresent() {
		if (student )
			return true;
		else
			return false;
	}

	public void setPresent(boolean present) {

	}

	public String getFirstName() {
		return first;
	}

	public String getLastName() {
		return last;
	}

	public boolean mathces(String first, String last) {
		return false;
	}

	public boolean matches(String last) {
		return false;
	}

	public String getReportString() {
		return null;
	}

}
