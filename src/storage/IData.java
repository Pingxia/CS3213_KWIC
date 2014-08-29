package storage;

import java.util.ArrayList;
import java.util.HashMap;

public interface IData {
	public void addWordsToIgnore(ArrayList<String> wordsToIgnoreToAdd);
	public void addTitles(ArrayList<String> titlesToAdd);
	public boolean checkIfWordsToIgnoreChanged();
	public ArrayList<String> convertTitleListToStringList();
	public void deleteTitles(ArrayList<String> titlesToDelete);
	public void deleteWordsToIgnore(ArrayList<String> wordsToDelete);
	public HashMap<String, Integer> getWordsToIgnore();
	public HashMap<String, Integer> getTitles();
	public ArrayList<String> getTitlesToAdd();
	public ArrayList<String> getTitlesToDelete();
	public int getIndex(String s); 
	public ArrayList<Title> getSortedList();
	public void setSortedList(ArrayList<Title> list);
	public void resetIgnoreChecker();
	void deleteTitlesFromInput();
}
