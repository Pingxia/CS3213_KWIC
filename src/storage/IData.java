package storage;

import java.util.ArrayList;

public interface IData {
	public void addWordsToIgnore(String s);
	public void addTitle(String s);
	public void deleteWordsToIgnore(String s);
	public void deleteTitle(String s);
	public ArrayList<String> getWordsToIgnore();
	public ArrayList<String> getTitlesToAdd();
	public ArrayList<String> getTitlesToDelete();
	public int getIndex(String s); 
	public ArrayList<String> getSortedList();
	public void setSortedList(ArrayList<String> list);
}
