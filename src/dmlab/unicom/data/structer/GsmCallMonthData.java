package dmlab.unicom.data.structer;

import dmlab.unicom.data.util.SelectIndex;

public class GsmCallMonthData {

	private String userid = "";
	private String feedate = "";
	private Long duration;
	private Integer calltime = 1; // 创建时会就默认一个电话
	
	public GsmCallMonthData(){}
	
	public GsmCallMonthData(String[] line)
	{
		this.userid = line[SelectIndex.GSM_CALL_USERID];
		this.feedate = line[SelectIndex.GSM_CALL_FEEDATE];
		this.duration = Long.valueOf(line[SelectIndex.GSM_CALL_DURATION]);
	}
	
	public void addDuration(String[] line)
	{
		this.duration += Long.valueOf(line[SelectIndex.GSM_CALL_DURATION]);
		this.calltime++;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(userid).append(SelectIndex.SPLITER).append(feedate)
		  .append(SelectIndex.SPLITER).append(duration)
		  .append(SelectIndex.SPLITER).append(calltime);
		return sb.toString();
	}
}
