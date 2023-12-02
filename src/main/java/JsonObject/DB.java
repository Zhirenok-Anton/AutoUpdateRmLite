package JsonObject;

public class DB {
    private String nameDB;
    private String postgresPath;
    private String postgresDump;
    private Connection connection;
    private parameterValue parameterValue;

    public String getNameDB() {
        return nameDB;
    }

    public void setNameDB(String nameDB) {
        this.nameDB = nameDB;
    }

    public String getPostgresPath() {
        return postgresPath;
    }

    public void setPostgresPath(String postgresPath) {
        this.postgresPath = postgresPath;
    }

    public String getPostgresDump() {
        return postgresDump;
    }

    public void setPostgresDump(String postgresDump) {
        this.postgresDump = postgresDump;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public JsonObject.parameterValue getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(JsonObject.parameterValue parameterValue) {
        this.parameterValue = parameterValue;
    }
}
