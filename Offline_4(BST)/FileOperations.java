import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    private static final String INPUT_FILE_NAME = "input.txt";

    public static List<Operations> readFromFile() throws Exception {
        List<Operations> opList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(" ");
            Operations o=new Operations(tokens[0],tokens[1]);
            opList.add(o);
        }
        br.close();
        return opList;
    }
}
