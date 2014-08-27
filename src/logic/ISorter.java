package logic;

import java.util.ArrayList;

import storage.Title;

public interface ISorter {
	public ArrayList<Title> sort(ArrayList<Title> listTBeSorted, ArrayList<Title> sortededList);
}
