package dmlab.unicom.data.structer;

import java.text.ParseException;

import dmlab.unicom.data.util.DateParser;
import dmlab.unicom.data.util.SelectIndex;

public class PayFee {	
	private String userid = "";
	private String date = "";
	private Double fee = 0.0;
	
	public PayFee(){}
	
	public PayFee(String[] line) throws ParseException
	{
		userid = line[SelectIndex.PAY_FEE_USERID];
		date = DateParser.parse(line[SelectIndex.PAY_FEE_FEEDATE]);
		fee = Double.valueOf(line[SelectIndex.PAY_FEE_FEE]);
	}
	
	public void addFee(String[] line)
	{
		fee += Double.valueOf(line[SelectIndex.PAY_FEE_FEE]);
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(userid).append(SelectIndex.SPLITER).append(date)
		  .append(SelectIndex.SPLITER).append(fee.intValue());
		return sb.toString();
	}
}
