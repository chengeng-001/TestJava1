package jdbc.zibao;

import java.io.Reader;
import java.util.Date;

public class java2 {
    private int id;
    private String name;
    private double gozi;
    private Date ruziriqi;
    private int dept;

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


    public double getGozi() {
        return gozi;
    }

    public void setGozi(double gozi) {
        this.gozi = gozi;
    }

    public Date getRuziriqi() {
        return ruziriqi;
    }

    public void setRuziriqi(Date ruziriqi) {
        this.ruziriqi = ruziriqi;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "java2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gozi=" + gozi +
                ", ruziriqi=" + ruziriqi +
                ", dept=" + dept +
                '}';
    }


}
