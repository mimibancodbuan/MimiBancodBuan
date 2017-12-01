package search;

public class RecursionSample {

	public static void main(String[] args) {
		String[] list = new String[100];
		repeat(list.length, new Action() {

			int index = 0;

			@Override
			public void act() {
				list[index] = "Trial";
				index++;
			}
		} );
		System.out.println(Arrays.toString(list));
	}


	public static void repeat(int times, Action a){
		if (times >0){
			a.act();
			repeat(times - 1,a);
		}
	}

}