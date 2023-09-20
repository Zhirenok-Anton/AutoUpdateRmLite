package JsonObject;

public class Object {
    private String name;
    private String path;
    ArhOne ArhOneObject;
    ArhTwo ArhTwoObject;
    Sql SqlObject;


    // Getter Methods

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public ArhOne getArhOne() {
        return ArhOneObject;
    }

    public ArhTwo getArhTwo() {
        return ArhTwoObject;
    }

    public Sql getSql() {
        return SqlObject;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setArhOne(ArhOne arhOneObject) {
        this.ArhOneObject = arhOneObject;
    }

    public void setArhTwo(ArhTwo arhTwoObject) {
        this.ArhTwoObject = arhTwoObject;
    }

    public void setSql(Sql sqlObject) {
        this.SqlObject = sqlObject;
    }
}
