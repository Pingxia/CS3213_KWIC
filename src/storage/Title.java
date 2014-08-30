package storage;

public class Title implements Comparable<Title>{
	
	public Title(String str, int i){
		line = str;
		index = i;
	}
	
	public void setLine(String str){
		line = str;
	}
	
//	private void setIndex(int i){
//		index = i;
//	} 
//	
	public String getLine(){
		return line;
	}
	
	public int getIndex(){
		return index;
	}
	
	@Override
	public int compareTo(Title other) {
		// TODO Auto-generated method stub
		return this.line.compareTo(other.line); 
		
	}
	
	private int index;
	private String line;
	
}
