package com.CourseScheduleBuilder;

import com.CourseScheduleBuilder.Model.Course;
import com.CourseScheduleBuilder.Model.User;
import com.CourseScheduleBuilder.Repositories.CourseRepo;
import com.CourseScheduleBuilder.Repositories.UserRepo;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private CourseRepo courseRepo;
    private UserRepo userRepo;

    private Logger LOG = LoggerFactory.getLogger(Application.class);

    @Autowired
    public void setCourseRepo(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Course course1 = new Course();
        course1.setName("SOen 341");
        course1.setCredit(3);
        course1.setPreReq("comp346");
        course1.setCoReq("ENGR 301");

        courseRepo.save(course1);

        Course course2 = new Course();
        course2.setName("ENGR 233");
        course2.setCredit(3);
        course2.setPreReq("MATH 205");
        course2.setCoReq("ENGR 213");

        courseRepo.save(course2);

        List<Course> courseData = courseRepo.findAll();

        for (Course Course : courseData) {
            LOG.info("Course found :" + Course.toString());

        }

        Course resultCourse = courseRepo.findByName("ENGR 233");
        LOG.info("course found by name : " + resultCourse.toString());

        List<Course> result = courseRepo.findByCreditAndPreReq(4, "MATH 205");

        for (Course Course : result) {
            LOG.info("Matching results are " + Course.toString());
        }


        User user1 = new User();
        user1.setFirstName("Moataz");
        user1.setLastName("Fawzy");
        user1.setPassword("SOEN341");
        user1.setUsername("moataz_fawzy@live.com");
        user1.setEWT(false);
        user1.addToPrereqs("COMP348");
        user1.addToPrereqs("COMP352");
        user1.addToPrereqs("SOEN391");


        userRepo.save(user1);

        User user2 = new User();
        user2.setFirstName("Terrill");
        user2.setLastName("Fancott");
        user2.setUsername("SuperMan@live.com");
        user2.setPassword("20BONUSPOINTS");
        user2.setEWT(false);
        user2.addToPrereqs("ENGR233");



        userRepo.save(user2);

        List<User> userData = userRepo.findAll();
        System.out.println("--------------");
        for(int i=0; i<userData.size();i++) {
            for (int j=0; j<userData.get(i).getPrereqs().size(); j++)
            System.out.println(userData.get(i).getPrereqs().get(j));
        }
        System.out.println("--------------");

        for (User User : userData) {
            LOG.info("Course found :" + User.toString());

        }

        User resultUser = userRepo.findByFirstName("Moataz");
        LOG.info("User found by name : " + resultUser.toString());

        List<User> results = userRepo.findByUsernameAndPassword("SuperMan@live.com", "20BONUSPOINTS");

        for (User User : results) {
            LOG.info("Matching results are : " + User.toString());
        }

        /**
         * This will create the h2 databse server, then start it
         * then it will execute a few SQL commands and load the csv file
         * First thing you need to do is change the path to the csv file
         * Secondly, you need to download and add the h2database library if you don't have it:
         * 1 - go to this link http://www.h2database.com/html/download.html
         * 2 - download the Jar file maven.org
         * 3 - File -> Project structure -> libraries
         * 4 - click on  the '+' above all the maven libraries and click on Java
         * 5 - search for the jar file and finally click apply
         */
        try {
            Server server = Server.createTcpServer(args).start();
            server = Server.createTcpServer("-tcpAllowOthers").start();
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/DB", "sa", "");


            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE COURSE");                         //TODO DON'T FORGET TO CHANGE THE PATH
            statement.execute("CREATE TABLE COURSE AS SELECT * FROM CSVREAD('/home/eomasah/git/Course_Schedule_Builder/courseInfo.csv')");
            statement.close();

            conn.close();
            server.stop();
        } catch (Exception e) {
            System.out.println("Something wrong with starting h2");
            e.printStackTrace();
        }

    }
}
