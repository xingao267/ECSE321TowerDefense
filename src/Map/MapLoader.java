package Map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

/**
 * This class loads and saves Maps as XML documents
 * 
 * @author Justin
 *
 */
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

    public static synchronized MapLoader getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new MapLoader();
        }
        return uniqueInstance;
    }

    /**
     * Saves the map as an XML file
     * 
     * @param m
     */
    public void saveMap(Map m, String name) {

        String map1 = xstream.toXML(m);

        try {
            writer =
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name + ".txt"),
                            "utf-8"));
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
     * @param map - name of XML file
     * @return Map created from XML file
     * @throws IOException
     */
    public Map loadMap(String map) throws IOException {

        // map += ".txt";
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

    public void deleteMap(String map) {
        new File(map).delete();

    }

    /**
     * Searches for custom-made maps
     * 
     * @return A list of map names
     */
    public List<String> getMapList() {
        List<String> maps = new ArrayList<String>();
        File dir = new File(System.getProperty("user.dir"));
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith((".txt"))) {
                maps.add(file.getName());
            }
        }
        return maps;
    }
}
