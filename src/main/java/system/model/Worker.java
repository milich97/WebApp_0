package system.model;

public class Worker {
    private String name;
    private int id;
    private int time_arrival;
    private int time_departure;

    public Worker() {
    }

    public Worker(String name, int id, int time_arrival, int time_departure) {

        this.name = name;
        this.id = id;
        this.time_arrival = time_arrival;
        this.time_departure = time_departure;
    }

    public int getId() {

        return id;
    }

    public int getTime_arrival() {
        return time_arrival;
    }

    public int getTime_departure() {
        return time_departure;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime_arrival(int time_arrival) {
        this.time_arrival = time_arrival;
    }

    public void setTime_departure(int time_departure) {
        this.time_departure = time_departure;
    }

    public String getName() {

        return name;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", time_arrival=" + time_arrival +
                ", time_departure=" + time_departure +
                '}';
    }
}
