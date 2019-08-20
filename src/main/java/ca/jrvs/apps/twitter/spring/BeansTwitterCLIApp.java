package ca.jrvs.apps.twitter.spring;

import ca.jrvs.apps.twitter.TwitterCLIRunner;
import ca.jrvs.apps.twitter.dao.CrdRepo;
import ca.jrvs.apps.twitter.dao.TwitterRestDao;
import ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.service.TwitterServices;
import ca.jrvs.apps.twitter.service.TwitterServicesImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeansTwitterCLIApp {


    public static void main(String[] args) {
        ApplicationContext springAppCon = new AnnotationConfigApplicationContext(BeansTwitterCLIApp.class);
        TwitterCLIRunner clrun = springAppCon.getBean(TwitterCLIRunner.class);
        clrun.runner(args);

    }

    @Bean
    public HttpHelper httpHelper() {
        return new ApacheHttpHelper();
    }

    @Bean
    public CrdRepo crdDao(HttpHelper htHlp) {
        return new TwitterRestDao(htHlp);
    }

    @Bean
    public TwitterServices twtsrv(TwitterRestDao twDAO) {
        return new TwitterServicesImp(twDAO);
    }

    @Bean
    public TwitterCLIRunner cliRun(TwitterServices twsrv) {
        return new TwitterCLIRunner(twsrv);
    }
}
