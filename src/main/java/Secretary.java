import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 19.06.2018.
 */
public class Secretary {
    private Hospital hospital;
    private String fileName;
    private Set<Patient> patients = new HashSet<>();

    public Secretary(String fileName) {
        hospital = new Hospital();
        this.fileName = fileName;
        patients = hospital.getPatients();
    }

    public void write() throws ParserConfigurationException, SAXException, IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter write = new FileWriter("Output.json", false);
        for (Patient patient : patients) {
            String json = gson.toJson(patient);
            System.out.println(json);
            write.write(json);
            write.flush();
        }
        write.close();
    }
}
