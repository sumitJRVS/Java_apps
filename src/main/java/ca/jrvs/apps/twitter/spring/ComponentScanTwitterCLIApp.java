package ca.jrvs.apps.twitter.spring;

import ca.jrvs.apps.twitter.TwitterCLIRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


    @Configuration
    @ComponentScan
    public class ComponentScanTwitterCLIApp {

        public static void main(String[] args) {
            ApplicationContext springAppCon = new AnnotationConfigApplicationContext(ComponentScanTwitterCLIApp.class);
            TwitterCLIRunner clrun = springAppCon.getBean(TwitterCLIRunner.class);
            clrun.runner(args);

        }
    }

