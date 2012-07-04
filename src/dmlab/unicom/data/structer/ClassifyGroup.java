package dmlab.unicom.data.structer;

import dmlab.unicom.data.util.SelectIndex;

public class ClassifyGroup {
	private Integer min;
	private Integer max;	
	private Integer count=0;
	private Integer total = 0;
	
	public ClassifyGroup(){}
	
	public ClassifyGroup(Integer min, Integer max){
		this.max = max;
		this.min = min;
	}
	
	public Boolean addCount(Integer value,String ifVaild)
	{
		Integer old = count;
		Boolean added = false;
;
			if(value == null)
			{
				if(min == null && max == null)
				{
					added = true;
				}
				if(added)
				{
					if(ifVaild.equals("0"))
						count++;
					addTotal();
				}				
				return added;
			}			
			try{
				if( min == null && max == null)
					added = true;
				else if(min == null && value < max)
					added = true;
				else if(max == null && value > min)
					added = true;
				else if(min == null || max == null)
					return false;
				else if(value>=min && value<max)
					added = true;
			}
			catch(Exception e)
			{
				System.out.println(min);
				System.out.println(max);
				System.out.println(value);
				System.exit(0);
			}	
			if(added)
			{
				if(ifVaild.equals("0"))
					count++;
				addTotal();
			}
		return added;
	}
	
	public void addTotal()
	{
		total++;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		if(min != null)
		{
			sb.append(min);
		}
		sb.append(SelectIndex.SPLITER);
		if(max!=null)
		{
			sb.append(max);
		}
		sb.append(SelectIndex.SPLITER);
		sb.append(count).append(SelectIndex.SPLITER);
		sb.append(total).append(SelectIndex.SPLITER);
		if(total != 0)
			sb.append(count*100/total);
		else
			sb.append(0);
		return sb.toString();
	}
}
