package dmlab.unicom.data.handle;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import dmlab.unicom.data.file.FileGetter;
import dmlab.unicom.data.structer.ChangeRate;
import dmlab.unicom.data.util.SelectIndex;

/*
 * StatChangeRateHandler：为了对多个月的某一项数据进行对比，写出这一个类
 * 
 * 输入信息必须要有用户id，月份（201105），月份数值
 * 输入时必须指明上述信息的index
 * 
 * @param input：输入文件路径与名字
 * @param output：输出文件路径与名字
 * @param userIndex:用户ID的index
 * @param monthIndex：月份的index
 * @param addIndex：累加项index
 * @param append：是否文件是否连续写入
 *  
 * 输出格式 ：正常服务,62502；第一个是计数列的一个标量，第二个是个数
 * 
 */

public class StatChangeRateHandler extends Handler{
	
	private Integer userIndex;
	private Integer monthIndex;
	private Integer addIndex;
	
	public StatChangeRateHandler(String input, String output, Integer userIndex
			, Integer monthIndex, Integer addIndex){
		super(input,output);
		this.userIndex = userIndex;
		this.monthIndex = monthIndex;
		this.addIndex = addIndex;
	}
	public StatChangeRateHandler(String input, String output, Integer userIndex
			, Integer monthIndex, Integer addIndex, Boolean append){
		super(input,output,append);
		this.userIndex = userIndex;
		this.monthIndex = monthIndex;
		this.addIndex = addIndex;
	}	

	@Override
	public void handle() throws IOException, ParseException {
		// TODO Auto-generated method stub
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

}
