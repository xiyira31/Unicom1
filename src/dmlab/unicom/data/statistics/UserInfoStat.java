package dmlab.unicom.data.statistics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import dmlab.unicom.data.file.FileCreater;
import dmlab.unicom.data.file.FileGetter;
import dmlab.unicom.data.handle.GsmCallMergeHandler;
import dmlab.unicom.data.handle.Handler;
import dmlab.unicom.data.handle.StatChangeRateHandler;
import dmlab.unicom.data.handle.StatClassifyGroupHandler;
import dmlab.unicom.data.handle.StatCountTypeHandler;
import dmlab.unicom.data.structer.ClassifyGroup;
import dmlab.unicom.data.structer.OffRate;
import dmlab.unicom.data.structer.ChangeRate;
import dmlab.unicom.data.structer.ServingName;
import dmlab.unicom.data.util.SelectIndex;

public class UserInfoStat {
	
	public static void main(String[] args) throws IOException, ParseException {
		//statOffRate("l_user_info_new.txt","offRate_vipname.txt",SelectIndex.USER_INFO_VIPNAME,false);
		// TODO Auto-generated method stub
		//statCountType("l_user_info_new.txt","statCustLevelType.txt",26,false);
		//statCountType("l_user_info_new.txt","statServingNameType.txt",SelectIndex.USER_INFO_SERVINGNAME,false);
		//statCountType("l_user_info_new.txt","statName.txt",SelectIndex.USER_INFO_FIRSTNAME,false);
		//statOffRate("l_user_info_new.txt","offRate_area.txt",SelectIndex.USER_INFO_AREANAME,false);
		//statOffRate("l_user_info_new.txt","offRate_favourname.txt",SelectIndex.USER_INFO_FAVOURNAME,false);
		//statOffRate("l_user_info_new.txt","offRate_payname.txt",SelectIndex.USER_INFO_PAYNAME,false);
		//statOffRateGatherFavour("l_user_info_new.txt","offRate_favourname_gather.txt",SelectIndex.USER_INFO_FAVOURNAME,false);
//		statChangeRate("gsm_call.txt","gsm_call_change_rate_simple.txt",0,1,2,
//				false);	
//		classifyGroup("gsm_call_change_rate_simple.txt","classify_gsm_call_change_rate_simple.txt",
//		SelectIndex.CLASSIFY_GROUP_CHANGERATE,SelectIndex.CLASSIFY_GROUP_IFVAILD,
//		SelectIndex.CLASSIFY_GROUPS_FEE,false);
		//statCountType("bf_gsm_sm_call_2012.txt","countUseridGsmSm2012.txt",SelectIndex.GSM_SM_CALL_USERID,false);
		//statGsmSm("gsm_sm.txt","gsm_sm_change_rate.txt",false);
		//statOffRateGatherFavour("l_user_info_new.txt","offRateCustGroupName.txt",SelectIndex.USER_INFO_CUSTGROUPNAME,false);
//		statChangeRate("clear_gather_fee_2012.txt","gather_fee_change_rate_calltime.txt",
//				SelectIndex.CLEARED_GATHER_FEE_USERID,SelectIndex.CLEARED_GATHER_FEE_FEEDATE,
//				SelectIndex.CLEARED_GATHER_FEE_CALLTIME,false);
//		statChangeRate("clear_gather_fee_2012.txt","gather_fee_change_rate_fee.txt",
//				SelectIndex.CLEARED_GATHER_FEE_USERID,SelectIndex.CLEARED_GATHER_FEE_FEEDATE,
//				SelectIndex.CLEARED_GATHER_FEE_FEE,false);
//		classifyGroup("gather_fee_change_rate_fee.txt","classify_gather_fee_change_rate_fee.txt",
//				SelectIndex.CLASSIFY_GROUP_CHANGERATE,SelectIndex.CLASSIFY_GROUP_IFVAILD,
//				SelectIndex.CLASSIFY_GROUPS_FEE,false);
//		statChangeRate("clear_gather_fee_2012.txt","gather_fee_change_rate_calltime.txt",
//				SelectIndex.CLEARED_GATHER_FEE_USERID,SelectIndex.CLEARED_GATHER_FEE_FEEDATE,
//				SelectIndex.CLEARED_GATHER_FEE_CALLTIME,false);
//		classifyGroup("gather_fee_change_rate_calltime.txt","classify_gather_fee_change_rate_calltime.txt",
//				SelectIndex.CLASSIFY_GROUP_CHANGERATE,SelectIndex.CLASSIFY_GROUP_IFVAILD,
//				SelectIndex.CLASSIFY_GROUPS_FEE,false);
//		statChangeRate("pay_fee.txt","stat_pay_fee.txt",
//		0,1,
//		2,false);
//		classifyGroup("stat_pay_fee.txt","classify_stat_pay_fee.txt",
//				SelectIndex.CLASSIFY_GROUP_CHANGERATE,SelectIndex.CLASSIFY_GROUP_IFVAILD,
//				SelectIndex.CLASSIFY_GROUPS_FEE,false);
//		classifyGroup("bf_gsm_call_merge_format_with_rate.txt",
//				"classify_bf_gsm_call_merge_format_with_rate_friend1.txt",
//				SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_1,SelectIndex.GSM_CALL_MERGE_FORMAT_IFVAILD,
//				SelectIndex.CLASSIFY_GROUPS_POSITIVE,false);
//		classifyGroup("bf_gsm_call_merge_format_with_rate.txt",
//				"classify_bf_gsm_call_merge_format_with_rate_friend2.txt",
//				SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_2,SelectIndex.GSM_CALL_MERGE_FORMAT_IFVAILD,
//				SelectIndex.CLASSIFY_GROUPS_POSITIVE,false);
//		classifyGroup("bf_gsm_call_merge_format_with_rate.txt",
//				"classify_bf_gsm_call_merge_format_with_rate_friend3.txt",
//				SelectIndex.GSM_CALL_MERGE_FORMAT_FRIEND_3,SelectIndex.GSM_CALL_MERGE_FORMAT_IFVAILD,
//				SelectIndex.CLASSIFY_GROUPS_POSITIVE,false);
//		classifyGroup("bf_gsm_call_merge_format_with_rate.txt",
//			"classify_bf_gsm_call_merge_format_with_rate_during1.txt",
//			SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_1,SelectIndex.GSM_CALL_MERGE_FORMAT_IFVAILD,
//			SelectIndex.CLASSIFY_GROUPS_POSITIVE,false);
//		classifyGroup("bf_gsm_call_merge_format_with_rate.txt",
//			"classify_bf_gsm_call_merge_format_with_rate_during2.txt",
//			SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_2,SelectIndex.GSM_CALL_MERGE_FORMAT_IFVAILD,
//			SelectIndex.CLASSIFY_GROUPS_POSITIVE,false);
//		classifyGroup("bf_gsm_call_merge_format_with_rate.txt",
//			"classify_bf_gsm_call_merge_format_with_rate_during3.txt",
//			SelectIndex.GSM_CALL_MERGE_FORMAT_DURING_3,SelectIndex.GSM_CALL_MERGE_FORMAT_IFVAILD,
//			SelectIndex.CLASSIFY_GROUPS_POSITIVE,false);
//		classifyGroup("user_info_alivetime.txt",
//			"classify_user_info_alivetime.txt",
//			4,1,
//			SelectIndex.CLASSIFY_GROUPS_ALIVE,false);
//		Handler handler = new StatChangeRateHandler("gsm_call_new.txt","每月通话变化率.txt",0,1,3);
		
//		GsmCallMergeHandler handler = new GsmCallMergeHandler("bf_gsm_call_201205_format_new.txt","201205内外网数据统计.txt");
//		handler.handleNew();
//		StatClassifyGroupHandler handler1 = new StatClassifyGroupHandler(
//				"201205内外网数据统计.txt","201205内外网数据统计_内网朋友分组.txt",1,7,SelectIndex.CLASSIFY_GROUPS_POSITIVE);
//		handler1.handle();
//		
//		StatClassifyGroupHandler handler = new StatClassifyGroupHandler(
//				"201205内外网数据统计.txt","201205内外网数据统计_外网朋友分组.txt",2,7,SelectIndex.CLASSIFY_GROUPS_POSITIVE);
//		handler.handle();
//		Handler handler = new StatCountTypeHandler("201205内外网数据统计.txt","201205内外网数据统计_离网用户数.txt",7);
//		handler.handle();
//		StatCountTypeHandler sctHandler = new StatCountTypeHandler("l_user_info_new.txt","客户级别人数.txt",26);
//		sctHandler.handle();
	}
	
