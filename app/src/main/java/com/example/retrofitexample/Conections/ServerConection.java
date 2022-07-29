package com.example.retrofitexample.Conections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ServerConection {
    private static HttpURLConnection conn;

    public String getConn(){
        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();

        try{
            URL url = new URL("https://jsonplaceholder.typicode.com/albums");
            conn = (HttpURLConnection) url.openConnection();

            // Request setup
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);// 5000 milliseconds = 5 seconds
            conn.setReadTimeout(5000);

            // Test if the response from the server is successful
            int status = conn.getResponseCode();

            if (status >= 300) {
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            else {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
                System.out.println(responseContent.toString());
            }

            System.out.println(responseContent.toString());
            return (responseContent.toString());
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            conn.disconnect();
        }

        return (responseContent.toString());

    }
}
