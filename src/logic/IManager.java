package logic;

import java.util.ArrayList;

//Manager Class will serve as a facade of logic component

public interface IManager {
	public void processLine(String s); //compute circular shifts, do sorting...
	public ArrayList<String> execute();
}
