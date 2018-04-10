package system.hibernate;

public class Report {

    private String name;
    private String surname;
    private long enterTime;
    private long exitTime;

    public Report(String name, String surname, long enterTime, long exitTime) {
        this.name = name;
        this.surname = surname;
        this.enterTime = enterTime;
        this.exitTime = exitTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(long enterTime) {
        this.enterTime = enterTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }
}
