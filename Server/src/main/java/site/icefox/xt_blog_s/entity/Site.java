package site.icefox.xt_blog_s.entity;

public class Site {


    private int id;
    private String key;
    private String val;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getval() {
        return val;
    }

    public void setval(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}
