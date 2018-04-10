package system.model;

import javax.persistence.*;


@Entity
@Table(name = "entertimes")
public class EnterTime {
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
    @JoinColumn(name = "exittime_id")
    private ExitTime exitTime;

    public EnterTime() {
    }

    public Watchman getWatchman() {
        return watchman;
    }

    public void setWatchman(Watchman watchman) {
        this.watchman = watchman;
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public ExitTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(ExitTime exitTime) {
        this.exitTime = exitTime;
    }

    @Override
    public String toString() {
        return "EnterTime{" +
                "id=" + id +
                ", time=" + time +
                ", watchman=" + watchman +
                ", card=" + card +
                ", exitTime=" + exitTime +
                '}';
    }
}
