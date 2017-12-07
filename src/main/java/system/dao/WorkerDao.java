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

    public List<ReportCommonView> getReport(String date) {
        SessionFactory sessionFactory =
                new Configuration()
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Report> report = getList(session);
        session.close();
        sessionFactory.close();
        List<ReportCommonView> res = getRes(report);
        List<ReportCommonView> ans = new ArrayList<ReportCommonView>();
        for (int i = 0; i < res.size(); i++) {
            String dateFromWorkerList=res.get(i).getDate();
            String s=date.substring(0,2)+" ";
            switch (date.substring(3,5)){
                case "01" : s+="January";break;
                case "02" : s+="February";break;
                case "03" : s+="March";break;
                case "04" : s+="April";break;
                case "05" : s+="May";break;
                case "06" : s+="June";break;
                case "07" : s+="July";break;
                case "08" : s+="August";break;
                case "09" : s+="September";break;
                case "10" : s+="October";break;
                case "11" : s+="November";break;
                case "12" : s+="December";break;
            }
            s+=" "+date.substring(6,10);

            if (s.equals(dateFromWorkerList)) {
                ans.add(res.get(i));
            }
        }
        return ans;
    }
}
