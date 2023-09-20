package JsonObject;

public class Connection {
    private String host;
    private String port;
    private String pass;
    private String typeDB;


    // Getter Methods

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getPass() {
        return pass;
    }

    public String getTypeDB() {
        return typeDB;
    }

    // Setter Methods

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setTypeDB(String typeDB) {
        this.typeDB = typeDB;
    }
}
