package arrays;

public class Person {
	
	public static final String[] FIRST_START = {"Chr", "M", "L", "Gr", "Ph", "B", "Th"};
	public static final String[] FIRST_MIDDLE = {"isti", "icha", "era", "eta", "ala", "ina", "ana"};
	public static final String[] FIRST_END = {"", "na", "n", "r", "tian", "s", "rs", "mp"};
	
	public static final String[] LAST_START = {"Tr", "Br", "L", "Gr", "Sh", "B", "Th"};
	public static final String[] LAST_MIDDLE = {"om", "o", "an", "ola", "et", "e", "is"};
	public static final String[] LAST_END = {"", "son", "ers", "rian", "ston", "ck", "sk"};
	
	private String firstName;
	private String lastName;
	private Borough home;
	private Hobby hobby;
	private Person[] friends;
	private String nickname;
	
	public Person(String first, String last, Borough home){
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		friends = new Person[3];
		this.nickname = createNickname(firstName);
	}
	
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
		nickname = createNickname(firstName);
	}



	// JAVA IS PASS-BY-VALUE
	// meaning the parameters of a method are just values, not references
	// so if you change those values, the original object is not affected.
	// In this case, 'name' will not be changed. In fact, NOTHING can change.
	// this.firstName via name
	public static String createNickname(String name) {
		String nickname = "";
		int secondVowelPsn = findSecond(name);
		nickname = name.substring(0, secondVowelPsn);
		return nickname;
	}
	
	private static int findSecond(String word) {
		boolean foundVowel = false;
		int index = word.length();
		for(int i = 0; i < word.length(); i++) {
			if(word.substring(i, i + 1).equals("a") || word.substring(i, i + 1).equals("e") || word.substring(i, i + 1).equals("i") || word.substring(i, i + 1).equals("o") || word.substring(i, i + 1).equals("u")) {
				if(!foundVowel)
					foundVowel = true;
				else
					return i;
			}
		}
		return index;
	}

	/*
	 * chooses friends from people based on who is of the same class
	 * as this instance and who has the same hobbies
	 * @param people
	 */
	public void mingle(Person[] people) {
		System.out.println("I am in the class " + this.getClass());
		for(Person p: people) {
			if(p != this) {
				//reassign p to the better of the two friends: your current best friend or p
				p = betterFriend(p, friends[0]);
				addFriendToFirstPlace(p);
			}
		}
	}
	
	private Person betterFriend(Person p, Person q) {
		// having a friend is better than having no friend at all
		if(p == null)
			return q;
		if(q == null)
			return p;
		if(p.getClass() == this.getClass() && q.getClass() == this.getClass()) {
			if(p.hobby == this.hobby)
				return p;
			else
				if(q.hobby == this.hobby)
					return q;
		}
		if(p.getClass() == this.getClass())
			return p;
		if(q.getClass() == this.getClass())
			return q;
		// if non of these are true, just take p
		return p;
	}

	public void printFriends() {
		System.out.println("My name is " + firstName + lastName + " and these are my friends:");
		
		for(Person f: friends) {
			if(f != null)
				System.out.println(f);
		}
	}
	
	/*
	 *Moves all Person in friends back one index and puts p at index 0
	 *@param p
	*/
	public void addFriendToFirstPlace(Person p) {
		for(int i = friends.length - 1; i > 0; i--) {
			// ...and moves each friend back a positions
			friends[i] = friends[i - 1];
		}
		friends[0] = p;
	}
	
	public String toString() {
		return "My name is " + firstName + " " + lastName + ". Call me " + nickname + ". I live in " + home + ". I like to " + hobby;
	}
	
}
