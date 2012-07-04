package dmlab.unicom.data.handle;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dmlab.unicom.data.structer.GsmSmMonthData;
import dmlab.unicom.data.util.SelectIndex;

/*
 * GsmSmHandler：默认处理bf_gsm_sm_call系列文件，合并费用
 * 
 * 输入是原始的bf_gsm_sm_call，整合每个用户每月的短信数量
 * 
 * @param input：输入文件路径与名字
 * @param output：输出文件路径与名字
 * @param append：是否文件是否连续写入
 * 
 * 输出格式：70265612,201204,15，分别是用户id，时间，短信数量
 *  
 */

public class GsmSmHandler extends Handler{
	
	public GsmSmHandler(String input, String output){
		super(input,output);
	}
	public GsmSmHandler(String input, String output,Boolean append){
		super(input,output,append);
	}

	@Override
	public void handle() throws IOException {
		// TODO Auto-generated method stub
		String s = "";
		Map<String, GsmSmMonthData> map = new HashMap();
		while((s = fg.readLine()) != null)
		{
			try{
			String[] as = s.split(SelectIndex.SPLITER);
			String userid = as[SelectIndex.GSM_SM_CALL_USERID]+SelectIndex.SPLITER
					+as[SelectIndex.GSM_SM_CALL_FEEDATE];
			if(map.containsKey(userid))
			{
				map.get(userid).addDuration(as);
			}
			else
			{
				GsmSmMonthData gc = new GsmSmMonthData(as);
				map.put(userid, gc);			
			}
			}
			catch(Exception e){}	
		}
		//写文件
		fc.writeMap(map);

		fg.close();
		fc.close();
	}

}
