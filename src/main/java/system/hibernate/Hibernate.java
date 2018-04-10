package system.hibernate;
//
//import java.util.List;
//import java.util.Set;
//

import org.hibernate.*;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import system.dao.WorkerDao;
import system.model.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.hibernate.Query;

public class Hibernate {

    public static void main(String[] args) {
//        SessionFactory sessionFactory =
//                new Configuration()
//                        .configure()
//                        .buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction = session.beginTransaction();
//        Worker worker1 = new Worker();
//        worker1.setName("Kimi");
//        worker1.setSurname("Raikkonen");
//        worker1.setAge(37);
//        session.save(worker1);
//        Worker worker2 = new Worker();
//        worker2.setName("Lewis");
//        worker2.setSurname("Hamilton");
//        worker2.setAge(28);
//        session.save(worker2);
//        Watchman watchman = new Watchman();
//        watchman.setName("Nico");
//        watchman.setSurname("Rosberg");
//        session.save(watchman);
//
//        Card card = new Card();
//        card.setNumber(123214);
//        card.setWorker(session.get(Worker.class, 1));
//        Card card1 = new Card();
//        card1.setNumber(537);
//        card1.setWorker(session.get(Worker.class, 2));
//        session.save(card);
//        session.save(card1);
//
//        EnterTime enterTime = new EnterTime();
//        enterTime.setTime(new Date().getTime());
//        enterTime.setWatchman(session.get(Watchman.class, 1));
//        enterTime.setCard(session.get(Card.class, 1));
//        session.save(enterTime);
//
//        ExitTime exitTime = new ExitTime();
//        exitTime.setTime(new Date().getTime());
//        exitTime.setWatchman(session.get(Watchman.class, 1));
//        exitTime.setCard(session.get(Card.class, 3));
//        exitTime.setEnterTime(session.get(EnterTime.class, 3));
//        session.save(exitTime);

//        session.get(EnterTime.class, 2).setExitTime(session.get(ExitTime.class, 3));

//        Card card = new Card();
//        card.setNumber(1233);
//        card.setWorker(session.get(Worker.class, 1));
//        session.save(card);

//        EnterTime enterTime = new EnterTime();
//        enterTime.setTime(new Date().getTime());
//        enterTime.setWatchman(session.get(Watchman.class, 1));
//        enterTime.setCard(session.get(Card.class, 3));
//        session.save(enterTime);


//        transaction.commit();
//        session.close();
//        sessionFactory.close();
    }
}