package ca.jrvs.apps.twitter;


import ca.jrvs.apps.twitter.dao.CrdRepo;
import ca.jrvs.apps.twitter.dao.TwitterRestDao;
import ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.service.TwitterServices;
import ca.jrvs.apps.twitter.service.TwitterServicesImp;

public class TwitterCLIApp {

    public static void main(String[] args) {

        HttpHelper  htpHelp = new ApacheHttpHelper();
        CrdRepo dao = new TwitterRestDao(htpHelp);
        TwitterServices twServi = new TwitterServicesImp(dao);
        TwitterCLIRunner run = new TwitterCLIRunner(twServi);
        run.runner(args);

    }
}










