package rest_assured;

public class Payload {

    public static String addBook(){
        String payload="{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\"kfrgh\",\n" +
                "\"aisle\":\"220043ujgrdhdsw67\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";

        return payload;
    }
    public static String addBook(String isbn,String aisle){
        String payload="{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";

        return payload;
    }
}
