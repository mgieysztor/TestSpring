package Library;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by RENT on 2017-01-28.
 */
public class LibraryMain {
    public static void main(String[] args) throws UnirestException {
        String ipNumber = "46.101.101.143";
        String port = "9001";

        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });

//        System.out.println("0 - wyjście z programu");
        System.out.println("1 - wyświetl dostępne ksiązki"); //list allbooks
        System.out.println("2 - wybierz książkę wg autora");
        System.out.println("3 - dodaj książkę do księgozbioru");
        System.out.println("4 - usuń książkę z księgozbioru");

        int choosenOption = new Scanner(System.in).nextInt();

        switch (choosenOption){

            case 1:
                //ksiązki jako tablica
                JSONArray jsonArray = Unirest.
                        get("http://" + ipNumber + ":" + port + "" + "/books")
                        .asJson()
                        .getBody()
                        .getArray();

                for (int i = 0; i < jsonArray.length(); i++) {
                    System.out.println(jsonArray.get(i).toString());
                }
            case 2:

            case 3:

            case 4:

            default:

        }

//        Book book = new Book();

        //wysztkie ksiązki
        String response = Unirest.
                get("http://" + ipNumber + ":" + port + "" + "/books")
                .asString()
                .getBody();



        //książka po id
        Book book  = Unirest.
                get("http://" + ipNumber + ":" + port + "" + "/books/ABC")
//                .routeParam("id","ABC")
                .asObject(Book.class)
                .getBody();




//        System.out.println("Body\n" + body);

        System.out.println(response);


        //switch case


        System.out.println();


    }


}
