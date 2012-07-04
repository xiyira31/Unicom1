package dmlab.unicom.data.handle;

import java.io.IOException;

import dmlab.unicom.data.structer.GatherFee;
import dmlab.unicom.data.util.SelectIndex;

/*
 * GatherFeeHandler：默认处理bf_gather_fee_t.txt文件，合并费用
 * 
 * 输入是原始的bf_gather_fee_t.txt
 * 合并的费用列为SelectIndex.gatherFee()返回的list
 * 
 * @param input：输入文件路径与名字
 * @param output：输出文件路径与名字
 * @param append：是否文件是否连续写入
 *  
 */
public class GatherFeeHandler extends Handler{
	
	public GatherFeeHandler(){
		super("bf_gather_fee_t.txt", "gather_fee2012.txt");
	}
	
	public GatherFeeHandler(String input, String output){
		super(input,output);
	}
	public GatherFeeHandler(String input, String output,Boolean append){
		super(input,output,append);
	}

	@Override
	public void handle() throws IOException {
		// TODO Auto-generated method stub
		String s = new String();
		GatherFee gf = new GatherFee();
		while((s = fg.readLine()) != null)
		{
			if(s.toString().startsWith("10"))
				continue;
			String[] as = s.split(SelectIndex.SPLITER);
			if(gf.isNew())
				gf.init(as);
			else if(gf.isSame(as))
			{
				gf.gatherFee(as);
			}
			else
			{
				fc.writeLine(gf.toString());
				gf = new GatherFee(as);
			}			
		}
		fg.close();
		fc.close();
	}

}
