package system.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "watchmen")
public class Watchman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "watchman")
    private Set<EnterTime> enterTimes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "watchman")
    private Set<ExitTime> exitTimes;

    public Watchman() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<EnterTime> getEnterTimes() {
        return enterTimes;
    }

    public void setEnterTimes(Set<EnterTime> enterTimes) {
        this.enterTimes = enterTimes;
    }

    public Set<ExitTime> getExitTimes() {
        return exitTimes;
    }

    public void setExitTimes(Set<ExitTime> exitTimes) {
        this.exitTimes = exitTimes;
    }

    @Override
    public String toString() {
        return "Watchman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", enterTimes=" + enterTimes +
                ", exitTimes=" + exitTimes +
                '}';
    }
}
