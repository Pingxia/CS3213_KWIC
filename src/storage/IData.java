package storage;

import java.util.ArrayList;

public interface IData {
	public void addWordsToIgnore(String s);
	public void addTitles(String s);
	public int getIndex(String s); 
	public ArrayList<String> getSortedList();
}
