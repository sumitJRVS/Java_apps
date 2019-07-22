package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.service.TwitterServices;

public class TwitterCLIRunner {

    private TwitterServices servicesTransferred;

    //Constructor
    public TwitterCLIRunner(TwitterServices services) {
        this.servicesTransferred = services;
    }

    public void runner(String[] runArgs) {

        if (runArgs.length <= 1) {

            System.out.println("You need to enter atleast 2 args: POST/SHOW/GET/DELETE TWEET");
        }

        switch (runArgs[0].toLowerCase()) {
            case "post": {
                postTweet(runArgs);
                break;
            }
            case "show": {
                showTweet(runArgs);
                break;
            }
            case "delete": {
                deleteTweet(runArgs);
                break;
            }
            default: {
                System.out.println("Usage: Your first Argument must be either of 'POST/SHOW/GET/DELETE'.");
                break;
            }
        }
    }

    private void showTweet(String[] args) {
        if (args.length != 3) {
            System.out.println("Give me 3 input as per given format");
        } else if (args.length < 3) {
            System.out.println("Give me 3 input /given format");
        } else if (args.length > 3) {
            System.out.println("illegal no# of args, follow the format: SHOW TweetID Field-1,2,3(TweetCoordinates)");
        }

        String[] cordi = args[2].split(",");
        servicesTransferred.showTweet(args[1], cordi);
    }

    private void postTweet(String[] args) {
        if (args.length < 3) {
            System.out.println("Not enough no# of Argument, follow the format: POST 'Text' TweetCoordinates Latitude, Longitude");
        }

        if (args[1].length() < 140) {

            String[] cordi = args[2].split(",");
            Double latitude = Double.parseDouble(cordi[0]);
            Double longitude = Double.parseDouble(cordi[1]);

            if (latitude >= 90.0 || latitude <= -90.0) {
                System.out.println("Illegal Argument format for coordinates , Enter Latitude between -90.0 to 90.0 ");
            }

            if (longitude >= 180.0 || longitude <= -180.0) {
                System.out.println("Illegal Argument format for coordinates , Enter longitude between -180.0 to 180.0 ");
            }
            servicesTransferred.postTweet(args[1], latitude, longitude);
        }
    }

    private void deleteTweet(String[] args) {
        if (args.length < 2) {
            System.out.println("Invalid format of Argument, Type format: atleast 2 argument: DELETE TweetID#1, TweetID#2...IDs");
        }

        String[] idss = args[1].split(",");

        servicesTransferred.deleteTweet(idss);
    }


}



