package dmlab.unicom.data.handle;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	

}
