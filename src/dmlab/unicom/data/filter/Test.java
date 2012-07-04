package dmlab.unicom.data.filter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import dmlab.unicom.data.file.FileCreater;
import dmlab.unicom.data.file.FileGetter;
import dmlab.unicom.data.handle.GatherFeeHandler;
import dmlab.unicom.data.handle.GsmCallHandler;
import dmlab.unicom.data.handle.GsmCallMergeHandler;
import dmlab.unicom.data.handle.Handler;
import dmlab.unicom.data.handle.UserAliveTimeHandler;
import dmlab.unicom.data.handle.UserInfoHandler;
import dmlab.unicom.data.structer.GatherFee;
import dmlab.unicom.data.structer.GsmCallMonthData;
import dmlab.unicom.data.structer.GsmSmMonthData;
import dmlab.unicom.data.structer.PayFee;
import dmlab.unicom.data.util.DateParser;
import dmlab.unicom.data.util.SelectIndex;

public class Test {
	
	public final static String inputpath= SelectIndex.INPUTPATH;
	public final static String outputpath=SelectIndex.OUTPUTPATH;
	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Handler handler = new GsmCallHandler("bf_gsm_call_201205.txt","gsm_call_new.txt",false);
		handler.handle();
		handler = new GsmCallHandler("bf_gsm_call_201204.txt","gsm_call_new.txt",true);
		handler.handle();
		handler = new GsmCallHandler("bf_gsm_call_201203.txt","gsm_call_new.txt",true);
		handler.handle();
		handler = new GsmCallHandler("bf_gsm_call_201202.txt","gsm_call_new.txt",true);
		handler.handle();
		handler = new GsmCallHandler("bf_gsm_call_201201.txt","gsm_call_new.txt",true);
		handler.handle();
		handler = new GsmCallHandler("bf_gsm_call_201112.txt","gsm_call_new.txt",true);
		handler.handle();
		handler = new GsmCallHandler("bf_gsm_call_201111.txt","gsm_call_new.txt",true);
		handler.handle();
		handler = new GsmCallHandler("bf_gsm_call_201110.txt","gsm_call_new.txt",true);
		handler.handle();
		handler = new GsmCallHandler("bf_gsm_call_201109.txt","gsm_call_new.txt",true);
		handler.handle();
		handler = new GsmCallHandler("bf_gsm_call_201108.txt","gsm_call_new.txt",true);
		handler.handle();
//		Handler handler = new GatherFeeHandler("l_user_info_new.txt","user_info.txt",false);
//		handleUserInfo("l_user_info_new.txt","user_info.txt",false);
//		handleGatherFee("bf_gather_fee_t.txt", "gather_fee2012.txt", false);
//		handleGsmCall("bf_gsm_call_201205.txt", "gsm_call.txt", false);
//		handleGsmCall("bf_gsm_call_201204.txt", "gsm_call.txt", true);
//		handleGsmCall("bf_gsm_call_201203.txt", "gsm_call.txt", true);
//		handleGsmCall("bf_gsm_call_201202.txt", "gsm_call.txt", true);
//		handleGsmCall("bf_gsm_call_201201.txt", "gsm_call.txt", true);
//		handleGsmCall("bf_gsm_call_201112.txt", "gsm_call.txt", true);
//		handleGsmCall("bf_gsm_call_201111.txt", "gsm_call.txt", true);
//		handleGsmCall("bf_gsm_call_201110.txt", "gsm_call.txt", true);
//		handleGsmCall("bf_gsm_call_201109.txt", "gsm_call.txt", true);
//		handleGsmCall("bf_gsm_call_201108.txt", "gsm_call.txt", true);
//		handleGsmSm("bf_gsm_sm_call_2012.txt","gsm_sm.txt",false);
//		handleGatherFee("bf_gather_fee_t.txt", "clear_gather_fee_2012.txt", false);
//		handlePayFee("l_pay_fee.txt","pay_fee.txt",false);
//		handleGsmCallMerge("bf_gsm_call_merge_format_new.txt","bf_gsm_call_merge_format_with_rate.txt",false);
	}
	//处理USERINFO
	private static void handleUserInfo(String inputFile, String outputFile, Boolean append) throws IOException
	{
		FileGetter fg = new FileGetter(inputpath + inputFile);
		FileCreater fc = new FileCreater(outputpath + outputFile, append);
		List list = SelectIndex.userInfo();
		StringBuilder s = new StringBuilder();
		Integer i = 0;
		while((s = fg.readList(list)) != null)
		{
			if(s.toString().startsWith("10"))
				continue;
			//s.delete(0, 1);
			fc.writeLine(s.toString());
			System.out.println(i);
			i++;
		}
		fg.close();
		fc.close();
	}
	
	//处理bf_gather_fee_t
	private static void handleGatherFee(String inputFile, String outputFile, Boolean append) throws IOException
	{
		FileGetter fg = new FileGetter(inputpath + inputFile);
		FileCreater fc = new FileCreater(outputpath + outputFile, append);
		List list = SelectIndex.gatherFee();
		String s = new String();
		Integer i = 0;
		GatherFee gf = new GatherFee();
		while((s = fg.readLine()) != null)
		{
			if(s.toString().startsWith("10"))
				continue;
			String[] as = s.split(SelectIndex.SPLITER);
			if(gf.isNew())
				gf.init(as);
			else if(gf.isSame(as))
			{
				gf.gatherFee(as);
			}
			else
			{
				fc.writeLine(gf.toString());
				gf = new GatherFee(as);
				System.out.println(i);
				i++;
			}			
		}
		fg.close();
		fc.close();
	}
	
	private static void handleGsmCall(String inputFile, String outputFile, Boolean append) throws IOException
	{
		FileGetter fg = new FileGetter(inputpath + inputFile);
		FileCreater fc = new FileCreater(outputpath + outputFile, append);
		String s = "";
		Long index = (long) 0;
		Long total = (long) 0;
		Map<String, GsmCallMonthData> map = new HashMap();
		System.out.println(inputFile);
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
				//System.out.println(index + " " + total);
				//index++;				
			}
			
			
			//total++;
			
		}
		fc.writeMap(map);
