package dmlab.unicom.data.handle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dmlab.unicom.data.file.FileGetter;
import dmlab.unicom.data.util.SelectIndex;

/*
 * GsmCallMergeHandler：默认处理l_pay_fee文件，合并费用
 * 
 * 输入是原始的l_pay_fee，整合每个用户每月的短信数量
 * 
 * @param input：输入文件路径与名字
 * @param output：输出文件路径与名字
 * @param append：是否文件是否连续写入
 * 
 * 输出格式：22564267,199,5,68,25,0,0,0,1750,5,64,30,0,0,0,1
 *  0:userid;1:用户总数;2:联通朋友数;3:移动朋友数;4:电信朋友数;15:是否合法(-1为未定义,0为注销用户,1为合法用户) *  
 *  
 */

public class GsmCallMergeHandler extends Handler{

	public GsmCallMergeHandler(){
		super(SelectIndex.INPUTPATH + "bf_gsm_call_merge_format_new.txt",SelectIndex.OUTPUTPATH + "bf_gsm_call_merge_format_with_rate.txt");
	}
	
	public GsmCallMergeHandler(String input, String output){
		super(input,output);
	}
	public GsmCallMergeHandler(String input, String output,Boolean append){
		super(input,output,append);
	}
	
	@Override
	public void handle() throws IOException {
		// TODO Auto-generated method stub
		String s = null;
		
		Map<String, Integer> isVaildMap = new HashMap();
		FileGetter userinfofg = new FileGetter(SelectIndex.INPUTPATH + "l_user_info_new.txt");
		while((s = userinfofg.readLine()) != null)
		{
			String[] as = s.split(SelectIndex.SPLITER);
			if(as[SelectIndex.USER_INFO_IFVALID].length() > 0)
				isVaildMap.put(as[SelectIndex.USER_INFO_USERID], 
					Integer.valueOf(as[SelectIndex.USER_INFO_IFVALID]));
			else
				isVaildMap.put(as[SelectIndex.USER_INFO_USERID], 
						-1);
		}
		
		while((s = fg.readLine()) != null)
		{
			String[] line = s.split(SelectIndex.SPLITER);
			String spliter = SelectIndex.SPLITER;
			StringBuilder sb = new StringBuilder();
			String userid = line[SelectIndex.GSM_CALL_MERGE_FORMAT_USERID];
			Integer friendTotal = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_TOTAL]);
			Integer duringTotal = 0;
			sb.append(userid).append(spliter);
			Integer friend1 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_1]);
			Integer friend2 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_2]);
			Integer friend3 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_3]);
			Integer friend4 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_4]);
			Integer friend5 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_5]);
			Integer friend6 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_6]);
			
			Integer during1 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_1]);
			Integer during2 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_2]);
			Integer during3 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_3]);
			Integer during4 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_4]);
			Integer during5 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_5]);
			Integer during6 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_6]);
			
			during1 *= friend1;
			during2 *= friend2;
			during3 *= friend3;
			during4 *= friend4;
			during5 *= friend5;
			during6 *= friend6;
			
			duringTotal = during1+ during2 + during3 + during4 +during5 + during6;
			
			if(friendTotal > 0)
			{
				friend1 = friend1*100/friendTotal;
				friend2 = friend2*100/friendTotal;
				friend3 = friend3*100/friendTotal;
				friend4 = friend4*100/friendTotal;
				friend5 = friend5*100/friendTotal;
				friend6 = friend6*100/friendTotal;
			}
			if(duringTotal > 0)
			{
				during1 = during1*100/duringTotal;
				during2 = during2*100/duringTotal;
				during3 = during3*100/duringTotal;
				during4 = during4*100/duringTotal;
				during5 = during5*100/duringTotal;
				during6 = during6*100/duringTotal;
			}
						
			sb.append(friendTotal).append(spliter);
			sb.append(friend1).append(spliter);
			sb.append(friend2).append(spliter);
			sb.append(friend3).append(spliter);
			sb.append(friend4).append(spliter);
			sb.append(friend5).append(spliter);
			sb.append(friend6).append(spliter);
			sb.append(duringTotal).append(spliter);
			sb.append(during1).append(spliter);
			sb.append(during2).append(spliter);
			sb.append(during3).append(spliter);
			sb.append(during4).append(spliter);
			sb.append(during5).append(spliter);
			sb.append(during6).append(spliter);
			
			if(isVaildMap.containsKey(userid))
			{
				sb.append(isVaildMap.get(userid));
			}
			else
			{
				sb.append(-1);
			}
			fc.writeLine(sb.toString());			
		}
		fg.close();
		fc.close();
		userinfofg.close();
	}

}
