package iuh.fit.se.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        Employee empSetter = (Employee) context.getBean("empSetter");
        empSetter.showInfo();

        System.out.println("------");

        Employee empConstructor = (Employee) context.getBean("empConstructor");
        empConstructor.showInfo();
    }
}
