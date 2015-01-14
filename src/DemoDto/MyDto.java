package DemoDto;

import java.util.ArrayList;

public class MyDto {

	private ArrayList<String> arrayList = new ArrayList<String>();
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<String> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<String> arrayList) {
		this.arrayList = arrayList;
	}
	
}
