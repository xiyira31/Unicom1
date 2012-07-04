package dmlab.unicom.data.handle;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import dmlab.unicom.data.structer.PayFee;
import dmlab.unicom.data.util.DateParser;
import dmlab.unicom.data.util.SelectIndex;

/*
 * PayFeeHandler：默认处理l_pay_fee文件，合并费用
 * 
 * 输入是原始的l_pay_fee，整合每个用户每月的短信数量
 * 
 * @param input：输入文件路径与名字
 * @param output：输出文件路径与名字
 * @param append：是否文件是否连续写入
 * 
 * 输出格式：69204492,1105,150，分别是用户id，时间，缴费金额
 *  
 */

public class PayFeeHandler extends Handler{

	public PayFeeHandler(){
		super("l_pay_fee.txt","pay_fee.txt");
	}
	
	public PayFeeHandler(String input, String output){
		super(input,output);
	}
	public PayFeeHandler(String input, String output,Boolean append){
		super(input,output,append);
	}
	
	@Override
	public void handle() throws IOException {
		// TODO Auto-generated method stub
		String s = "";
		Map<String,PayFee> map = new HashMap();
		while((s=fg.readLine())!=null)
		{
			String[] line = s.split(SelectIndex.SPLITER);
			//只处理ServiceKind为9的数据
			if(line[SelectIndex.PAY_FEE_SERVICEKIND].equals("9"))
			{
				String date = null;
				try {
					date = DateParser.parse(line[SelectIndex.PAY_FEE_FEEDATE]);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//使用userid与date作为hash的key
				String key = line[SelectIndex.PAY_FEE_USERID] + "-" + date;
				if(map.containsKey(key))
				{
					map.get(key).addFee(line);
				}
				else
				{
					PayFee pf = null;
					try {
						pf = new PayFee(line);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					map.put(key, pf);
				}
			}
			else
				continue;
		}
		
		fc.writeMap(map);
		fg.close();
		fc.close();
	}

}
