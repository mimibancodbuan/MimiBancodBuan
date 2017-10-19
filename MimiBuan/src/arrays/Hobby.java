package arrays;

public class Hobby extends Thing{

	public Hobby(String description) {
		super(description);
	}

	public static Hobby randomHobby() {
		Hobby[] someHobbies = {new Hobby("programming"), new Hobby("dancing"), new Hobby("playing video games")};
		return someHobbies[(int)(Math.random()*someHobbies.length)];
	}
	
}
