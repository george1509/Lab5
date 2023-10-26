package tema1;
import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class MainApp {
    public static void scriere(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/Numere.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Persoana> citire() {
        try {
            File file=new File("src/main/resources/Numere.json");
            ObjectMapper mapper=new ObjectMapper();
            List<PerecheNumere> Numere = mapper
                    .readValue(file, new TypeReference<List<Persoana>>(){});
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        List<PerecheNumere> Numere=citire();
        System.out.println(Numere);
        for(PerecheNumere p:Numere){
            System.out.println(p);
        }
        Numere.add(new PerecheNumere("Maria",33));
        scriere(Numere);
    }
}
