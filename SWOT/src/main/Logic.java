package main;

import java.util.ArrayList;

public class Logic {
	
	private ArrayList<Idea> logIdea;
	int immediate;
	int future;
	int composite;
	
	//establish Logic given parameter of ArrayList of Ideas
	public Logic(ArrayList<Idea> IdeaArrayList) {
		logIdea = IdeaArrayList;
		compute();
	}
	
	//Compute total scores for each idea
	private void compute() {
		int sTotal=0, wTotal=0, oTotal=0, tTotal=0;
		for (Idea ideaTemp : logIdea) {
			if (ideaTemp.SWOTc=="S")
				sTotal+=ideaTemp.value;
			if (ideaTemp.SWOTc=="W")
				wTotal+=ideaTemp.value;
			if (ideaTemp.SWOTc=="O")
				oTotal+=ideaTemp.value;
			if (ideaTemp.SWOTc=="T")
				tTotal+=ideaTemp.value;
		}
		immediate = sTotal-wTotal;
		future = oTotal-tTotal;
	}
	
	//gets()
	public int getCompositeScore() {
		return composite;
	}
	public int getImmediateScore() {
		return immediate;
	}
	public int getFutureScore() {
		return future;
	}
	
}
