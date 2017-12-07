package system.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import system.hibernate.Report;
import system.hibernate.ReportCommonView;
import system.model.EnterTime;
import system.model.Worker;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class WorkerDao {
    public WorkerDao() {

    }

    public List<ReportCommonView> getReport() {
        SessionFactory sessionFactory =
                new Configuration()
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Report> report = getList(session);
        session.close();
        sessionFactory.close();
        return getRes(report);
    }

    private List<ReportCommonView> getRes(List<Report> report) {
        List<ReportCommonView> res = new ArrayList<ReportCommonView>();
        Date date1 = new Date();
        SimpleDateFormat day = new SimpleDateFormat("dd MMMM YYYY", Locale.ENGLISH);
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH);
        for (int i = 0; i < report.size(); i++) {
            date1.setTime(report.get(i).getEnterTime());
            long delta = report.get(i).getExitTime() - date1.getTime();
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

            res.add(new ReportCommonView(report.get(i).getName() + " " + report.get(i).getSurname(),
                    day.format(date1),
                    time.format(date1),
                    duration));
        }
        return res;
    }

    public List<Report> getList(Session session) {
        Query query = session.createQuery(
                "select new system.hibernate.Report(e.card.worker.name, e.card.worker.surname, e.time,e.exitTime.time) " +
                        "from EnterTime e "
        );
        return query.list();
    }

    public List<ReportCommonView> getReport(long time) {
        SessionFactory sessionFactory =
                new Configuration()
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Report> report = getList_Date(time, session);
        session.close();
        sessionFactory.close();
        return getRes(report);
    }

    private List<Report> getList_Date(long time, Session session) {
        Query query = session.createQuery(
                "select new system.hibernate.Report(e.card.worker.name, e.card.worker.surname, e.time,e.exitTime.time) " +
                        "from EnterTime e " +
                        "where e.time>time"
        );

        return query.list();
    }
}
