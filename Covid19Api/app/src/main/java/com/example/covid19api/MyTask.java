package com.example.covid19api;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MyTask extends AsyncTask<Void,Void,String> {
    String myurl="https://api.covid19api.com/dayone/country/IN";
    Context ct;
    RecyclerView rv1;
    ProgressDialog pd;
    public MyTask(MainActivity mainActivity, RecyclerView rv) {
        ct=mainActivity;
        rv1=rv;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(ct);
        pd.setMessage("Covid Details Loading......");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.show();

    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL u=new URL(myurl);
            HttpsURLConnection con=(HttpsURLConnection)u.openConnection();
            InputStream in=con.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            String line="";
            StringBuilder b=new StringBuilder();
            while ((line=reader.readLine())!=null){
                b.append(line);
            }

            return  b.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        pd.dismiss();
        List<Covid> covidlist=new ArrayList<>();
        try {
            JSONArray covidroot=new JSONArray(s);
            for(int i=covidroot.length()-1;i>=0;i--){
                JSONObject indexObject=covidroot.getJSONObject(i);
                String Month="";
                if((indexObject.getString("Date").substring(4, 8)).equals("-01-")){
                    Month=" - JAN - ";
                }
                else if((indexObject.getString("Date").substring(4, 8)).equals("-02-")){
                    Month=" - FEB - ";
                }
                else if((indexObject.getString("Date").substring(4, 8)).equals("-03-")){
                    Month=" - MAR - ";
                }
                else if((indexObject.getString("Date").substring(4, 8)).equals("-04-")){
                    Month=" - APR - ";
                }
                else if((indexObject.getString("Date").substring(4, 8)).equals("-05-")){
                    Month=" - MAY - ";
                }
                else if((indexObject.getString("Date").substring(4, 8)).equals("-06-")){
                    Month=" - JUN - ";
                }
                else if((indexObject.getString("Date").substring(4, 8)).equals("-07-")){
                    Month=" - JUL - ";
                }
                else if((indexObject.getString("Date").substring(4, 8)).equals("-08-")){
                    Month=" - AUG - ";
                }
                else if((indexObject.getString("Date").substring(4, 8)).equals("-09-")){
                    Month=" - SEP - ";
                }
                else if((indexObject.getString("Date").substring(4, 8)).equals("-10-")){
                    Month=" - OCT - ";
                }
                else if((indexObject.getString("Date").substring(4, 8)).equals("-11-")){
                    Month=" - NOV - ";
                }
                else if((indexObject.getString("Date").substring(4, 8)).equals("-12-")){
                    Month=" - DEC - ";
                }

                String Date=indexObject.getString("Date").substring(8, 10)+Month+indexObject.getString("Date").substring(0, 4);
                String active=indexObject.getString("Active");
                String recovered=indexObject.getString("Recovered");
                String Deaths=indexObject.getString("Deaths");
                Covid c=new Covid(Date,active,recovered,Deaths);
                covidlist.add(c);

            }
            rv1.setLayoutManager(new LinearLayoutManager(ct));
            rv1.setAdapter(new CovidAdapter(ct,covidlist));
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
