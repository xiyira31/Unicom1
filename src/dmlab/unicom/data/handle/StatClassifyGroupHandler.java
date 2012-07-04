package dmlab.unicom.data.handle;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import dmlab.unicom.data.structer.ClassifyGroup;
import dmlab.unicom.data.util.SelectIndex;

/*
 * StatClassifyGroupHandler：将数据按照一定规则格式分类，
 * 
 * 输入项需要有分类的项，是否合法项，还需要输入分类的组信息
 * 
 * @param input：输入文件路径与名字
 * @param output：输出文件路径与名字
 * @param rateCol:需要分类的项
 * @param ifVaild：是否合法的项
 * @param groupList：分类信息，是一个整数数组
 * @param append：是否文件是否连续写入
 *  
 * 输出为按照groupList统计好个数的文件
 */

public class StatClassifyGroupHandler extends Handler{
	
	private Integer rateCol;
	private Integer ifVaild;
	private Integer[] groupList;
	
	public StatClassifyGroupHandler(String input, String output, 
			Integer rateCol, Integer ifVaild, Integer[] groupList){
		super(input,output);
		this.rateCol = rateCol;
		this.ifVaild = ifVaild;
		this.groupList = groupList;
	}
	public StatClassifyGroupHandler(String input, String output,
			Integer rateCol, Integer ifVaild, Integer[] groupList, Boolean append){
		super(input,output,append);
		this.rateCol = rateCol;
		this.ifVaild = ifVaild;
		this.groupList = groupList;
	}

	@Override
	public void handle() throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		List<ClassifyGroup> list = groupedList(groupList);
		ClassifyGroup cg = new ClassifyGroup();
		list.add(cg);
		Integer groupSize = list.size();
		String s =null;
		while((s=fg.readLine())!=null)
		{
			String[] line = s.split(SelectIndex.SPLITER);
			Integer rate = null;
			try{
				rate = Integer.valueOf(line[rateCol]);
			}catch(Exception e){
				rate = null;
			}
					
			
				for(Integer index = 0;index<groupSize;index++)
				{
						if(list.get(index).addCount(rate,line[ifVaild]))
						{
							break;
						}					
				}			
		}
		
		for(Integer index = 0;index<groupSize;index++)
		{
			fc.writeLine(list.get(index).toString());
		}
		fg.close();
		fc.close();
	}
	
	private List<ClassifyGroup> groupedList(Integer[] groups)
	{
		Integer size = groups.length;
		List<ClassifyGroup> list = new ArrayList();
		for(Integer index=0;index<size;index++)
		{
			if(index == 0)
			{
				ClassifyGroup cg = new ClassifyGroup(null,groups[index]);
				list.add(cg);
			}
			else
			{
				ClassifyGroup cg = new ClassifyGroup(groups[index-1],groups[index]);
				list.add(cg);
			}				
		}
		list.add(new ClassifyGroup(groups[size-1],null));
		return list;
	}

}