	public static void statCountType(String inputFile, String outputFile,Integer countType, Boolean append) throws IOException
	{
		FileGetter fg = new FileGetter(SelectIndex.INPUTPATH + inputFile);
		FileCreater fc = new FileCreater(SelectIndex.OUTPUTPATH + outputFile, append);
		
		Map<String, ServingName> map = new HashMap();
		String s = null;
		Integer index = 0;
		while((s = fg.readLine()) !=null)
		{
			index++;
			try{
			String[] as = s.split(SelectIndex.SPLITER);
			String servingName = as[countType];
			if(map.containsKey(servingName))
			{				
				map.get(servingName).increace();
				//System.out.println(map.get(servingName).getCount());
			}
			else
			{
				ServingName serving = new ServingName(servingName,1);
				map.put(servingName,serving);
			}		
			}
			catch(Exception e)
			{}
		}
		System.out.println(index);
		fc.writeMap(map);

		fg.close();
		fc.close();
	}
	
	public static void statOffRate(String inputFile, String outputFile,Integer offType, Boolean append) throws IOException
	{
		FileGetter fg = new FileGetter(SelectIndex.INPUTPATH + inputFile);
		FileCreater fc = new FileCreater(SelectIndex.OUTPUTPATH + outputFile, append);
		
		Map<String, OffRate> map = new HashMap();
		String s = null;

		while((s = fg.readLine()) !=null)
		{
			
			String[] as = s.split(SelectIndex.SPLITER);
			String servingName = as[offType];
			if(map.containsKey(servingName))
			{		
				if(as[SelectIndex.USER_INFO_IFVALID].equals("1"))
				{
					map.get(servingName).totalIncreace();
				}
				else
				{
					map.get(servingName).offCountIncreace();
				}
				
			}
			else
			{
				OffRate serving = new OffRate(servingName,1);
				map.put(servingName,serving);
			}			
		}
		
		fc.writeMap(map);

		fg.close();
		fc.close();
	}
	
