import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by user on 28.06.2018.
 */
public class PatientUploadLocalFile {

    private Hospital hospital;
    String nameFile = "Output.json";

    public PatientUploadLocalFile(Hospital hospital) {
        this.hospital = hospital;
    }

    public void uploadLoacalFile() throws IOException {
        JsonReader reader = new JsonReader(new FileReader(nameFile));
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "name":
                    String namePatient = reader.nextString();
                    break;
                case "surname":
                    String surnamePatient = reader.nextString();
                    break;
                case "birth":
                    String datePAtient = reader.nextString();
                    break;
                case "health":
                    Boolean healthPatient = reader.nextBoolean();
                    break;
            }
        }
    }
}
