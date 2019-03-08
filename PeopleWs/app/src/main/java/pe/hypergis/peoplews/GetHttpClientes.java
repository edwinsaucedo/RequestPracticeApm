package pe.hypergis.peoplews;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by Marlon on 17/11/2017.
 */

public class GetHttpClientes extends AsyncTask<Void, Void, String> {
    private List<Person> httpList;
    private RecyclerView httpRecycler;
    private RecyclerView.Adapter httpAdapter;
    private Context httpContext;
    ProgressDialog progressDialog;

    public GetHttpClientes(List<Person> httpList, RecyclerView httpRecycler, RecyclerView.Adapter httpAdapter, Context httpContext) {
        this.httpList = httpList;
        this.httpRecycler = httpRecycler;
        this.httpAdapter = httpAdapter;
        this.httpContext = httpContext;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(httpContext, "Descargando", "por favor, espere");
    }

    @Override
    protected String doInBackground(Void... params) {
        String result = null;
        try {

            String wsURL = "https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=json";
            URL url = new URL(wsURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            result = inputStreamToString(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();
        try {
            JSONObject jsonObject = new JSONObject(URLDecoder.decode(s, "UTF-8" ));
            //JSONArray jsonArray = jsonObject.getJSONArray("clientes");
            JSONArray jsonArray = jsonObject.getJSONArray("Results");
            for (int i = 0; i < jsonArray.length(); i++) {
                /*String dni = jsonArray.getJSONObject(i).getString("cDNI");
                String nombre = jsonArray.getJSONObject(i).getString("cNombre");
                int edad = Integer.parseInt(jsonArray.getJSONObject(i).getString("eEdad"));
                String biografia = jsonArray.getJSONObject(i).getString("cBiografia");
                String fotourl = jsonArray.getJSONObject(i).getString("cFotoURL");

                */
                String dni = jsonArray.getJSONObject(i).getString("cDNI");
                String nombre = jsonArray.getJSONObject(i).getString("cNombre");
                int edad = Integer.parseInt(jsonArray.getJSONObject(i).getString("eEdad"));
                String biografia = jsonArray.getJSONObject(i).getString("cBiografia");
                String fotourl = jsonArray.getJSONObject(i).getString("cFotoURL");

                this.httpList.add(new Person(fotourl, nombre, dni, edad, biografia));
            }
            // Crear un nuevo adaptador
            httpAdapter = new PersonAdapter(this.httpList);
            httpRecycler.setAdapter(this.httpAdapter);

        } catch (JSONException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private String inputStreamToString(InputStream is) {
        String rLine = "";
        StringBuilder answer = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader rd = new BufferedReader(isr);
        try {
            while ((rLine = rd.readLine()) != null) {
                answer.append(rLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer.toString();
    }
}
