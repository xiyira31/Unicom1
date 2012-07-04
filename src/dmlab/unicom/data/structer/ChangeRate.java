package dmlab.unicom.data.structer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import dmlab.unicom.data.util.SelectIndex;

public class ChangeRate {

	private String userid;
	private Integer maxDate;
	private Integer minDate;
	private Integer isVaild = -1;
	private Map<Integer, Integer> map = new HashMap();
	
	public ChangeRate()
	{}
	
	public ChangeRate(String userid,Integer date,Integer count)
	{
		this.userid = userid;
		this.maxDate = date;
		this.minDate = date;
		map.put(date, count);
	}
	
	public Boolean isFull()
	{
		return map.size()> SelectIndex.COMPARE_MONTH ? true:false;
	}

	//-1表示没有标出，0表示非法，1表示合法
	public void setIsVaild(Integer isVaild)
	{
		this.isVaild = isVaild;
	}
	
	public void addMonthData(Integer date, Integer count)
	{
		if(date>maxDate)
		{
			this.maxDate = date;
			if(isFull())
				removeMin();
			map.put(date, 
					count);
			return;
		}
		if(!isFull())
		{
			map.put(date, 
					count);
			if(date<minDate)
				minDate = date;
			return;
		}
		if(isFull() && date<this.maxDate && date>this.minDate)
		{
			removeMin();
			minDate = date;
			map.put(date, 
					count);
		}
	}
	
	private void removeMin()
	{
		map.remove(minDate);
		Entry entry = map.entrySet().iterator().next();
		minDate = (Integer) entry.getKey();
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(userid).append(SelectIndex.SPLITER)
			.append(isVaild.toString()).append(SelectIndex.SPLITER);
		Iterator iterator =  map.entrySet().iterator();
		Integer firstKey = maxDate;
		Integer firstValue = map.get(maxDate);
		sb.append(firstKey).append(SelectIndex.SPLITER);
		sb.append(firstValue).append(SelectIndex.SPLITER);
		Integer sumRate = 0;
		List<Integer> list = new ArrayList();
		while(iterator.hasNext())
		{
			Entry entry = (Entry) iterator.next();
			Integer key = (Integer) entry.getKey();
			Integer value = (Integer) entry.getValue();
			if(!key.equals(maxDate) && value != 0)
			{
				Integer rate = (firstValue - value)*100/value;
				//输出对应月的变化率
//				sb.append(key).append(SelectIndex.SPLITER)
//					.append(rate.toString()+"%").append(SelectIndex.SPLITER);
				sumRate += rate;
				list.add(rate);
			}			
		}
		if(list.size()>0)
		{
			Integer avgRate = sumRate/list.size();
			sb.append(avgRate.toString()+"");
		}

		return sb.toString();
	}
	
}
