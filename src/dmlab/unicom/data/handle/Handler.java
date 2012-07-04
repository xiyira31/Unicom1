package dmlab.unicom.data.handle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import dmlab.unicom.data.file.FileCreater;
import dmlab.unicom.data.file.FileGetter;
import dmlab.unicom.data.util.SelectIndex;

public abstract class Handler {
	
	protected FileGetter fg;
	protected FileCreater fc;
	private String inputpath;
	private String outputpath;
	
	public Handler(){
		
	};
	
	public Handler(String input, String output){
		init(input,output);
	};
	
	public Handler(String input, String output, Boolean append){
		init(input, output, append);
	};
	
	private void init(String input, String output)
	{
		init(input, output, false);
	}
	
	private void init(String input, String output, Boolean append)
	{
		try {
			inputpath = SelectIndex.INPUTPATH;
			outputpath = SelectIndex.OUTPUTPATH;
			fg = new FileGetter(inputpath + input);
			fc = new FileCreater(outputpath + output,append);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public abstract void handle() throws IOException, ParseException;
}
