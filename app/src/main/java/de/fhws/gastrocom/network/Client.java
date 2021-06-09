package de.fhws.gastrocom.network;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {

    private HttpURLConnection connection;
    private OutputStreamWriter os;
    private BufferedReader is;

    public Client(String url) throws IOException {
        connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        os = new OutputStreamWriter(connection.getOutputStream());
        is = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    }


    /**
     * sends a http post request to the server
     * @param json json file which will be posted
     * @throws IOException
     */
    public void write(JSONObject json) throws IOException {
        connection.connect();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        os.write(json.toString());
        os.flush();
    }

    public JSONObject getRequest(String urlParams) throws IOException {
        connection.connect();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        os.write(urlParams);
        os.flush();

       //TODO make this shit work
        return null;
    }

}
