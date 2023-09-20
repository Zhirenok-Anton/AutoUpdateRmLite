package MAIN;

import CMD.CMD;
import JDBC.JdbcRunner;
import directory.Directory;
import zip.UnpackZip;

import java.io.*;

public class Main {

        /**Параметры для разархивации основного и создания директорий*/
    private static final String startPathBaseZip = "C:";//путь к архиву с версией для обновления
    private static final String endPathBaseZip = "C:\\updateVersion"; // путь куда распаковать версию для обновления
    private static final String baseZipName = "shop-lite_5.21.zip"; // название архива
    private static String baseNameDirectory = "";// название директории
    private static String shopLiteNameDirectory = "shop-lite-ft-RMLITE-6086-base64-compro-kiz-h234";// название директории shop-lite
    private static String rmLiteNameDirectory = "rmlite-ft-RMLITE-6086-base64-compro-kiz-h234";//название директории rm-lite

    private static final String startPathNewVersionZip = "C:"; //путь к архиву с обновлением
    private static final String endPathNewVersionBaseZip = "C:\\LiteZipVersion";// путь куда положить архив с обновлением
    private static final String newVersionZipName = "shop-lite-ft-RMLITE-6086-base64-compro-kiz.zip";// как называется версия с обновлением
    private static String newVersionNameDirectory = "";

        /**параметры для работы c БД*/
    private static final String postgresPassword = "postgres";
    private static final String postgresUser = "postgres";
    private static final String postgresURL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String postgresPath = "C:\\Program Files\\PostgreSQL\\12\\bin";
    private static final String postgresNameDB = "TestDB_4";
    private static final String postgresDump = "C:\\dump_5_21_3.sql";


    public static void main(String[] args){


        UnpackZip unpackZip = new UnpackZip();
        Directory directory = new Directory();
        JdbcRunner jdbcRunner = new JdbcRunner();
        CMD cmd = new CMD();

        /** работа с Директориями*/
        baseNameDirectory = unpackZip.unpack(startPathBaseZip,endPathBaseZip,baseZipName);
        newVersionNameDirectory = unpackZip.unpack(startPathNewVersionZip,endPathNewVersionBaseZip,newVersionZipName);
        directory.createDirectoryRmLite(endPathBaseZip,rmLiteNameDirectory);
        directory.renameDirectory(endPathBaseZip,baseNameDirectory,shopLiteNameDirectory);

        /** работа с БД*/
        cmd.createDB(postgresPath,postgresUser,postgresPassword,postgresNameDB,postgresDump);



    }




    //Путь к Архиву
    // название архива
    //куда распаковать


    private static void renameDirectory(){
        File file = new File ("C:\\updateVersion\\shop-lite_5.21");
        file.renameTo(new File("C:\\updateVersion\\shop-lite_5.40"));
    }
}
