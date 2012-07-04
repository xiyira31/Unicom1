package dmlab.unicom.data.structer;

import java.util.List;

import dmlab.unicom.data.util.SelectIndex;

public class GatherFee {

	private String userid = "";
	private String date = "";
	private Double fee = 0.0;
	private Integer calltimes = 0;
	
	public GatherFee(){}
	
	public GatherFee(String[] line)
	{
		init(line);
	}
	
	public void init(String[] line)
	{
		userid = line[SelectIndex.GATHER_FEE_USERID];
		date = line[SelectIndex.GATHER_FEE_FEEDATE];
		calltimes = Integer.valueOf(line[SelectIndex.GATHER_FEE_CALLTIMES]);
		gatherFee(line);
		//fee += gatherFee(line);
	}
	
	public Boolean isNew()
	{
		return (userid.isEmpty() || userid == null);
	}
	
	public Boolean isSame(String[] line)
	{
		return (userid.equals(line[SelectIndex.GATHER_FEE_USERID]) && date.equals(line[SelectIndex.GATHER_FEE_FEEDATE]));
	}
	
	public void gatherFee(String[] line)
	{
		Double fee = 0.0;
		List<Integer> list = SelectIndex.gatherFee();
		for(Integer index = 0; index < list.size(); index++)
		{
			fee += Double.valueOf(line[list.get(index)]);			
		}
		this.calltimes += Integer.valueOf(line[SelectIndex.GATHER_FEE_CALLTIMES]);
		this.fee += fee;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(userid).append(SelectIndex.SPLITER).append(date)
		  .append(SelectIndex.SPLITER).append(calltimes)
		  .append(SelectIndex.SPLITER).append(fee.intValue());
		return sb.toString();
	}
}
