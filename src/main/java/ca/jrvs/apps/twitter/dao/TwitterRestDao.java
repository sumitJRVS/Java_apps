package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dto.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


// Data Access Object which handles tweet object
// (Dao depends on HttpHelper)
@Repository
public class TwitterRestDao implements CrdRepo<Tweet, String> {

    //Construct URI
    private static final String API_ROOT_URI = "https://api.twitter.com";
    private static final String POST_URI = "/1.1/statuses/update.json";
    private static final String SHOW_URI = "/1.1/statuses/show.json";
    private static final String DELETE_URI = "/1.1/statuses/destroy.json";

    private HttpHelper httpHelp;

    //constuctor
    @Autowired
    public TwitterRestDao(HttpHelper htpHlp) {
        this.httpHelp = htpHlp;
    }

    @Override
    public Tweet create(Tweet twt) {
        //construct URI
        Tweet twtObj = new Tweet();
        URI uri = null;

        try {
            if (twt.getCoordinates() == null) {
                uri = new URI(API_ROOT_URI + POST_URI + "?trim_user=true&" + "status=" + twt.getText());

            } else {
                List<Double> coordinates = twt.getCoordinates().getCoordinates();
                uri = new URI(API_ROOT_URI + POST_URI + "?trim_user=true&" + "long=" + twt.getCoordinates().getCoordinates().get(0) + "&lat=" + twt.getCoordinates().getCoordinates().get(1) + "&status=" + twt.getText());
            }
            String resultStr = EntityUtils.toString(httpHelp.httpPost(uri).getEntity());
            twtObj = toObjectFromJson(resultStr, Tweet.class);
        } catch (URISyntaxException e1) {
            System.out.println("URI syntax error");
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return twtObj;

        // Re-serialize response to Tweet object back

    }

    @Override
    public Tweet deleteById(String id) {
        //construct URI
        URI uri = null;

        try {
            uri = new URI(API_ROOT_URI + DELETE_URI + "?id=" + id);
            //example uri = https://api.twitter.com/1.1/statuses/destroy.json?id=11111111
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        //Execute HTTP Request
        String resultStr = null;
        try {
            resultStr = EntityUtils.toString(httpHelp.httpPost(uri).getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Re-serialize response to Tweet object back
        Tweet twtObj = null;
        try {
            twtObj = toObjectFromJson(resultStr, Tweet.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return twtObj;


    }

    @Override
    public Tweet findById(String id) {
        //construct URI
        URI uri = null;
        try {
            uri = new URI(API_ROOT_URI + SHOW_URI + "?id=" + id);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        //Execute HTTP Request
        String resultStr = null;
        try {
            resultStr = EntityUtils.toString(httpHelp.httpGet(uri).getEntity());
            System.out.println(resultStr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Tweet twtObj = null;
        try {
            twtObj = toObjectFromJson(resultStr, Tweet.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return twtObj;
    }

    public <T> T toObjectFromJson(String json,  Class clazz) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return (T) mapper.readValue(json, clazz);


    }
/*
    public Tweet toObjectFromJson(String json, Class clazz) {
        ObjectMapper objmapToOBJ = new ObjectMapper(); // created a new object
        try {
            return (Tweet) objmapToOBJ.readValue(json, clazz);  // This is returning JSON string to Tweet object
        } catch (JsonProcessingException err404) {
            err404.printStackTrace();
            throw new RuntimeException(err404);
        } catch (IOException err404) {
            err404.printStackTrace();
            throw new RuntimeException(err404);
        }
    }
*/
}