	public static void statOffRateGatherFavour(String inputFile, String outputFile,Integer offType, Boolean append) throws IOException
	{
		FileGetter fg = new FileGetter(SelectIndex.INPUTPATH + inputFile);
		FileCreater fc = new FileCreater(SelectIndex.OUTPUTPATH + outputFile, append);
		
		Map<String, OffRate> map = new HashMap();
		String s = null;
		List<String> list = SelectIndex.custGroupName();
		for(Integer index = 0; index<list.size();index++)
		{
			OffRate serving = new OffRate(list.get(index),1);
			map.put(list.get(index), serving);
		}
		
		while((s = fg.readLine()) !=null)
		{			
			String[] as = s.split(SelectIndex.SPLITER);
			String servingName = as[offType];
			Boolean other = true;
			Iterator iterator = map.entrySet().iterator();
			while(iterator.hasNext())
			{
				Entry entry = (Entry) iterator.next();
				String key = (String) entry.getKey();
				OffRate value = (OffRate) entry.getValue();
				
				if(servingName.indexOf(key)>-1)
				{
					if(as[SelectIndex.USER_INFO_IFVALID].equals("1"))
					{
						map.get(key).totalIncreace();
					}
					else
					{
						map.get(key).offCountIncreace();
					}
					other = false;
					break;
				}				
			}
			if(other)
			{
				if(as[SelectIndex.USER_INFO_IFVALID].equals("1"))
				{
					map.get(SelectIndex.USER_INFO_CUSTGROUPNAME1).totalIncreace();
				}
				else
				{
					map.get(SelectIndex.USER_INFO_CUSTGROUPNAME1).offCountIncreace();
				}
			}
		}
		
		fc.writeMap(map);

		fg.close();
		fc.close();
	}
	