//		Iterator iterator = map.entrySet().iterator();
//		while(iterator.hasNext())
//		{
//			Entry entry = (Entry) iterator.next();
//			GsmCall gc = (GsmCall) entry.getValue();
//			fc.writeLine(gc.toString());
//		}
		fg.close();
		fc.close();
	}
	
//	//处理bf_gather_sm_t
	private static void handleGsmSm(String inputFile, String outputFile, Boolean append) throws IOException
		{
			FileGetter fg = new FileGetter(inputpath + inputFile);
			FileCreater fc = new FileCreater(outputpath + outputFile, append);
			String s = "";
			Long index = (long) 0;
			Long total = (long) 0;
			Set set = new HashSet();
			Map<String, GsmSmMonthData> map = new HashMap();
			System.out.println(inputFile);
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
					//System.out.println(index + " " + total);
					//index++;				
				}
			}
			catch(Exception e){}
				//total++;
				
			}
			//写文件
			fc.writeMap(map);

			fg.close();
			fc.close();
		}
		
	//处理l_pay_fee.txt
	private static void handlePayFee(String inputFile, String outputFile, Boolean append) throws IOException,  ParseException
	{
		FileGetter fg = new FileGetter(inputpath + inputFile);
		FileCreater fc = new FileCreater(outputpath + outputFile, append);
		String s = "";
		Map<String,PayFee> map = new HashMap();
		while((s=fg.readLine())!=null)
		{
			String[] line = s.split(SelectIndex.SPLITER);
			if(line[SelectIndex.PAY_FEE_SERVICEKIND].equals("9"))
			{
				String date = DateParser.parse(line[SelectIndex.PAY_FEE_FEEDATE]);
				String key = line[SelectIndex.PAY_FEE_USERID] + "-" + date;
				if(map.containsKey(key))
				{
					map.get(key).addFee(line);
				}
				else
				{
					PayFee pf = new PayFee(line);
					map.put(key, pf);
				}
			}
			else
				continue;
		}
		
		fc.writeMap(map);
		fg.close();
		fc.close();
	}
	
	//处理bf_gsm_call_merge_format_new 处理打电话的人的个数
	private static void handleGsmCallMerge(String inputFile, String outputFile, Boolean append) throws IOException
	{
		FileGetter fg = new FileGetter(inputpath + inputFile);
		FileCreater fc = new FileCreater(outputpath + outputFile, append);
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
			Integer friend1 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_1])*100;
			Integer friend2 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_2])*100;
			Integer friend3 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_3])*100;
			Integer friend4 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_4])*100;
			Integer friend5 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_5])*100;
			Integer friend6 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_6])*100;
			
			Integer during1 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_1])*100;
			Integer during2 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_2])*100;
			Integer during3 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_3])*100;
			Integer during4 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_4])*100;
			Integer during5 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_5])*100;
			Integer during6 = Integer.valueOf(line[SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_6])*100;
			
			during1 *= friend1;
			during2 *= friend2;
			during3 *= friend3;
			during4 *= friend4;
			during5 *= friend5;
			during6 *= friend6;
			
			duringTotal = during1+ during2 + during3 + during4 +during5 + during6;
			if(friendTotal > 0)
			{
				friend1 /= friendTotal;
				friend2 /= friendTotal;
				friend3 /= friendTotal;
				friend4 /= friendTotal;
				friend5 /= friendTotal;
				friend6 /= friendTotal;
			}
			if(duringTotal > 0)
			{
				during1 /= duringTotal;
				during2 /= duringTotal;
				during3 /= duringTotal;
				during4 /= duringTotal;
				during5 /= duringTotal;
				during6 /= duringTotal;
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
