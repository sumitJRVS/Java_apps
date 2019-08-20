package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.TwitterRestDao;
import ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class TwitterRestDaoTest {

    ApacheHttpHelper helper;
    TwitterRestDao dao;

    @Before
    public void methodSetup() {
        helper = new ApacheHttpHelper();
        dao = new TwitterRestDao(helper);
    }

    @Test
    public void findById() {
        String id = "1153271358605996034";
        String text = "ThisisTest";


        Tweet receivedTweet = dao.findById(id);

        assertEquals(id, receivedTweet.getIdStr());
        assertEquals(text, receivedTweet.getText());
    }

    @Test
    public void create() {

        // Tweet Generated
        Tweet sendTweet = new Tweet();
        String text = "ThisJjunitTest";
        Coordinates coordinates = new Coordinates();
        coordinates.setCoordinates(Arrays.asList(50.0, 50.0));
        coordinates.setType("Point");

        // Send and receive tweet
        sendTweet.setText(text);
        sendTweet.setCoordinates(coordinates);

        Tweet recceivedTweet = dao.create(sendTweet);

        assertEquals(sendTweet.getText(), recceivedTweet.getText());
        assertEquals(sendTweet.getCoordinates(), recceivedTweet.getCoordinates());

        // Delete tweet
        Tweet goneTweet = dao.deleteById(recceivedTweet.getIdStr());
        Tweet nullTweet = dao.findById(goneTweet.getIdStr());
        assertEquals(null, nullTweet.getText());
    }
}