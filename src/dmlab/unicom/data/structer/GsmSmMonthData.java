package dmlab.unicom.data.structer;

import dmlab.unicom.data.util.SelectIndex;

public class GsmSmMonthData {
	
	private String userid = "";
	private String feedate = "";
	private Integer duration;
	
	public GsmSmMonthData(){}
	
	public GsmSmMonthData(String[] line)
	{
		this.userid = line[SelectIndex.GSM_SM_CALL_USERID];
		this.feedate = line[SelectIndex.GSM_SM_CALL_FEEDATE];
		this.duration = 1;
	}
	
	public void addDuration(String[] line)
	{
		this.duration += 1;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(userid).append(SelectIndex.SPLITER).append(feedate)
		  .append(SelectIndex.SPLITER).append(duration);
		return sb.toString();
	}

}
