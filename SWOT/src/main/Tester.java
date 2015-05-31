package main;

import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		
		Idea ideaOne = new Idea("S","Alex and I did It",2);
		Idea ideaTwo = new Idea("W","GUI is not working with it all",6);
		Idea ideaThree = new Idea("O","We can use this in the future",8);
		Idea ideaFour = new Idea("T","I'll forget how this code works",10);
		ArrayList<Idea> ideaList = new ArrayList<Idea>();
		
		ideaList.add(ideaOne);
		ideaList.add(ideaTwo);
		ideaList.add(ideaThree);
		ideaList.add(ideaFour);
		
		Logic testerLogic = new Logic(ideaList);
		
		System.out.println(testerLogic.getResults());
		
	}

}
