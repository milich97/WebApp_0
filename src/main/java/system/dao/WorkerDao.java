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
    private Session session;
    private SessionFactory sessionFactory;
    private List<Worker> workers;

    public WorkerDao() {
        sessionFactory =
                new Configuration()
                        .configure()
                        .buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public List<Worker> getWorkers() {
        session.close();
        sessionFactory.close();
        return workers;
    }

    public List<ReportCommonView> getReport(boolean b) {
        List<Report> res = new ArrayList<Report>();
        for (int i = 1; i < 3; i++) {
            Worker worker = session.get(Worker.class, i);
            List<Report> report;
            if (b) {
                report = getList1(worker.getName(), worker.getSurname());
            } else {
                report = getList2(worker.getName(), worker.getSurname());
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
            date.setTime(res.get(i).getTime());
            ans.add(new ReportCommonView(res.get(i).getName() + " " + res.get(i).getSurname(), day.format(date), time.format(date)));
        }

        session.close();
        sessionFactory.close();
        return ans;
    }

    public List<Report> getList1(String firstName, String lastName) {

        Query query = session.createQuery(
                "select new system.hibernate.Report(e.card.worker.name, e.card.worker.surname, e.time) " +
                        "from EnterTime e " +
                        "where e.card.worker.name = :firstname and e.card.worker.surname = :lastname"
        );
        query.setParameter("firstname", firstName);
        query.setParameter("lastname", lastName);
        return query.list();
    }
    public List<Report> getList2(String firstName, String lastName) {

        Query query = session.createQuery(
                "select new system.hibernate.Report(e.card.worker.name, e.card.worker.surname, e.time) " +
                        "from EnterTime e " +
                        "where e.card.worker.name = :firstname and e.card.worker.surname = :lastname"
        );
        query.setParameter("firstname", firstName);
        query.setParameter("lastname", lastName);
        return query.list();
    }


//    public List<Exam> getExamsResultsWithCriteria(String firstName, String lastname, Session session) {
//        Criteria criteria = session.createCriteria(Exam.class);
//        criteria.setMaxResults(10);
//        criteria.createAlias("student", "s");
//        criteria.add(Restrictions.and(
//                Restrictions.eq("s.firstname", firstName),
//                Restrictions.eq("s.lastname", lastname)
//        ));
//        return criteria.list();
//    }


}
