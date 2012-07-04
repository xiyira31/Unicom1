package dmlab.unicom.data.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FileCreater {
	private File file;
	private BufferedWriter bw;
	
	public FileCreater (String path, Boolean append) throws IOException
	{
		this.file = new File(path);
		if(!file.exists())
			createFile();
		bw = new BufferedWriter(new FileWriter(path, append));
	}
	
	public void writeLine(String content) throws IOException
	{
		bw.write(content);
		bw.newLine();
	}	
	
	public <K, V> void writeMap(Map<K,V> map) throws IOException
	{
		Iterator iterator = map.entrySet().iterator();
		while(iterator.hasNext())
		{
			Entry entry = (Entry) iterator.next();
			writeLine(entry.getValue().toString());
		}
	}
	
	private void createFile() throws IOException
	{
		file.createNewFile();
	}
	
	public void close() throws IOException
	{
		bw.close();
	}
}
