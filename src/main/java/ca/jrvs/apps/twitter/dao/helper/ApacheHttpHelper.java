package ca.jrvs.apps.twitter.dao.helper;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;

@Component
public class ApacheHttpHelper implements HttpHelper {

    private static String CONSUMER_KEY = System.getenv("consumerkey");
    private static String CONSUMER_SECRET = System.getenv("consumersecret");
    private static String ACCESS_TOKEN = System.getenv("accesstoken");
    private static String TOKEN_SECRET = System.getenv("tokensecret");
    OAuthConsumer authConsum;
    HttpClient htpCli = new DefaultHttpClient();

    //constructor and setup OAuth bind
    public ApacheHttpHelper() {
        authConsum = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        authConsum.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);
    }

    // By  default this will execute
    public HttpResponse htpReq(HttpUriRequest url) {
        try {
            authConsum.sign(url);
        }   //sing Authentication request
        catch (OAuthMessageSignerException e1) {
            e1.printStackTrace();
        } catch (OAuthCommunicationException e2) {
            e2.printStackTrace();
        } catch (OAuthExpectationFailedException e3) {
            e3.printStackTrace();
        }


        try {
            HttpResponse htpReq = htpCli.execute(url);
            return htpReq;
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return null;

    }


    //POST request from HttpResponse class if no tweet exist
    @Override
    public HttpResponse httpPost(URI urii) {
        HttpPost url = new HttpPost(urii);
        HttpResponse ansPOST = htpReq(url);
        return ansPOST;
    }

    //GET request from HttpResponse class
    @Override
    public HttpResponse httpGet(URI uri) {
        HttpGet url = new HttpGet(uri);
        HttpResponse ansGet = htpReq(url);
        return ansGet;
    }

    //POST request from Httpresponse class if the tweet exist
    @Override
    public HttpResponse httpPost(URI uri, StringEntity strEnty) {
        HttpPost url = new HttpPost(uri);
        HttpResponse ansPOST = htpReq(url);
        ansPOST.setEntity(strEnty); //this is extra step to set the string entitiy to the post
        return ansPOST;
    }


}


