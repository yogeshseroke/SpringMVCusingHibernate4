package bao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import model.Student;
@Controller
public class StudentsController {
	@RequestMapping("/stu")
	public ModelAndView stuLoad()
	{
		return new ModelAndView("stuview","command",new Student());
	}
	@RequestMapping("/stulogic")
	public ModelAndView stuLogic(@ModelAttribute("jobportal")Student s)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(s);
		tx.commit();
		sess.close();
		ModelAndView mv = new ModelAndView("stuview","command",new Student());
		mv.addObject("key", "Student registered successfully");
		return mv;
	}
}