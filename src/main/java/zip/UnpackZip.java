package zip;

import directory.Directory;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnpackZip {

    public String unpack(String startPath, String endPath,String zipName)
    {
        String directory = "";
        InputStream is;
        ZipInputStream zis;
        try
        {
            is = new FileInputStream(startPath + "\\" + zipName);
            zis = new ZipInputStream(new BufferedInputStream(is));
            ZipEntry ze;

            Directory dir = new Directory();
            directory = zipName.substring(0,zipName.length()-4);
            dir.createDirectory(directory, endPath);

            String filename;
            while((ze = zis.getNextEntry()) != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;

                filename = ze.getName();

                if(ze.isDirectory()) {
                    File directPath = new File(endPath + "\\" + directory + "\\" + filename);
                    directPath.mkdirs();
                } else {
                    File directPath = new File(endPath + "\\" + directory + "\\");
                    directPath.mkdir();
                    FileOutputStream fout = new FileOutputStream(endPath + "\\" + directory + "\\" + filename);

                    // reading and writing
                    while((count = zis.read(buffer)) != -1)
                    {
                        baos.write(buffer, 0, count);
                        byte[] bytes = baos.toByteArray();
                        fout.write(bytes);
                        baos.reset();
                    }

                    fout.close();
                    zis.closeEntry();
                }
            }

            zis.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return directory;
    }
}
