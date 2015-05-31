package main;

public class Idea {
	
	String SWOTc;
	String desc;
	int value;
	
	public Idea() {
	}
	public Idea(String SWOT_Choice, String SWOT_Description, int SWOT_Value) {
		SWOTc = SWOT_Choice;
		desc = SWOT_Description;
		value = SWOT_Value;
	}
	
	String getSWOTChoice() {
		return SWOTc;
	}
	
	String getDescription() {
		return desc;
	}
	
	int getValue() {
		return value;
	}
	
}
