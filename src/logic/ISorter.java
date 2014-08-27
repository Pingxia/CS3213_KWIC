package logic;

import java.util.ArrayList;

import storage.Title;

public interface ISorter {
	public ArrayList<Title> sort(ArrayList<Title> listToBeSorted, ArrayList<Title> sortedList);
}
