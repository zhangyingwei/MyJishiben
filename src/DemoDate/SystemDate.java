package DemoDate;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SystemDate {
	public SystemDate(){
	}
	public String getdate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd kk:mm:ss");
		return sdf.format(date);
	}
}
