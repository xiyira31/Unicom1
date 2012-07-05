package dmlab.unicom.data.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectIndex {
	
	public static final String SPLITER = ",";
	public final static String INPUTPATH="D:\\HothandPotato\\阿坝联通\\新建文件夹 (2)\\";
	public final static String OUTPUTPATH="D:\\HothandPotato\\阿坝联通\\新建文件夹 (2)\\output\\";
	public final static Integer COMPARE_MONTH = 1;
	public final static String nDate = "31-05月-12";
	
	//用户信息表 l_user_info_new
	public static final Integer USER_INFO_SERVICEID = 0;
	public static final Integer USER_INFO_USERID = 6;
	public static final Integer USER_INFO_FIRSTNAME = 7;
	public static final Integer USER_INFO_AREANAME = 3;
	public static final Integer USER_INFO_FAVOURNAME = 16;
	public static final Integer USER_INFO_PAYNAME = 22;
	public static final Integer USER_INFO_CUSTLEVEL = 25;
	public static final Integer USER_INFO_CUSTGROUPNAME = 24;
	public static final Integer USER_INFO_VIPNAME = 27;
	public static final Integer USER_INFO_APPLYDATE = 8;
	public static final Integer USER_INFO_STOPDATE = 18;
	public static final Integer USER_INFO_INVALIDDATE = 19;
	public static final Integer USER_INFO_SERVINGNAME = 10;
	public static final Integer USER_INFO_IFVALID = 29;
	
	public static final String USER_INFO_FAVOURNAME1 = "新势力";
	public static final String USER_INFO_FAVOURNAME2 = "世界风";
	public static final String USER_INFO_FAVOURNAME3 = "省内沃家庭";
	public static final String USER_INFO_FAVOURNAME4 = "如意通小康";
	public static final String USER_INFO_FAVOURNAME5 = "如意通吉祥";
	public static final String USER_INFO_FAVOURNAME6 = "如意通畅听";
	public static final String USER_INFO_FAVOURNAME7 = "其他";
	public static final String USER_INFO_FAVOURNAME8 = "如意通G畅听";
	public static final String USER_INFO_FAVOURNAME9 = "WCDMA(3G)";
	public static final String USER_INFO_FAVOURNAME12 = "OCS_";
	public static final String USER_INFO_FAVOURNAME13 = "3G iPhone";
	public static final String USER_INFO_FAVOURNAME14 = "3G";
	
	//public static final String[] USER_INFO_UNREALNAME ="";

	public static final String USER_INFO_CUSTGROUPNAME1 = "无定义";
	public static final String USER_INFO_CUSTGROUPNAME2 = "公众客户城市";
	public static final String USER_INFO_CUSTGROUPNAME3 = "商务客户";
	public static final String USER_INFO_CUSTGROUPNAME4 = "公众客户农村";
	public static final String USER_INFO_CUSTGROUPNAME5 = "政企客户";

	//处理bf_gather_fee_t
	public static final Integer GATHER_FEE_SERVICEID = 0;
	public static final Integer GATHER_FEE_USERID = 1;
	public static final Integer GATHER_FEE_FEEDATE = 4;
	public static final Integer GATHER_FEE_CALLTIMES = 11;
	public static final Integer GATHER_FEE_FEE1 = 13;
	public static final Integer GATHER_FEE_FEE2 = 14;
	public static final Integer GATHER_FEE_FEE3 = 15;
	public static final Integer GATHER_FEE_FEE4 = 16;
	public static final Integer GATHER_FEE_FEE11 = 17;
	public static final Integer GATHER_FEE_FEE12 = 18;
	public static final Integer GATHER_FEE_FEE13 = 19;
	public static final Integer GATHER_FEE_FEE14 = 20;
	
	//处理GSM_CALL
	public static final Integer GSM_CALL_USERID = 0;
	public static final Integer GSM_CALL_FEEDATE = 5;
	public static final Integer GSM_CALL_DURATION = 10;
	
	//处理处理好的文件gsm_call
	public static final Integer CLEARED_GSM_CALL_USERID = 0;
	public static final Integer CLEARED_GSM_CALL_FEEDATE = 1;
	public static final Integer CLEARED_GSM_CALL_DURATION = 2;
	
	//处理bf_gsm_sm_call
	public static final Integer GSM_SM_CALL_USERID = 5;
	public static final Integer GSM_SM_CALL_FEEDATE = 56;
//	public static final Integer GSM_SM_CALL_USERID = 5;
	
	public static final Integer CLEARED_GATHER_FEE_USERID = 0;
	public static final Integer CLEARED_GATHER_FEE_FEEDATE = 1;
	public static final Integer CLEARED_GATHER_FEE_CALLTIME = 2;
	public static final Integer CLEARED_GATHER_FEE_FEE = 3;
	
	//处理I_pay_fee
	public static final Integer PAY_FEE_SERVICEKIND = 0;
	public static final Integer PAY_FEE_USERID = 3;
	public static final Integer PAY_FEE_FEEDATE = 4;
	public static final Integer PAY_FEE_FEE = 5;
	
	//分类处理好的数据
	public static final Integer CLASSIFY_GROUP_USERID = 0;
	public static final Integer CLASSIFY_GROUP_IFVAILD = 1;
	public static final Integer CLASSIFY_GROUP_LASTMONTH = 2;
	public static final Integer CLASSIFY_GROUP_LASTCOUNT = 3;
	public static final Integer CLASSIFY_GROUP_CHANGERATE = 4;
	
	//bf_gsm_call_merge_format_new
	public static final Integer GSM_CALL_MERGE_FORMAT_USERID = 0;
	public static final Integer GSM_CALL_MERGE_FORMAT_FRIEND_TOTAL= 1;
	public static final Integer GSM_CALL_MERGE_FORMAT_FRIEND_1= 2;
	public static final Integer GSM_CALL_MERGE_FORMAT_FRIEND_2= 3;
	public static final Integer GSM_CALL_MERGE_FORMAT_FRIEND_3= 4;
	public static final Integer GSM_CALL_MERGE_FORMAT_FRIEND_4= 5;
	public static final Integer GSM_CALL_MERGE_FORMAT_FRIEND_5= 6;
	public static final Integer GSM_CALL_MERGE_FORMAT_FRIEND_6= 7;
	public static final Integer GSM_CALL_MERGE_FORMAT_DURING_TOTAL= 8;
	public static final Integer GSM_CALL_MERGE_FORMAT_DURING_1= 9;
	public static final Integer GSM_CALL_MERGE_FORMAT_DURING_2= 10;
	public static final Integer GSM_CALL_MERGE_FORMAT_DURING_3= 11;
	public static final Integer GSM_CALL_MERGE_FORMAT_DURING_4= 12;
	public static final Integer GSM_CALL_MERGE_FORMAT_DURING_5= 13;
	public static final Integer GSM_CALL_MERGE_FORMAT_DURING_6= 14;
	public static final Integer GSM_CALL_MERGE_FORMAT_IFVAILD = 15;
	
	//bf_gsm_call_201205_format_new
	public static final Integer GSM_CALL_FORMAT_NEW_USERID = 0;
	public static final Integer GSM_CALL_FORMAT_NEW_IN_FRIEND = 1;
	public static final Integer GSM_CALL_FORMAT_NEW_OUT_FRIEND = 2;
	public static final Integer GSM_CALL_FORMAT_NEW_IN_CALLTIME = 3;
	public static final Integer GSM_CALL_FORMAT_NEW_OUT_CALLTIME = 4;
	public static final Integer GSM_CALL_FORMAT_NEW_IN_DURTION = 5;
	public static final Integer GSM_CALL_FORMAT_NEW_OUT_DURTION = 6;
	
	//分组，按照分组
	public static final Integer[] CLASSIFY_GROUPS_FEE  = 
		{-100,-90,-80,-70,-60,-50,-40,-30,-20,-10,0,10,20,30,40,50,100,200,300,400,500};
	public static final Integer[] CLASSIFY_GROUPS_POSITIVE  = 
		{0,10,20,30,40,50,60,70,80,90,100};
	public static final Integer[] CLASSIFY_GROUPS_ALIVE  = 
		{0,3,6,9,12,15,18,21,24,27,30,33,36,39,42,45,48,51,54,57,60,63,66,69,72,75,78,81,
		84,87,90,93,96,99,102,105,108,111,114,117,120};
	
	public static List<String> custGroupName()
	{
		List<String> list = new ArrayList<String>();
		list.add(USER_INFO_CUSTGROUPNAME1);
		list.add(USER_INFO_CUSTGROUPNAME2);
		list.add(USER_INFO_CUSTGROUPNAME3);
		list.add(USER_INFO_CUSTGROUPNAME4);
		
		list.add(USER_INFO_CUSTGROUPNAME5);
		return list;
	}
	
	public static List<String> favourName()
	{
		List<String> list = new ArrayList<String>();
		list.add(USER_INFO_FAVOURNAME1);
		list.add(USER_INFO_FAVOURNAME2);
		list.add(USER_INFO_FAVOURNAME3);
		list.add(USER_INFO_FAVOURNAME4);
		
		list.add(USER_INFO_FAVOURNAME7);
		list.add(USER_INFO_FAVOURNAME8);
		list.add(USER_INFO_FAVOURNAME9);

		
		list.add(USER_INFO_FAVOURNAME13);
		list.add(USER_INFO_FAVOURNAME14);
		list.add(USER_INFO_FAVOURNAME12);
		list.add(USER_INFO_FAVOURNAME5);
		list.add(USER_INFO_FAVOURNAME6);
		return list;
	}
	
	
	public static List<Integer> userInfo()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(USER_INFO_SERVICEID);
		list.add(USER_INFO_USERID);
		list.add(USER_INFO_FIRSTNAME);
		list.add(USER_INFO_AREANAME);
		list.add(USER_INFO_FAVOURNAME);
		list.add(USER_INFO_PAYNAME);
		list.add(USER_INFO_CUSTLEVEL);
		list.add(USER_INFO_CUSTGROUPNAME);
		list.add(USER_INFO_VIPNAME);
		list.add(USER_INFO_APPLYDATE);
		list.add(USER_INFO_STOPDATE);
		list.add(USER_INFO_INVALIDDATE);
		return list;
	}
	
	public static List<Integer> userInfoAliveTime()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(USER_INFO_SERVICEID);
		list.add(USER_INFO_USERID);
		list.add(USER_INFO_APPLYDATE);
		list.add(USER_INFO_INVALIDDATE);
		return list;
	}
	
	public static List<Integer> gatherFee()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(GATHER_FEE_FEE1);
		list.add(GATHER_FEE_FEE2);
		list.add(GATHER_FEE_FEE3);
		list.add(GATHER_FEE_FEE4);
		list.add(GATHER_FEE_FEE11);
		list.add(GATHER_FEE_FEE12);
		list.add(GATHER_FEE_FEE13);
		list.add(GATHER_FEE_FEE14);
		return list;
	}
	
	public static Set<String> offNetType()
	{
		Set<String> set = new HashSet<String>();
		set.add("用户退网");
		set.add("退网停机");
		set.add("强拆返销");
		set.add("强拆销号");
		return set;
	}
}
