package system.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private int number;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card")
    private Set<EnterTime> enterTimes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card")
    private Set<ExitTime> exitTimes;


    public Card() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
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
        return "Card{" +
                "id=" + id +
                ", number=" + number +
                ", worker=" + worker +
                ", enterTimes=" + enterTimes +
                ", exitTimes=" + exitTimes +
                '}';
    }
}
