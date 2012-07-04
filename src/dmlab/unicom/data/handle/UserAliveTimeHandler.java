package dmlab.unicom.data.handle;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import dmlab.unicom.data.util.DateParser;
import dmlab.unicom.data.util.SelectIndex;

public class UserAliveTimeHandler extends Handler{
	
	public UserAliveTimeHandler(){
		super(SelectIndex.INPUTPATH + "l_user_info_new.txt",SelectIndex.OUTPUTPATH + "user_info_alivetime.txt");
	}

	public UserAliveTimeHandler(String input, String output){
		super(input,output);
	}
	public UserAliveTimeHandler(String input, String output,Boolean append){
		super(input,output,append);
	}

	@Override
	public void handle() throws IOException, ParseException {
		// TODO Auto-generated method stub
		String s = null;
		while((s = fg.readLine()) != null)
		{
			if(s.toString().startsWith("10"))
				continue;
			String[] line = s.split(SelectIndex.SPLITER);
			Date applyDate = DateParser.parseDate(line[SelectIndex.USER_INFO_APPLYDATE]);
			Date inValidDate = new Date();
			if(line[SelectIndex.USER_INFO_INVALIDDATE].length() == 0 || 
					line[SelectIndex.USER_INFO_INVALIDDATE].equals(""))
				inValidDate = DateParser.parseDate(SelectIndex.nDate);
			else
				inValidDate = DateParser.parseDate(line[SelectIndex.USER_INFO_INVALIDDATE]);
			long interval = inValidDate.getTime() - applyDate.getTime();
			Integer month = (int) (interval/1000/3600/24/30) + 1;
			Integer year = (int) (interval/1000/3600/24/30/12) + 1;
			StringBuilder sb = new StringBuilder();
			sb.append(line[SelectIndex.USER_INFO_USERID]).append(SelectIndex.SPLITER);
			sb.append(line[SelectIndex.USER_INFO_IFVALID]).append(SelectIndex.SPLITER);
			sb.append(line[SelectIndex.USER_INFO_APPLYDATE]).append(SelectIndex.SPLITER);
			sb.append(line[SelectIndex.USER_INFO_INVALIDDATE]).append(SelectIndex.SPLITER);
			sb.append(month).append(SelectIndex.SPLITER);
			sb.append(year);
			fc.writeLine(sb.toString());
		}
		fg.close();
		fc.close();	
	}
}
