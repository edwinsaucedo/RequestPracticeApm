package com.example.practicante3.wsvehiculoedwin;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import com.apm.request.abstracts.RequestListener;
import com.apm.request.enums.RequestType;
import com.apm.request.exceptions.ExceptionManager;
import com.apm.request.http.controllers.Request;
import com.apm.request.models.RequestConfiguration;
import com.apm.request.models.Response;
import com.apm.request.utils.FileUtils;
import com.google.gson.Gson;
import com.yuyh.jsonviewer.library.JsonRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    private List<Vehiculo> items = new ArrayList();
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private final static String TAG = MainActivity.class.getSimpleName();
    private RequestConfiguration mRequestConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);*/

        // Usar un administrador para LinearLayout
        // lManager = new LinearLayoutManager(this);
        //recycler.setLayoutManager(lManager);

        mRequestConfiguration = new Gson().fromJson(
                FileUtils.ReadRawTextFile(getApplicationContext(), R.raw.request),
                RequestConfiguration.class);


        ((JsonRecyclerView) findViewById(R.id.rv_json)).setTextSize(16);
        findViewById(R.id.fab_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (findViewById(R.id.request_progress).getVisibility() == View.INVISIBLE) {
                    createRequest();
                }
            }
        });
        //adapter=new VehiculoAdapter(items);
        //recycler.setAdapter(adapter);
        //FillVehiculos();
    }

    public RequestConfiguration getRequestConfiguration() {
        return mRequestConfiguration;
    }


    private void createRequest() {

        /*new Results(this, mRequestConfiguration)
                .newWebService("https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=json")
                .getList(mResultsModelArray);
                */

        /*new Request.Builder<Results[]>()
                .with(getApplicationContext(), mRequestConfiguration)
                .requestTo("https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=json")
                .listener(mPhotoModelArrayRequestListener)
                .build(Results[].class).get();
                */




     /*   new Results(this)
                .newWebService("https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=json")
                .getList(mResultsModelArray);
*/


       /* new Request.Builder<>()
                .with(this, mRequestConfiguration)
                .requestTo("https://api.androidhive.info/contacts/")
                .listener(mObjectRequestListener)
                .build(Object.class).get();
                */



      /* new Results(this, mRequestConfiguration)
                .newWebService("https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=json")
                .getList(mPhotoModelArrayRequestListener);

*/


      /* new ContactModel(this, mRequestConfiguration)
                .newWebService("https://api.androidhive.info/contacts/")
                .getList(mPhotoModelArrayRequestListener);
                */



        new Request.Builder<>()
                .with(this, mRequestConfiguration)
                .requestTo("https://myttc.ca/finch_station.json")
                .listener(mObjectRequestListener)
                .build(Object.class).get();

    }

    private RequestListener<Results[]> mResultsModelArray =
            new RequestListener<Results[]>() {
                @Override
                public void onRequestStart() {
                    super.onRequestStart();
                    uiStatus(true);
                }

                @Override
                public void onRequestError(ExceptionManager em) {
                    super.onRequestError(em);

                    uiStatus(false);
                    em.getRelatedException().printStackTrace();
                    Snackbar.make(findViewById(R.id.fab_go), "Error!. See log for details", Snackbar.LENGTH_LONG).show();
                }

                @Override
                public void onRequestEnd(Results[] response, String currentToken) {
                    super.onRequestEnd(response, currentToken);

                    ((JsonRecyclerView) findViewById(R.id.rv_json))
                            .bindJson(new Gson().toJson(response));

                    uiStatus(false);
                }
            };

    private RequestListener<PhotoModel> mPhotoModelRequestListener =
            new RequestListener<PhotoModel>() {
                @Override
                public void onRequestStart() {
                    super.onRequestStart();

                    uiStatus(true);
                }

                @Override
                public void onRequestError(ExceptionManager em) {
                    super.onRequestError(em);

                    uiStatus(false);

                    em.getRelatedException().printStackTrace();
                    Snackbar.make(findViewById(R.id.fab_go), "Error!. See log for details", Snackbar.LENGTH_LONG).show();
                }

                @Override
                public void onRequestEnd(PhotoModel response, String currentToken) {
                    super.onRequestEnd(response, currentToken);

                    ((JsonRecyclerView) findViewById(R.id.rv_json))
                            .bindJson(new Gson().toJson(response));

                    uiStatus(false);
                }

                @Override
                public void onRequestEnd(String response) {
                    super.onRequestEnd(response);

                    try {
                        ((JsonRecyclerView) findViewById(R.id.rv_json))
                                .bindJson(new Gson().toJson(response));
                    } catch (Exception e) {
                        Log.e(TAG, response);
                        Snackbar.make(findViewById(R.id.fab_go), "Error!. See log for details", Snackbar.LENGTH_LONG).show();
                    }

                    uiStatus(false);
                }
            };

    private RequestListener<Results[]> mPhotoModelArrayRequestListener =
            new RequestListener<Results[]>() {
                @Override
                public void onRequestStart() {
                    super.onRequestStart();

                    uiStatus(true);
                }

                @Override
                public void onRequestError(ExceptionManager em) {
                    super.onRequestError(em);

                    uiStatus(false);

                    em.getRelatedException().printStackTrace();
                    Snackbar.make(findViewById(R.id.fab_go), "Error!. See log for details", Snackbar.LENGTH_LONG).show();
                }

                @Override
                public void onRequestEnd(Results[] response, String currentToken) {
                    super.onRequestEnd(response, currentToken);

                    ((JsonRecyclerView) findViewById(R.id.rv_json))
                            .bindJson(new Gson().toJson(response));

                    uiStatus(false);
                }
            };
    private RequestListener<Response<Object>> mResponseObjectRequestListener =
            new RequestListener<Response<Object>>() {
                @Override
                public void onRequestStart() {
                    super.onRequestStart();

                    uiStatus(true);
                }

                @Override
                public void onRequestError(ExceptionManager em) {
                    super.onRequestError(em);

                    uiStatus(false);

                    em.getRelatedException().printStackTrace();
                    Snackbar.make(findViewById(R.id.fab_go), "Error!. See log for details", Snackbar.LENGTH_LONG).show();
                }

                @Override
                public void onRequestEnd(Response<Object> response, String currentToken) {
                    super.onRequestEnd(response, currentToken);

                    ((JsonRecyclerView) findViewById(R.id.rv_json))
                            .bindJson(new Gson().toJson(response));

                    uiStatus(false);
                }
            };

    private RequestListener<Object> mObjectRequestListener =
            new RequestListener<Object>() {
                @Override
                public void onRequestStart() {
                    super.onRequestStart();

                    uiStatus(true);
                }

                @Override
                public void onRequestError(ExceptionManager em) {
                    super.onRequestError(em);

                    uiStatus(false);

                    em.getRelatedException().printStackTrace();
                    Snackbar.make(findViewById(R.id.fab_go), "Error!. See log for details", Snackbar.LENGTH_LONG).show();
                }

                @Override
                public void onRequestEnd(Object response, String currentToken) {
                    super.onRequestEnd(response, currentToken);

                    String json = new Gson().toJson(response);

                    ((JsonRecyclerView) findViewById(R.id.rv_json))
                            .bindJson(json);

                    uiStatus(false);
                }
            };

    /**
     * Change ui visibility
     *
     * @param inRequest If activity is in request mode
     */
    private void uiStatus(boolean inRequest) {
        if (inRequest) {
            findViewById(R.id.request_progress).setVisibility(View.VISIBLE);
            findViewById(R.id.text_view_request_test).setVisibility(View.INVISIBLE);
            ((FloatingActionButton) findViewById(R.id.fab_go)).hide();
        }
        else {
            findViewById(R.id.request_progress).setVisibility(View.INVISIBLE);
            findViewById(R.id.text_view_request_test).setVisibility(View.VISIBLE);
            ((FloatingActionButton) findViewById(R.id.fab_go)).show();
        }
    }
}


