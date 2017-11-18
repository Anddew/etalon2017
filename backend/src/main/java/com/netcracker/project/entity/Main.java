package com.netcracker.project.entity;

import com.netcracker.project.entity.company.CompanyEntity;
import com.netcracker.project.entity.university.UniversityEntity;
import com.netcracker.project.repository.UniversityRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        runSpringDataAppContext();
//        runHibernateSession();
    }


    public static void runHibernateSession() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        CompanyEntity r = session.find(CompanyEntity.class, 1);
        System.out.println(r);

//        Transaction tr1 = session.beginTransaction();
//        University university = createUniversity();
//        Integer id = (Integer) session.save(university);
//        tr1.commit();
//        System.out.println(id);

//        Transaction tr2 = session.beginTransaction();
//        session.delete(university);
//        tr2.commit();
    }

    public static void runSpringDataAppContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UniversityRepository universityRepository = context.getBean(UniversityRepository.class);
        UniversityEntity university = universityRepository.findById(2);
        System.out.println(university);
    }

    public static UniversityEntity createUniversity() {
        UniversityEntity result = new UniversityEntity();
        result.setId(10);
        result.setName("MITSO");
        return result;
    }

}
