package dmlab.unicom.data.handle;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import dmlab.unicom.data.structer.ServingName;
import dmlab.unicom.data.util.DateParser;
import dmlab.unicom.data.util.SelectIndex;

/*
 * StatCountTypeHandler：记录每一个变量的个数，并输出成文件
 * 
 * 无需固定格式，需要表明统计哪一列
 * 
 * @param input：输入文件路径与名字
 * @param output：输出文件路径与名字
 * @param countType:需要统计个数的列的序列号
 * @param append：是否文件是否连续写入
 *  
 * 输出格式 ：正常服务,62502；第一个是计数列的一个标量，第二个是个数
 * 
 */

public class StatCountTypeHandler extends Handler{

	private Integer countType;
	
	public StatCountTypeHandler(String input, String output, Integer countType){
		super(input,output);
		this.countType = countType;
	}
	public StatCountTypeHandler(String input, String output, Integer countType, Boolean append){
		super(input,output,append);
		this.countType = countType;
	}
	
	public void handleMonth() throws IOException, ParseException
	{
		Map<String, ServingName> map = new HashMap();
		String s = null;
		while((s = fg.readLine()) != null)
		{
			String[] as = s.split(SelectIndex.SPLITER);
			String sDate = as[countType];
			if(sDate.equals(""))
				continue;
			sDate = DateParser.parse(sDate);
			if(map.containsKey(sDate))
			{
				map.get(sDate).increace();
			}
			else
			{
				ServingName sn = new ServingName(sDate,1);
				map.put(sDate, sn);
			}
		}
		fc.writeMap(map);
		fc.close();
		fg.close();
	}
	
	@Override
	public void handle() throws IOException {
		// TODO Auto-generated method stub
		Map<String, ServingName> map = new HashMap();
		String s = null;
		while((s = fg.readLine()) !=null)
		{
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
		fc.writeMap(map);

		fg.close();
		fc.close();
	}

}
