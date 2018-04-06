package Entity;

/**
 * 管理员实体类
 */
public class Admin {
    private int id; //管理员id
    private String name;  //管理员账号
    private String pwd;  //账号密码


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
