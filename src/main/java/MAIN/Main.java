package MAIN;

import JDBC.JdbcRunner;
import CMD.CMD;
import JsonObject.ObjectJSON;
import JsonObject.ParserGson;
import com.google.gson.Gson;
import directory.Directory;
import zip.UnpackZip;

public class Main {

    /**
     * Параметры для разархивации основного и создания директорий
     */
    private static String baseNameDirectory = "";// название директории
    private static String newVersionNameDirectory = "";

    /**
     * параметры для работы c БД
     */
    private static final String postgresPassword = "postgres";
    private static final String postgresUser = "postgres";
    private static final String postgresURL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String postgresPath = "C:\\Program Files\\PostgreSQL\\12\\bin";
    private static final String postgresNameDB = "TestDB_4";
    private static final String postgresDump = "C:\\dump_5_21_3.sql";


    public static void main(String[] args) {

        UnpackZip unpackZip = new UnpackZip();
        Directory directory = new Directory();
        JdbcRunner jdbcRunner = new JdbcRunner();
        ParserGson parserGson = new ParserGson();
        ObjectJSON j = parserGson.pars();
        CMD cmd = new CMD();



        baseNameDirectory = unpackZip.unpack(j.getArhOne().getPathStart(), j.getArhOne().getPathEnd(), j.getArhOne().getName());
        newVersionNameDirectory = unpackZip.unpack(j.getArhTwo().getPathStart(), j.getArhTwo().getPathEnd(), j.getArhTwo().getName());

        directory.createDirectoryRmLite(j.getArhOne().getPathEnd(), j.getNameFolderRmLite());
        directory.renameDirectory(j.getArhOne().getPathEnd(), baseNameDirectory, j.getNameFolderShop_Lite());

        // работа с БД
        cmd.createDB(j.getDb().getPostgresPath(), j.getDb().getConnection().getUser(), j.getDb().getConnection().getPass(), j.getDb().getNameDB());
        cmd.damp(j.getDb().getPostgresPath(), j.getDb().getConnection().getUser(), j.getDb().getConnection().getPass(), j.getDb().getNameDB(), j.getDb().getPostgresDump());

    }

    private String postgresURL(){
        ParserGson parserGson = new ParserGson();
        ObjectJSON j = parserGson.pars();
        return
                j.getDb().getConnection().getTypeDB()
                + "////"
                + j.getDb().getConnection().getHost()
                + j.getDb().getConnection().getPort()
                + "//"
                + j.getDb().getNameDB();
    }

}
