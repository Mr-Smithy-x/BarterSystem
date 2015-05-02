package com.hackathon.barter.web;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlton on 5/2/2015.
 */
public class WebClient {


    public boolean DownloadFile(String url, String destination) throws MalformedURLException, IOException{

        try{URL Url = new URL(url);
            HttpURLConnection http = (HttpURLConnection)Url.openConnection();
            http.connect();
            BufferedInputStream is = new BufferedInputStream(http.getInputStream());
            FileOutputStream fos = new FileOutputStream(destination);
            int line = 0;
            while((line = is.read()) != -1){
                fos.write(line);
            }
            fos.flush();
            fos.close();
            is.close();
            http.disconnect();
            return true;
        }catch(Exception ex){

            ex.printStackTrace();
        }
        return false;
    }
    public String DownloadString(String url) throws MalformedURLException, IOException{
        URL Url = new URL(url);
        HttpURLConnection http = (HttpURLConnection)Url.openConnection();
        http.connect();
        InputStream is = http.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while((line = br.readLine()) != null){
            sb.append(line);
        }
        is.close();
        isr.close();
        br.close();
        http.disconnect();
        return sb.toString();
    }
    public String makegetRequest(String Url) throws IOException, ParseException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet pageGet = new HttpGet(Url);

        HttpResponse resp = httpclient.execute(pageGet);
        HttpEntity entity = resp.getEntity();
        return EntityUtils.toString(entity);

    }

    public String makegetRequest(String Url, List<NameValuePair> pairs) throws IOException, ParseException{
        try{
            HttpClient httpclient = new DefaultHttpClient();
            String param = "";
            for(int i = 0; i < pairs.size(); i++){
                if(i == 0) param += "?" + pairs.get(i);
                else param += "&" + pairs.get(i);
            }

            HttpGet pageGet = new HttpGet(Url + param);

            HttpResponse resp = httpclient.execute(pageGet);
            HttpEntity entity = resp.getEntity();
            return EntityUtils.toString(entity).split("<")[0];
        }catch(Exception et){
            return et.toString();
        }
    }

    public String PostRequest(String url, List<NameValuePair> params) throws UnsupportedEncodingException, IOException{
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        HttpResponse resp = httpClient.execute(httppost);
        HttpEntity entity = resp.getEntity();
        if(entity != null){
            return EntityUtils.toString(entity).split("<")[0];
        }
        return null;
    }
    public String makePostRequest(String url, String param) throws MalformedURLException, IOException{
        URL Url = new URL(url);
        HttpURLConnection con = (HttpURLConnection)Url.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        String USER_AGENT = "Mozilla/5.0";
        con.setRequestProperty( "User-Agent", USER_AGENT );
        con.setRequestProperty( "Accept-Language", "en-US,en;q=0.5" );

        String urlParameters = param;

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

        return response.toString();
    }
    public Object[] DownloadStringLineByLine(String url) throws MalformedURLException, IOException {
        URL Url = new URL(url);
        HttpURLConnection http = (HttpURLConnection)Url.openConnection();
        http.connect();
        InputStream is = http.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        List<String> sb = new ArrayList<String>();
        String line = null;
        while((line = br.readLine()) != null){
            sb.add(line);
        }
        is.close();
        isr.close();
        br.close();
        http.disconnect();
        return sb.toArray();
    }

}
