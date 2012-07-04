package dmlab.unicom.data.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import dmlab.unicom.data.util.SelectIndex;

public class FileGetter{
	
	private File file;
	private BufferedReader br;
	private final String spliter = SelectIndex.SPLITER;

	public FileGetter(String path) throws FileNotFoundException, UnsupportedEncodingException {
		this.file = new File(path);
		this.br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gb2312"));
	}

	public String readLine() throws IOException
	{
		return this.br.readLine();
	}
	
	public StringBuilder readList(List list) throws IOException
	{
		String s = readLine();
		if(s == null || s.length() ==0)
			return null;
		String[] as = s.split(spliter);
		StringBuilder sb = new StringBuilder();
		for (Integer index = 0; index < list.size(); index++)
		{
			sb.append(as[(Integer) list.get(index)]).append(spliter);
		}
		sb.deleteCharAt(sb.length()-1);
		return sb;
	}
	
	public void close() throws IOException
	{
		this.br.close();
	}
	
}
