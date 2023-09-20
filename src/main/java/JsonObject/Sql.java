package JsonObject;

public class Sql {
    private String nameDB;
    private String location;
    Connection ConnectionObject;


    // Getter Methods

    public String getNameDB() {
        return nameDB;
    }

    public String getLocation() {
        return location;
    }

    public Connection getConnection() {
        return ConnectionObject;
    }

    // Setter Methods

    public void setNameDB(String nameDB) {
        this.nameDB = nameDB;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setConnection(Connection connectionObject) {
        this.ConnectionObject = connectionObject;
    }
}
