package Map;

import java.io.*;
import com.thoughtworks.xstream.XStream;

public class MapLoader {
	
	private static MapLoader uniqueInstance = null;
	
	private XStream xstream;
	private Writer writer;

	/**
	 * Constructor for MapLoader
	 */
	private MapLoader() {
		xstream = new XStream();
		writer = null;
	}
	
	public static synchronized MapLoader getUniqueInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new MapLoader();
		}
		return uniqueInstance;
	}
		
	/**
	 * Saves the map as an XML file
	 * 
	 * @param m
	 */
	public void saveMap(Map m) {

		String map1 = xstream.toXML(m);

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("map.txt"), "utf-8"));
			writer.write(map1);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
			}
		}

	}

	/**
	 * Loads the XML file and turns it into a Map
	 * 
	 * @param map
	 *            - name of XML file
	 * @return Map created from XML file
	 * @throws IOException
	 */
	public Map loadMap(String map) throws IOException {

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
