package JsonObject;

import com.google.gson.Gson;

import java.io.FileReader;

public class ParserGson {

    public ObjectJSON pars(){
        Gson gson = new Gson();
        try (FileReader reader= new FileReader("C:\\Users\\AZhirenok\\IdeaProjects\\AutoUpdateRmLite\\src\\main\\resources\\config.json")){
             ObjectJSON objectJSON= gson.fromJson(reader,ObjectJSON.class);
            return objectJSON;
        }catch (Exception e){
            System.out.println("pars error " + e.toString());
        }
        return null;
    }
}
