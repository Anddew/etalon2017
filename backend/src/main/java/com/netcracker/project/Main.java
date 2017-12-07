package com.netcracker.project;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        runSpringDataAppContext();
//        runHibernateSession();
    }


    public static void runHibernateSession() {
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        CompanyEntity r = session.find(CompanyEntity.class, 1);
//        System.out.println(r);

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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("backend-spring-context.xml");


        //Repository
//        UserRepository studentRepository = context.getBean(UserRepository.class);
//        StudentEntity university = studentRepository.findByEmailAndPassword("ivanov@mail.ru", "ivanov");
//        System.out.println(university);

//        Service
//        StudentService studentService = context.getBean(StudentService.class);
//        boolean studentFound = studentService.login("ivanov@mail.ru", "ivanov");
//        System.out.println(studentFound);

//        FacultyService facultyService = context.getBean(FacultyService.class);
//        Set<FacultyEntity> faculties = facultyService.getFacultyRepository().findFacultyEntitiesByUniversityId(1);
//        System.out.println(faculties);

//        UserService userService = context.getBean(UserService.class);
//        UserRepository userRepository = userService.getUserRepository();
//        List<UserEntity> list = userRepository.findByRole(Role.STUDENT);
//        System.out.println(list);

//        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
//        Set<UserEntity> students = userService.getUserRepository().findAll();
//        System.out.println(students);

//        UserService userService = context.getBean(UserService.class);
//        StudentRepository studentRepository = userService.getStudentRepository();
//        List<StudentEntity> list = studentRepository.findByEducationForm(EducationForm.FULL_TIME);
//        System.out.println(list);
    }

//    public static UniversityEntity createUniversity() {
//        UniversityEntity result = new UniversityEntity();
//        result.setId(10);
//        result.setName("MITSO");
//        return result;
//    }

}
