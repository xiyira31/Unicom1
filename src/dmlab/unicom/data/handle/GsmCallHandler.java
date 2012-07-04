package dmlab.unicom.data.handle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dmlab.unicom.data.structer.GsmCallMonthData;
import dmlab.unicom.data.util.SelectIndex;

/*
 * GsmCallHandler：默认处理bf_gsm_call系列文件，合并费用
 * 
 * 输入是原始的bf_gsm_call，整合每个用户每月通话时长
 * 
 * @param input：输入文件路径与名字
 * @param output：输出文件路径与名字
 * @param append：是否文件是否连续写入
 *  
 * 输出格式 62110667,201203,4154，分别是userid,时间，通话时长
 * 
 */

public class GsmCallHandler extends Handler{
	
	public GsmCallHandler(String input, String output){
		super(input,output);
	}
	public GsmCallHandler(String input, String output,Boolean append){
		super(input,output,append);
	}

	@Override
	public void handle() throws IOException {
		// TODO Auto-generated method stub
		System.out.print(fg.getFile().getName());
		String s = "";
		Map<String, GsmCallMonthData> map = new HashMap();
		while((s = fg.readLine()) != null)
		{
			
			String[] as = s.split(SelectIndex.SPLITER);
			String userid = as[SelectIndex.GSM_CALL_USERID];
			if(map.containsKey(userid))
			{
				map.get(userid).addDuration(as);
			}
			else
			{
				GsmCallMonthData gc = new GsmCallMonthData(as);
				map.put(userid, gc);			
			}
		}
		fc.writeMap(map);
		fg.close();
		fc.close();
	}

}
