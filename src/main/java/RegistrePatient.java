import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;


/**
 * Created by user on 23.06.2018.
 */
public class RegistrePatient {
    private Scanner scan = new Scanner(System.in);
    private Hospital hospital;
    URL source = new URL("https://raw.githubusercontent.com/mastermaks11/file/master/Output.json");

    public RegistrePatient() throws MalformedURLException {
        this.hospital = new Hospital();
    }

    public void registre() throws ParseException, IOException {
        System.out.println("Загрузка локального файла");
        PatientUploadLocalFile  patientUploadLocalFile = new PatientUploadLocalFile(hospital);
        patientUploadLocalFile.uploadLoacalFile();
        System.out.println("Загрузка удаленного файла");
        PatientsUpload patientsUpload = new PatientsUpload(source, hospital);
        patientsUpload.upload(hospital);
        System.out.println("Введите кол-во пацентов");
        int count = scan.nextInt();
        while (count != 0) {
            hospital.addPatient(new Patient(scan.next(), scan.next(), java.sql.Date.valueOf(scan.next()), scan.nextBoolean()));
            count = count - 1;
        }
        patientsUpload = new PatientsUpload(source, hospital);
        patientsUpload.upload(hospital);
        Secretary secretary = new Secretary("patient.dat");
        try {
            secretary.write();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

