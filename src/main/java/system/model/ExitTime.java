package system.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "exittimes")
public class ExitTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "time")
    private long time;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watchman_id")
    private Watchman watchman;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entertime_id")
    private EnterTime enterTime;

    public ExitTime() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Watchman getWatchman() {
        return watchman;
    }

    public void setWatchman(Watchman watchman) {
        this.watchman = watchman;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public EnterTime getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(EnterTime enterTime) {
        this.enterTime = enterTime;
    }

    @Override
    public String toString() {
        return "ExitTime{" +
                "id=" + id +
                ", time=" + time +
                ", watchman=" + watchman +
                ", card=" + card +
                ", enterTime=" + enterTime +
                '}';
    }
}

