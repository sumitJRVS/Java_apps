package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdRepo;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * This is Junit test with Mockito injection for TwitterServiceImp class and specific method testing: POST
 */
@RunWith(MockitoJUnitRunner.class)
public class TwitterServicesImpTest {


    @Mock
    public CrdRepo crdRepoMock;

    @InjectMocks
    public TwitterServicesImp twitterServicesImp;

    @Test
    public void postTweet() {
        Tweet mockedTweet = new Tweet();
        mockedTweet.setText("MockTweetText");

        Coordinates coordinates = new Coordinates();
        List<Double> coords = new ArrayList<>();
        coords.add(10.0);
        coords.add(20.0);
        coordinates.setCoordinates(coords);
        mockedTweet.setCoordinates(coordinates);

        when(crdRepoMock.create(any())).thenReturn(mockedTweet);

        twitterServicesImp.postTweet("RandomPostTweet_1", 10.0, 20.0);

        twitterServicesImp.postTweet("RandomPostTweet_2", -80.0, -199.0);

    }
}