	public static void statChangeRate(String inputFile, String outputFile, Integer userIndex,
			Integer monthIndex,Integer addIndex, Boolean append) throws IOException
	{
		FileGetter fg = new FileGetter(SelectIndex.INPUTPATH + inputFile);
		FileCreater fc = new FileCreater(SelectIndex.OUTPUTPATH + outputFile, append);
		
		Map<String, ChangeRate> map = new HashMap();
		String s = null;
		while((s = fg.readLine()) !=null)
		{
			
			String[] as = s.split(SelectIndex.SPLITER);
			String servingName = as[userIndex];
			if(map.containsKey(servingName))
			{				
				map.get(servingName).addMonthData(
						Integer.valueOf(as[monthIndex]),
								Integer.valueOf(as[addIndex]));
			}
			else
			{
				ChangeRate serving = 
						new ChangeRate(servingName,Integer.valueOf(as[monthIndex])
								, Integer.valueOf(as[addIndex]));
				map.put(servingName,serving);
			}
		}
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
		
		Iterator iterator = map.entrySet().iterator();
		while(iterator.hasNext())
		{
			Entry entry = (Entry) iterator.next();
			String key = (String) entry.getKey();
			ChangeRate value = (ChangeRate) entry.getValue();
			if(isVaildMap.containsKey(key))
			{
				value.setIsVaild(isVaildMap.get(key));
			}
		}
		fc.writeMap(map);
		userinfofg.close();
		fg.close();
		fc.close();
	}

	public static void statGsmSm(String inputFile, String outputFile, Boolean append) throws IOException{
		FileGetter fg = new FileGetter(SelectIndex.INPUTPATH + inputFile);
		FileCreater fc = new FileCreater(SelectIndex.OUTPUTPATH + outputFile, append);
		
		Map<String, ChangeRate> map = new HashMap();
		String s = null;
		while((s = fg.readLine()) !=null)
		{
			try{
			String[] as = s.split(SelectIndex.SPLITER);
			String servingName = as[0];
			if(map.containsKey(servingName))
			{				
				map.get(servingName).addMonthData(Integer.valueOf(as[1]),Integer.valueOf(as[2]));
			}
			else
			{
				ChangeRate serving = 
						new ChangeRate(servingName,Integer.valueOf(as[1])
								, Integer.valueOf(as[2]));
				map.put(servingName,serving);
			}
			}
			catch(Exception e)
			{}
		}
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
		
		Iterator iterator = map.entrySet().iterator();
		while(iterator.hasNext())
		{
			Entry entry = (Entry) iterator.next();
			String key = (String) entry.getKey();
			ChangeRate value = (ChangeRate) entry.getValue();
			if(isVaildMap.containsKey(key))
			{
				value.setIsVaild(isVaildMap.get(key));
			}
		}
		fc.writeMap(map);

		fg.close();
		fc.close();
	}
	//处理好的数据用来分类
	public static void classifyGroup(String inputFile, String outputFile, Integer rateCol, 
			Integer ifVaild, Integer[] groupList, Boolean append) throws IOException
	{
		FileGetter fg = new FileGetter(SelectIndex.INPUTPATH + inputFile);
		FileCreater fc = new FileCreater(SelectIndex.OUTPUTPATH + outputFile, append);
		
		List<ClassifyGroup> list = groupedList(groupList);
		ClassifyGroup cg = new ClassifyGroup();
		list.add(cg);
		Integer groupSize = list.size();
		String s =null;
		while((s=fg.readLine())!=null)
		{
			String[] line = s.split(SelectIndex.SPLITER);
			Integer rate = null;
			try{
				rate = Integer.valueOf(line[rateCol]);
			}catch(Exception e){
				rate = null;
			}
					
			
				for(Integer index = 0;index<groupSize;index++)
				{
						if(list.get(index).addCount(rate,line[ifVaild]))
						{
							break;
						}					
				}			
		}
		
		for(Integer index = 0;index<groupSize;index++)
		{
			fc.writeLine(list.get(index).toString());
		}
		fg.close();
		fc.close();
	}
	private static List<ClassifyGroup> groupedList(Integer[] groups)
	{
		Integer size = groups.length;
		List<ClassifyGroup> list = new ArrayList();
		for(Integer index=0;index<size;index++)
		{
			if(index == 0)
			{
				ClassifyGroup cg = new ClassifyGroup(null,groups[index]);
				list.add(cg);
			}
			else
			{
				ClassifyGroup cg = new ClassifyGroup(groups[index-1],groups[index]);
				list.add(cg);
			}				
		}
		list.add(new ClassifyGroup(groups[size-1],null));
		return list;
	}
}
