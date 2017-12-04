package system.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import system.hibernate.Report;
import system.hibernate.ReportCommonView;
import system.model.Worker;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class WorkerDao {
    private List<Worker> workers;

    public WorkerDao() {

    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public List<ReportCommonView> getReport(boolean b) {
        SessionFactory sessionFactory =
                new Configuration()
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Report> res = new ArrayList<Report>();
        for (int i = 1; i < 3; i++) {
            Worker worker = session.get(Worker.class, i);
            List<Report> report;
            if (b) {
                report = getList1(worker.getName(), worker.getSurname(), session);
            } else {
                report = getList2(worker.getName(), worker.getSurname(), session);
            }

            for (int j = 0; j < report.size(); j++) {
                res.add(report.get(j));
            }
        }

        List<ReportCommonView> ans = new ArrayList<ReportCommonView>();
        Date date = new Date();
        SimpleDateFormat day = new SimpleDateFormat("dd MMMM YYYY", Locale.ENGLISH);
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH);
        for (int i = 0; i < res.size(); i++) {
            if (b) {
                date.setTime(res.get(i).getTime());
                ans.add(new ReportCommonView(res.get(i).getName() + " " + res.get(i).getSurname(),
                        day.format(date) + " " + time.format(date)));
            } else {
                long t = res.get(i).getTime();
                long s = t / 1000;
                long m = s / 60;
                long h = m / 60;
                ans.add(new ReportCommonView(res.get(i).getName() + " " + res.get(i).getSurname(),
                        h + ":" + m + ":" + s));
            }
        }
        List<ReportCommonView> end = new ArrayList<ReportCommonView>();
        for (int i = 0; i < ans.size(); i++) {
            end.add(ans.get(i));
        }
        session.close();
        sessionFactory.close();
        return end;

    }

    public List<Report> getList1(String firstName, String lastName, Session session) {

        Query query = session.createQuery(
                "select new system.hibernate.Report(e.card.worker.name, e.card.worker.surname, e.time) " +
                        "from EnterTime e " +
                        "where e.card.worker.name = :firstname and e.card.worker.surname = :lastname"
        );
        query.setParameter("firstname", firstName);
        query.setParameter("lastname", lastName);
        return query.list();
    }

    public List<Report> getList2(String firstName, String lastName, Session session) {

        Query query = session.createQuery(
                "select new system.hibernate.Report(e.card.worker.name, e.card.worker.surname, e.exitTime.time-e.time) " +
                        "from EnterTime e " +
                        "where e.card.worker.name = :firstname and e.card.worker.surname = :lastname"
        );
        query.setParameter("firstname", firstName);
        query.setParameter("lastname", lastName);
        return query.list();
    }

}
