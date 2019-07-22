package ca.jrvs.apps.twitter.example;

import ca.jrvs.apps.twitter.example.dto.Company;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

//jackson lib-API imported helps us to converted back and forth java obj<-> JSON string.
public class JSONandOBJparser {


    /**
     * Convert Java OBJ --> JSON string (concept = writeValue() = serialization)
     *
     * @param object input object      @return JSON String       @throws JsonProcessingException
     */
    public static String toJson(Object object, boolean prettyJson, boolean includeNullValues) {

        ObjectMapper objmapToJson = new ObjectMapper(); // created a new object name= objmap

        try {
            String jsonStr = new String(); //created new string
            jsonStr = objmapToJson.writeValueAsString(object); // object converted to string using util function...
            return (jsonStr);  //string can be printed easily using sout!

        } catch (JsonProcessingException err404) {
            err404.printStackTrace();
            throw new RuntimeException(err404);
        }
    }


    /**
     * JSON string -->  Java OBJ  ((Parse JSON string to a object)) (concept = readval() = DeSerialization)
     *
     * @param json  JSON str
     * @param clazz object class
     * @param <T>   Type
     * @return Object
     * @throws IOException
     */
    public static <T> T toObjectFromJson(String json, Class clazz) {
        ObjectMapper objmapToOBJ = new ObjectMapper(); // created a new object name= objmap

        try {

            return (T) objmapToOBJ.readValue(json, clazz);  // T is imp otherwise class is object and string alll mixed up

        } catch (JsonProcessingException err404) {
            err404.printStackTrace();
            throw new RuntimeException(err404);
        } catch (IOException err404) {
            err404.printStackTrace();
            throw new RuntimeException(err404);
        }

    }





    //copy pasted above from  Edward file
    public static final String demo1 = "{\n"
            + "   \"symbol\":\"AAPL\",\n"
            + "   \"companyName\":\"Apple Inc.\",\n"
            + "   \"exchange\":\"Nasdaq Global Select\",\n"
            + "   \"description\":\"Apple Inc is designs, manufactures and markets mobile communication and media devices and personal computers, and sells a variety of related software, services, accessories, networking solutions and third-party digital content and applications.\",\n"
            + "   \"CEO\":\"Timothy D. Cook\",\n"
            + "   \"sector\":\"Technology\",\n"
            + "   \"financials\":[\n"
            + "      {\n"
            + "         \"reportDate\":\"2018-12-31\",\n"
            + "         \"grossProfit\":32031000000,\n"
            + "         \"costOfRevenue\":52279000000,\n"
            + "         \"operatingRevenue\":84310000000,\n"
            + "         \"totalRevenue\":84310000000,\n"
            + "         \"operatingIncome\":23346000000,\n"
            + "         \"netIncome\":19965000000\n"
            + "      },\n"
            + "      {\n"
            + "         \"reportDate\":\"2018-09-30\",\n"
            + "         \"grossProfit\":24084000000,\n"
            + "         \"costOfRevenue\":38816000000,\n"
            + "         \"operatingRevenue\":62900000000,\n"
            + "         \"totalRevenue\":62900000000,\n"
            + "         \"operatingIncome\":16118000000,\n"
            + "         \"netIncome\":14125000000\n"
            + "      }\n"
            + "   ],\n"
            + "   \"dividends\":[\n"
            + "      {\n"
            + "         \"exDate\":\"2018-02-09\",\n"
            + "         \"paymentDate\":\"2018-02-15\",\n"
            + "         \"recordDate\":\"2018-02-12\",\n"
            + "         \"declaredDate\":\"2018-02-01\",\n"
            + "         \"amount\":0.63\n"
            + "      },\n"
            + "      {\n"
            + "         \"exDate\":\"2017-11-10\",\n"
            + "         \"paymentDate\":\"2017-11-16\",\n"
            + "         \"recordDate\":\"2017-11-13\",\n"
            + "         \"declaredDate\":\"2017-11-02\",\n"
            + "         \"amount\":0.63\n"
            + "      }\n"
            + "   ]\n"
            + "}";




    //implemented toObj class and it works...
    //method to return output  into the JSON string and print JSON
    public static void main(String[] args) throws IOException {

    //ObjectMapper obj1 = new ObjectMapper();
    Company com = toObjectFromJson(demo1, Company.class);    // passing the demo1 =edward given string as copied on top coding line
        System.out.println(com.toString());
    }


}

