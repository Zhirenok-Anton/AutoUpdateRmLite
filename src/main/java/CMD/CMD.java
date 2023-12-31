package CMD;

import java.io.IOException;
import java.io.PrintWriter;

public class CMD {
    private Process p = null;
    private PrintWriter stdin = null;

    private void afterCMD() {
        String[] command =
                {
                        "cmd",
                };

        try {
            p = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
        new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
        stdin = new PrintWriter(p.getOutputStream());

    }

    private void beforeCMD() {

        stdin.close();
        int returnCode = 0;
        try {
            returnCode = p.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Return code = " + returnCode);
    }

    public void damp(String postgresPath, String postgresUser, String postgresPassword, String postgresNameDB, String postgresDump) {
        afterCMD();
        stdin.println("cd " + postgresPath);
        stdin.println("set PGPASSWORD=" + postgresPassword);
        stdin.println("psql.exe -p5432 -U " + postgresUser + " " + postgresNameDB + " < " + postgresDump);
        beforeCMD();
    }

    public void createDB(String postgresPath, String postgresUser, String postgresPassword, String postgresNameDB) {
        afterCMD();
        stdin.println("cd " + postgresPath);
        stdin.println("set PGPASSWORD=" + postgresPassword);
        stdin.println("createdb.exe -U " + postgresUser + " " + postgresNameDB);
        beforeCMD();
    }
}

