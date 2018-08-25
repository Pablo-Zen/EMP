package util;

import java.io.FileWriter;
import java.io.IOException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtil {

  private static Document userDocument;

  public static Document getUserDocument() {
    if (userDocument != null) {
      return userDocument;
    }
    SAXReader reader = new SAXReader();
    try {
      userDocument = reader
          .read(XMLUtil.class.getClassLoader().getResourceAsStream("xml/users.xml"));
      return userDocument;
    } catch (DocumentException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void write2XML(Document d, String name) {
    XMLWriter writer = null;
    try {
      String path = XMLUtil.class.getClassLoader().getResource("xml/" + name + ".xml").getPath();
      path.replace("bin", "src");
      writer = new XMLWriter(new FileWriter(path));
      writer.write(d);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
