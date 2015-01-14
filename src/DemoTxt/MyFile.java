package DemoTxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DemoDto.MyDto;

public class MyFile {

	private ArrayList<String> arrayList;
	private File file;
	private String string;
	private FileWriter fileWriter;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private MyDto myDto;
	public MyFile(MyDto myDto){
		this.myDto = myDto;
		this.arrayList = new ArrayList<String>();
		this.file = new File("note.txt");
	}
	
	public void mywrite(String string) throws IOException{
		this.fileWriter = new FileWriter(file,true);
		this.fileWriter.write(string);
		this.fileWriter.write("\n");
		this.fileWriter.close();
		System.out.println(1212);
	}
	
	public void myread() throws Exception{
		this.fileReader = new FileReader(file);
		this.bufferedReader = new BufferedReader(this.fileReader);
		this.string = this.bufferedReader.readLine();
		while (this.string!=null) {
			this.arrayList.add(this.string);
			this.string = this.bufferedReader.readLine();
		}
		this.myDto.setArrayList(arrayList);
	}
	
	public StringBuffer myfind(String string) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		this.fileReader = new FileReader(file);
		this.bufferedReader = new BufferedReader(this.fileReader);
		this.string = this.bufferedReader.readLine();
		while (this.string != null) {
			if (this.string.startsWith(string)) {
				stringBuffer.append("标题：");
				stringBuffer.append(this.string);
				stringBuffer.append("\n");
				stringBuffer.append("内容：");
				stringBuffer.append(this.bufferedReader.readLine());
				stringBuffer.append("\n");
				stringBuffer.append("输入时间：");
				stringBuffer.append(this.myDto.getDate());
				break;
			}
			this.string = this.bufferedReader.readLine();
		}
		return stringBuffer;
	}
}
