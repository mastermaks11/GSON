import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.codehaus.jackson.map.ObjectMapper;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import javax.xml.stream.XMLStreamException;


/**
 * Created by user on 19.06.2018.
 */
public class PatientsUpload {
    private URL source;
    private Hospital hospital;

    public PatientsUpload(URL source, Hospital hospital) {
        this.source = source;
        this.hospital = hospital;
    }

    public void upload(Hospital hospital) throws IOException, ParseException {
        URLConnection connection = source.openConnection();
        InputStream inputStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Hospital rootNode = mapper.readValue(inputStream, Hospital.class);
    }
}