package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdRepo;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TwitterServicesImp implements TwitterServices {

    CrdRepo<Tweet, String> dao;

    // Constructor
    @Autowired
    public TwitterServicesImp(CrdRepo dao) {
        this.dao = dao;
    }

    @Override
    public void postTweet(String text, Double latitude, Double longitude) {
        // Create a coordinate object
        Coordinates coordinates = new Coordinates( );
        // Create a List<> which can hold Latitude, Longitude Coordinates in single ArrayList.
        List<Double> coords = new ArrayList< >( );
        // Coordinates setup, fill args[] data and set type
        coords.add(latitude);  coords.add(longitude);
        coordinates.setCoordinates(coords);
        coordinates.setType("Point");

        // Create a Tweet Object, fill args[] data
        Tweet twtobj = new Tweet();
        twtobj.setText(text);
        twtobj.setCoordinates(coordinates);

        // Send Tweet object to DAO (flow for Tweet POST is: CLI> Service> DAO> HTTP)
        twtobj = dao.create(twtobj);
        if (twtobj.getId() != null) {
            System.out.println("You just POST the tweet : " + twtobj.getText());
        }
        else {
            System.out.println("Error in Posting");
        }
    }

    @Override
    public void showTweet(String id, String[] fields)  {
        Tweet tweet ;
        tweet= dao.findById(id);

        if (tweet.getText() == null) {
            System.out.println("Tweet ID does not exists.");
        } else {

        Class tweetClass;
        tweetClass= tweet.getClass();

        Method[] methods;
        methods = tweetClass.getMethods();

        List<Method> methodList = Arrays.stream(methods)
                .filter(metho -> metho.getName().startsWith("get"))
                .collect(Collectors.toList());

        List<String> methodNames = methodList.stream()
                .map(met-> met.getName().substring(3).toLowerCase())
                .collect(Collectors.toList());

        int i;
            for (String s : fields) {
                s = s.toLowerCase();
                System.out.print("\t" + s + ":");
                i = methodNames.indexOf(s);
                if (i > -1) {

                    try {
                        System.out.println(methodList.get(i).invoke(tweet));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                else System.out.println("No such field exist in the Tweet List<>");
            }
        }
    }

    @Override
    public void deleteTweet(String[] id) {
        Tweet tweet;

        if (id.length == 0) { System.out.println("Tweet ID does not exists."); }

        else {
            for (String ids : id) {
                tweet = dao.deleteById(ids);
                if (tweet.getText() == null) {
                    System.out.println("Tweet unavailable");
                } else {
                    System.out.println("Delete successful of tweet with message: " + tweet.getText());
                }
            }

        }
    }
}
