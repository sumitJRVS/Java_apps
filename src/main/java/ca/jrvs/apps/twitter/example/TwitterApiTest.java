package ca.jrvs.apps.twitter.example;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


//store all secrets into bash profile in Bash terminal as local global env variable using cmd vi ~/.bash_profile
// or IntelliJ local environment Run >>Edit_Config >> add variables here
public class TwitterApiTest {

    private static String CONSUMER_KEY = System.getenv("consumerkey");
    private static String CONSUMER_SECRET = System.getenv("consumersecret");
    private static String ACCESS_TOKEN = System.getenv("accesstoken");
    private static String TOKEN_SECRET = System.getenv("tokensecret");


    public static void main(String[] args) throws Exception {

        //setting up the OAuth 1.0
        OAuthConsumer consumerAuth = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumerAuth.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);


        // POST = HTTPhelper function using post request
        //String adder = "Today 11 - jul - 2019 ";
        //String add1 = URLEncoder.encode(adder, "UTF-8") ; //this function basically converts string into UTF-8 so you dont need %20 typped in whitespace
        //HttpPost requestedHTTP = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status=Weekend%20is%20her%20yahooo%20time%20"+ System.currentTimeMillis() + "%20" + add1);


        // GET to HTTP using get request
        //HttpGet requestedHTTP = new HttpGet("Https://api.twitter.com/1.1/statuses/show.json?id=1149000308925849601");

        // new BEST POST function
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost requestedurl = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status=Weekend%20is%20her%20yahooo%20time%20" + "" + System.currentTimeMillis());
        consumerAuth.sign(requestedurl);
        HttpResponse responseHTTP = httpClient.execute(requestedurl);
        System.out.println(EntityUtils.toString(responseHTTP.getEntity()));


        // DELETE HTTP using post request
        //HttpPost requestedHTTP = new HttpPost("https://api.twitter.com/1.1/statuses/destroy.json?id=1151124970493423617");
        //https://api.twitter.com/1.1/statuses/destroy.json?id=1151124970493423617

        //Sign the request with Auth // HTTP + OAuth 1.0 = work done!
        System.out.println("11-jul-2019 - done + Http request Headers:");


        //add-print headers here:
        //Arrays.stream(requestedHTTP.getAllHeaders());
        //System.out.println(Arrays.stream(requestedHTTP.getAllHeaders()));
        // Arrays.stream(requestedHTTP.getAllHeaders()).forEach(System.out::println);


        //get request and post request same
        //HttpClient httpCli = new DefaultHttpClient();
        //HttpResponse httpRes = httpCli.execute(urrl); //this execute your request to HTTP and your work is done here


        //System.out.println(HttpResponse.httpRes = httpCli.execute(requestedHTTP));
        //System.out.println(EntityUtils.toString(httpRes.getEntity()));


        //System.out.println(httpRes.getStatusLine().getStatusCode());
        System.out.println("**************");


        //Arrays.stream (httpRes.getAllHeaders()).forEach(System.out::println);


    }
}
