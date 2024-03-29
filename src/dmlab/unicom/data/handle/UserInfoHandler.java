package dmlab.unicom.data.handle;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dmlab.unicom.data.util.DateParser;
import dmlab.unicom.data.util.SelectIndex;
/*
 * UserInfoHandler：处理UserInfo。txt文件，提取出特定的数据
 * 
 * 输入是原始的l_user_info_new.txt
 * 输出的是SelectIndex。userInfo返回的list列
 * 
 * @param input：输入文件路径与名字
 * @param output：输出文件路径与名字
 * @param append：是否文件是否连续写入
 *  
 */
public class UserInfoHandler extends Handler{
	
	public UserInfoHandler(){
		super("l_user_info_new.txt","user_info.txt");
	}

	public UserInfoHandler(String input, String output){
		super(input,output);
	}
	public UserInfoHandler(String input, String output,Boolean append){
		super(input,output,append);
	}
	
	@Override
	public void handle() throws IOException{
		// TODO Auto-generated method stub
		List list = SelectIndex.userInfo();
		StringBuilder s = new StringBuilder();
		while((s = fg.readList(list)) != null)
		{
			if(s.toString().startsWith("10"))
				continue;
			fc.writeLine(s.toString());
		}
		fg.close();
		fc.close();
	}
	
	public Map vaildMap() throws NumberFormatException, IOException
	{
		Map<String, Integer> isVaildMap = new HashMap();
		String s = null;
		while((s = fg.readLine()) != null)
		{
			String[] as = s.split(SelectIndex.SPLITER);
			if(as[SelectIndex.USER_INFO_IFVALID].length() > 0)
				isVaildMap.put(as[SelectIndex.USER_INFO_USERID], 
					Integer.valueOf(as[SelectIndex.USER_INFO_IFVALID]));
			else
				isVaildMap.put(as[SelectIndex.USER_INFO_USERID], 
						-1);
		}
		fg.close();
		return isVaildMap;
	}
	
	public Map vaildMapWithLimit(Date date) throws IOException, ParseException
	{
		Map<String, Integer> isVaildMap = new HashMap();
		String s = null;
		while((s = fg.readLine()) != null)
		{
			String[] as = s.split(SelectIndex.SPLITER);
			String userid = as[SelectIndex.USER_INFO_USERID];
			String invalid = as[SelectIndex.USER_INFO_INVALIDDATE];
			String apply = as[SelectIndex.USER_INFO_APPLYDATE];
			
			Date applyDate = DateParser.parseDate(apply);
			if(applyDate.after(date))
				continue;
			if(invalid.length() == 0)
			{
				isVaildMap.put(userid, 1);
			}
			else
			{
				Date invalidDate = DateParser.parseDate(invalid);
				if(invalidDate.before(date))
				{
					isVaildMap.put(userid, 0);
				}
				else
				{
					isVaildMap.put(userid, 1);
				}
			}			
		}		
		fg.close();
		fc.close();
		return isVaildMap;
	}
}
