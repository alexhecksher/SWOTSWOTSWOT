package main;

import java.util.ArrayList;

public class Logic {
	
	private ArrayList<Idea> logIdea;
	int immediate;
	int future;
	int composite;
	String results;
	
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
		immediate = sTotal-wTotal; //really more like the internal score
		future = oTotal-tTotal; //really more like the external score
		composite = immediate+future;
		
		//Add phrase 1 based on overall composite score i.e. is the idea good as a whole?
		if (composite>0) {
			results = "Overall, this concept is a good idea based on the entries, ";
		}
		else if (composite==0) {
			results = "Overall, it appears as though this concept is neither a good nor a bad idea based on the entries, ";
		}
		else if (composite<0) {
			results = "Overall, this concept is a poor idea based on the entries, ";
		}
		results += "earning a composite score of "+composite+"."; //Phrase 2 to state the composite score
		
		//Are immediate and future both positive or both negative?
		boolean bothNegative=(immediate<0&&future<0);
		boolean bothPositive=(immediate>=0&&future>=0);
		boolean different = !(bothNegative||bothPositive);
		
		//Add phrase 3 based on whether they are both positive, both negative, or one pos and one neg
		if (bothNegative) {
			results += " Both in the internal and external quantifications of this concept, its prospects don't look good, ";
		}
		if (bothPositive && !(immediate==0&&future==0)) {
			results += " Both in the internal and external quantifications of this concept, its prospects look good, ";
		}
		if (different && immediate>future) {
			results += " internally, this concept is a good idea, however the threats are greater than the opportunities, with the concept ";
		}
		if (different && immediate<future) {
			results += " Possibility-wise, this concept is a good idea, however the weaknesses are greater than the strengths, with the concept ";
		}
		results += "earning an internal score of "+immediate+" and an external score of "+future+".";
		
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
	public String getResults() {
		return results;
	}
	
}
