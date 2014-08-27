package logic;

import java.util.ArrayList;

import storage.Title;

public class Sorter implements ISorter {

	public ArrayList<Title> sort(ArrayList<Title> listToBeSorted, ArrayList<Title> sortedList) {
		// TODO Auto-generated method stub
		for (Title t :  listToBeSorted){
			binaryInsertionSort(t, sortedList, 0, sortedList.size());
		}	
		return sortedList;
	}

	private void binaryInsertionSort(Title t, ArrayList<Title> sortedList, int left,
			int right) {
		// TODO Auto-generated method stub
		while (left < right){
			int pivot = (left + right) / 2; 
			if (t.compareTo(sortedList.get(pivot))== 0){
				sortedList.add(pivot, t);
				break;
			}
			else if(t.compareTo(sortedList.get(pivot)) > 0){
				left = pivot + 1;
			} 
			else{
				right = pivot - 1;
			}
			sortedList.add(pivot, t);
		}
	}

	

}
