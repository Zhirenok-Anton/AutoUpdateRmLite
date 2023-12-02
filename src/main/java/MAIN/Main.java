package MAIN;

import JDBC.JdbcRunner;
import CMD.CMD;
import JsonObject.ObjectJSON;
import JsonObject.ParserGson;
import com.google.gson.Gson;
import directory.Directory;
import zip.UnpackZip;

public class Main {


    public static void main(String[] args) {

        UnpackZip unpackZip = new UnpackZip();
        Directory directory = new Directory();
        ParserGson parserGson = new ParserGson();
        ObjectJSON j = parserGson.pars();
        CMD cmd = new CMD();
        JdbcRunner jdbcRunner = new JdbcRunner(postgresURL(),j.getDb().getConnection().getUser(),j.getDb().getConnection().getPass());

        //распоковать архивы
        unpackZip.unpack(j.getArhTwo().getPathStart(), j.getArhTwo().getPathEnd(), j.getArhTwo().getName());
        unpackZip.unpack(j.getArhOne().getPathStart(), j.getArhOne().getPathEnd(), j.getArhOne().getName());

        //создание директорий
        directory.createDirectoryRmLite(j.getArhOne().getPathEnd(), j.getNameFolderRmLite());
        directory.renameDirectory(j.getArhOne().getPathEnd(), j.getArhOne().getName().substring(0,j.getArhOne().getName().length()-4), j.getNameFolderShop_Lite());

        // работа с БД
        cmd.createDB(j.getDb().getPostgresPath(), j.getDb().getConnection().getUser(), j.getDb().getConnection().getPass(), j.getDb().getNameDB());
        cmd.damp(j.getDb().getPostgresPath(), j.getDb().getConnection().getUser(), j.getDb().getConnection().getPass(), j.getDb().getNameDB(), j.getDb().getPostgresDump());

        // скрипты
        jdbcRunner.updateParameterValueSalePointCode(j.getDb().getParameterValue().getSalePointCode());
        jdbcRunner.updateParameterValueLoadDictionaryDirectory(j.getArhOne().getPathEnd(),j.getNameFolderRmLite());
        jdbcRunner.updateParameterValueComProServiceIntegrationDirectory(j.getArhOne().getPathEnd(),j.getNameFolderRmLite());
        jdbcRunner.updateParameterValuePCardsServiceIntegrationDirectory(j.getArhOne().getPathEnd(),j.getNameFolderRmLite());
        jdbcRunner.updateParameterValueCountry(j.getDb().getParameterValue().getCountry());
    }



    private static String postgresURL(){
        ParserGson parserGson = new ParserGson();
        ObjectJSON j = parserGson.pars();
        return
                j.getDb().getConnection().getTypeDB()
                        + "//"
                        + j.getDb().getConnection().getHost()
                        + j.getDb().getConnection().getPort()
                        + "/"
                        + j.getDb().getNameDB();
    }

}
