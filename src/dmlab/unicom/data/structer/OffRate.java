package dmlab.unicom.data.structer;

public class OffRate {

	private Integer total = 1;
	private Integer offCount = 0;
	private String name;
	
	public OffRate(){}
	
	public OffRate(String name, Integer total){
		this.total = total;
		this.name = name;
	}
	
	public void totalIncreace()
	{
		total++;
	}
	
	public void offCountIncreace()
	{
		total++;
		offCount++;
	}
	
	public String toString()
	{
		
		Integer rate = (offCount*100)/total;
		return name+","+total.toString()+","+offCount.toString()+","+rate.toString()+"";
	}

}
