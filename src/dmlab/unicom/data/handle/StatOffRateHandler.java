package dmlab.unicom.data.handle;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import dmlab.unicom.data.structer.OffRate;
import dmlab.unicom.data.util.DateParser;
import dmlab.unicom.data.util.SelectIndex;

public class StatOffRateHandler extends Handler{
	
	private Integer offType;

	public StatOffRateHandler(String input, String output, Integer offType){
		super(input,output);
		this.offType = offType;
	}
	public StatOffRateHandler(String input, String output,Boolean append, Integer offType){
		super(input,output,append);
		this.offType = offType;
	}
	
	@Override
	public void handle() throws IOException, ParseException {
		// TODO Auto-generated method stub
		Map<String, OffRate> map = new HashMap();
		String s = null;
		Date limitDate = DateParser.parseDate("01-01月-12");
		UserInfoHandler userinfo = new UserInfoHandler();
		Map validMap = userinfo.vaildMapWithLimit(limitDate);		

		while((s = fg.readLine()) !=null)
		{			
			String[] as = s.split(SelectIndex.SPLITER);
			String userid = as[SelectIndex.USER_INFO_USERID];
			String servingName = as[offType];
			if(map.containsKey(servingName))
			{		
				Integer ifValid = (Integer) validMap.get(userid);
				if(ifValid == null)
					continue;
				if(ifValid == 1)
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

	
}
