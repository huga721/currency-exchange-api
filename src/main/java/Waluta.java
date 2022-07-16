
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Waluta {

    HttpURLConnection polaczenie;
    private BufferedReader reader;
    String string;
    StringBuffer stringBuffer;

    int timeout = 5000;
    int status;

    public Waluta(){
        stringBuffer = new StringBuffer();
    }

    public void converter(String from, String to, int amount){
        try {
            URL url = new URL("https://api.exchangerate.host/convert?from="+ from +"&to="+ to +"&amount="+amount);
            polaczenie = (HttpURLConnection) url.openConnection();

            polaczenie.setRequestMethod("GET");  // Metoda GET HTTP
            polaczenie.setConnectTimeout(timeout); //
            polaczenie.setReadTimeout(timeout);

            status = polaczenie.getResponseCode();

            if (status > 299){
                reader = new BufferedReader(new InputStreamReader(polaczenie.getErrorStream()));
                while ((string = reader.readLine()) != null){
                    stringBuffer.append(string);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(polaczenie.getInputStream()));
                while ((string = reader.readLine()) != null){
                    stringBuffer.append(string);
                }
                reader.close();
            }
            // System.out.println(stringBuffer);
            parse();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            polaczenie.disconnect();
        }
    }

    public void parse(){

        JSONObject json = new JSONObject(stringBuffer.toString());
        double kurs = json.getDouble("result");
        System.out.println(kurs);

    }
}