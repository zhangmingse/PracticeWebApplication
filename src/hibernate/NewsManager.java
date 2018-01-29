package hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entity.News;

public class NewsManager {
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		News news = new News();
		news.setTitle("新闻标题");
		news.setContent("新闻内容");
		session.save(news);
		tx.commit();
		session.close();
		sf.close();
		
	}

}
