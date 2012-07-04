package dmlab.unicom.data.structer;

public class ServingName {
	
	private Integer count = 0;
	private String name;
	
	public ServingName(){}
	
	public ServingName(String name, Integer count){
		this.count = count;
		this.name = name;
	}
	
	public void increace()
	{
		count++;
	}
	
	public String toString()
	{
		return name+","+count.toString();
	}

	public Integer getCount() {
		return count;
	}

}
