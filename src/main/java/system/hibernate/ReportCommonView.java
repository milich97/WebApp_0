package system.hibernate;


public class ReportCommonView {

    private String worker_name;
    private String date;
    private String enterTime;
    private String duration;

    public ReportCommonView(String worker_name, String date, String enterTime, String duration) {
        this.worker_name = worker_name;
        this.date = date;
        this.enterTime = enterTime;
        this.duration = duration;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
