package CMD;

import java.io.IOException;
import java.io.PrintWriter;

public class CMD {

     public void createDB(String postgresPath, String postgresUser, String postgresPassword, String postgresNameDB, String postgresDump){
        String[] command =
                {
                        "cmd",
                };
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
        new Thread(new SyncPipe(p.getInputStream(), System.out)).start();

        PrintWriter stdin = new PrintWriter(p.getOutputStream());
        stdin.println("cd " + postgresPath);
        stdin.println("set PGPASSWORD=" + postgresPassword);
        stdin.println("createdb.exe -U " + postgresUser + " " + postgresNameDB);
        stdin.println("psql.exe -p5432 -U " + postgresUser + " " + postgresNameDB + " < " + postgresDump);
        // write any other commands you want here
        stdin.close();
        int returnCode = 0;
        try {
            returnCode = p.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Return code = " + returnCode);
    }
}

