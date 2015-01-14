package Start;

import DemoDto.MyDto;
import DemoFrame.MainFrame;
import DemoTxt.MyFile;

public class Start {

	public static void main(String[] args) {
		MyDto myDto = new MyDto();
		MyFile myFile = new MyFile(myDto);
		MainFrame mainFrame = new MainFrame(myDto);
		mainFrame.setVisible(true);
	}

}
