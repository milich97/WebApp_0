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

    public List<ReportCommonView> getReport() {
        SessionFactory sessionFactory =
                new Configuration()
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Report> res = new ArrayList<Report>();
        for (int i = 1; i < 3; i++) {
            Worker worker = session.get(Worker.class, i);
            List<Report> report;
            report = getList(worker.getName(), worker.getSurname(), session);
            for (int j = 0; j < report.size(); j++) {
                res.add(report.get(j));
            }
        }

        List<ReportCommonView> ans = new ArrayList<ReportCommonView>();
        Date date1 = new Date();
        SimpleDateFormat day = new SimpleDateFormat("dd MMMM YYYY", Locale.ENGLISH);
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH);
        for (int i = 0; i < res.size(); i++) {
            date1.setTime(res.get(i).getEnterTime());
            long delta = res.get(i).getExitTime() - date1.getTime();
            long h = (delta - delta % 3600000) / 3600000;
            delta -= h * 3600000;
            long m = (delta - delta % 60000) / 60000;
            delta -= m * 60000;
            long s = (delta - delta % 1000) / 1000;
            String duration = "";
            if (h != 0) duration += h + " hours ";
            if (m != 0) duration += m + " minutes ";
            if (s != 0) duration += s + " seconds ";
            if (duration == "") duration = "Less then second!";

            ans.add(new ReportCommonView(res.get(i).getName() + " " + res.get(i).getSurname(),
                    day.format(date1),
                    time.format(date1),
                    duration));
        }

        List<ReportCommonView> end = new ArrayList<ReportCommonView>();
        for (
                int i = 0; i < ans.size(); i++)

        {
            end.add(ans.get(i));
        }
        session.close();
        sessionFactory.close();
        return end;

    }

    public List<Report> getList(String firstName, String lastName, Session session) {
        Query query = session.createQuery(
                "select new system.hibernate.Report(e.card.worker.name, e.card.worker.surname, e.time,e.exitTime.time) " +
                        "from EnterTime e " +
                        "where e.card.worker.name = :firstname and e.card.worker.surname = :lastname"
        );
        query.setParameter("firstname", firstName);
        query.setParameter("lastname", lastName);
        return query.list();
    }
}
