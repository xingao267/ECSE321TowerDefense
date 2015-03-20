package Map;

import java.io.*;
import com.thoughtworks.xstream.XStream;

public class MapLoader {
	
	XStream xstream;
	Writer writer;
	
	public MapLoader() {
		xstream = new XStream();
		writer = null;
	}
	
	public  void saveMap(Map m){
				
		String map1 = xstream.toXML(m);
		

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("map.txt"), "utf-8"));
		    writer.write(map1);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}
		
	}
	
	public  Map loadMap(String map) throws IOException{
		
		map += ".txt";
		String xml;
		
		BufferedReader br = new BufferedReader(new FileReader(map));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	         xml = sb.toString();
	    } finally {
	        br.close();
	    }
		
		Map m = (Map) xstream.fromXML(xml);
		return m;
		
	}
	
}
