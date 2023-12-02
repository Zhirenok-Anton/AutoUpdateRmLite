package directory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Directory {

    public void createDirectoryRmLite(String pathDirectory, String nameDirectory) {

        new File(pathDirectory + "\\" + nameDirectory).mkdir();
        new File(pathDirectory + "\\" + nameDirectory + "\\s").mkdir();
        new File(pathDirectory + "\\" + nameDirectory + "\\r").mkdir();
        new File(pathDirectory + "\\" + nameDirectory + "\\comPro").mkdir();
        new File(pathDirectory + "\\" + nameDirectory + "\\Pcard").mkdir();
    }

    public void renameDirectory(String path, String oldName, String newName) {
        new File(path + "\\"+ oldName).renameTo(new File(path +"\\"+ newName));
    }

    public void createDirectory(String directory, String endPath) {
        new File(endPath+ "\\" + directory).mkdir();
    }

    public void deleteDirectory(String path){
        try {
            Files.delete(Paths.get(path));
        }  catch (IOException x) {
            System.err.println(x);
        }

    }
}
