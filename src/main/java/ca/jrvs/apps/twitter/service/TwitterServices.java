package ca.jrvs.apps.twitter.service;

public interface TwitterServices {

    void postTweet(String text, Double latitude, Double longitude);

    void showTweet(String id, String[] fields);

    void deleteTweet(String[] ids);

}
