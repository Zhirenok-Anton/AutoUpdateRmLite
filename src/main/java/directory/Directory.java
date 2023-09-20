package directory;

import java.io.File;

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
}
