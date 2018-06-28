import java.util.logging.LogManager;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by user on 19.06.2018.
 */
public class Main {
    public static void main(String[] args) throws ParseException, IOException, SAXException, ParserConfigurationException {
        RegistrePatient registrePatient = new RegistrePatient();
        try {
            System.setProperty("java.until.logging.config.file", "logger.properties");
            LogManager.getLogManager().readConfiguration();

        } catch (IOException e) {
            System.err.println(e.toString());
        }

        registrePatient.registre();

    }
}
