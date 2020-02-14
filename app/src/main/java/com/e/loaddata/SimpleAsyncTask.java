package com.e.loaddata;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SimpleAsyncTask extends AsyncTask<InputStream, Void, ArrayList<DataDiri>> {

    WeakReference<RecyclerView> recyclerViewWeakReference;
    Context context;

    public SimpleAsyncTask(Context context, RecyclerView recyclerView){
        this.recyclerViewWeakReference = new WeakReference<>(recyclerView);
        this.context = context;
    }

    @Override
    protected ArrayList<DataDiri> doInBackground(InputStream... jsonParam) {
        ArrayList<DataDiri> dataDiri = null;
        String json = loadJsonDataFromRaw(jsonParam[0]);
        dataDiri = deserialisasiJSON(json);

        return dataDiri;

    }

    @Override
    protected void onPostExecute(ArrayList<DataDiri> data) {


        RecyclerView recyclerView = this.recyclerViewWeakReference.get().findViewById(R.id.rv_cardview);

        try{
            RvCardAdapter rvCardAdapter = new RvCardAdapter(context, data);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(rvCardAdapter);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String loadJsonDataFromRaw(InputStream isParam){
        String json = null;
        try{
            InputStream is = isParam;
            /*int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json =  new String(buffer, "UTF-8");*/
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            StringBuffer sb = new StringBuffer();
            String eachLine;
            while ((eachLine = reader.readLine()) != null){
                sb.append(eachLine);
            }

            json = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    public ArrayList<DataDiri> deserialisasiJSON(String jsonParam){
        ArrayList<DataDiri> data = new ArrayList<>();
        try {
            JSONArray jsonData = new JSONArray(jsonParam);

            for (int i=0; i < jsonData.length(); i++) {
                JSONObject jsonObject = jsonData.getJSONObject(i);
                String nama = jsonObject.getString("nama");
                String phone = jsonObject.getString("phone");
                String email = jsonObject.getString("email");
                String city = jsonObject.getString("city");
                String alamat = jsonObject.getString("alamat");

                DataDiri dataDiri = new DataDiri(nama, phone, email, city, alamat);
                data.add(dataDiri);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }
}
