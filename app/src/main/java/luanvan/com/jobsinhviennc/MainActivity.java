package luanvan.com.jobsinhviennc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    String urlGetdata = "http://10.2.19.237/androi2.php";

    ListView lvHstd;
    ArrayList<Hstd> arrayHstd;
    hstdAdapter adapter;
    EditText tentimkiem, text1;

    Button tim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvHstd = (ListView) findViewById(R.id.ListviewHstd);
        arrayHstd = new ArrayList<>();

        adapter  = new hstdAdapter(this, R.layout.dong_hstd, arrayHstd);
        lvHstd.setAdapter(adapter);
        tentimkiem = (EditText)findViewById(R.id.ten);
        tim = (Button)findViewById(R.id.btntim);
        text1 = (EditText) findViewById(R.id.text1);
        //GetData(urlGetdata);
        tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // timKiem(urlGetdata, tentimkiem.getText().toString(),text1.getText().toString());
                dat(urlGetdata);
            }
        });


    }
    public  void GetData(String url){
        RequestQueue requestQueue =  Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                      //  Toast.makeText(MainActivity.this,response.toString(), Toast.LENGTH_SHORT).show();
                        for ( int i = 0; i< response.length();i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayHstd.add(new Hstd(
                                        object.getInt("id"),
                                        object.getString("title"),
                                        object.getString("namefrom"),
                                        object.getString("nameto"),
                                        object.getString("phone"),
                                        object.getString("price"),
                                        object.getString("day_go"),
                                         object.getString("seat"),
                                        object.getString("number")


                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"Xàm xí", Toast.LENGTH_SHORT).show();
                    }
                }

        );
        requestQueue.add(jsonArrayRequest);
    }
    public  void timKiem(String url, final String tentimkiem, final String ntdung){
        RequestQueue requestQueue =  Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(MainActivity.this,response.toString(), Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray jsonArray = new JSONArray(response.toString());
                            //JSONObject jsonObject = (JSONObject)jsonArray.get(1);

                            //du lieu tu json
//                            JSONObject jsonObjectA[] = new JSONObject[response.length()+1];
//                            final String[] tieude = new String[response.length()+1];
//                            final String[] dchi = new String[response.length()+1];
//                            final String[] ntd = new String[response.length()+1];
//                            int id[] = new int[response.length()+1];
//                            arrayHstd.clear();
//du lieu tu json
                            JSONObject jsonObjectA[] = new JSONObject[response.length()+1];
                            final String[] tieude = new String[response.length()+1];
                            final String[] dchi = new String[response.length()+1];
                            final String[] ntd = new String[response.length()+1];
                            int id[] = new int[response.length()+1];
                            arrayHstd.clear();


                            for(int i=0;i<response.length();i++){
                                jsonObjectA[i]= (JSONObject)jsonArray.get(i);
                            }

                            for(int i=0;i<response.length();i++){
//                                tieude[i] = jsonObjectA[i].getString("tieudeTD");
//                                dchi[i] = jsonObjectA[i].getString("dchiTD");
//                                ntd[i] = jsonObjectA[i].getString("ntdTD");
//                                id[i] = jsonObjectA[i].getInt("idTD");

                                tieude[i] = jsonObjectA[i].getString("title");
                                dchi[i] = jsonObjectA[i].getString("namefrom");
                                ntd[i] = jsonObjectA[i].getString("nameto");
                                id[i] = jsonObjectA[i].getInt("id");
                                //tim kiem
                               if(ntdung.equals(ntd[i]) || tentimkiem.equals(dchi[i])){
                              //  if(ntdung.equals(dchi[i])||tentimkiem.equals(ntd[i])){
                                    JSONObject object = response.getJSONObject(i);

                                    arrayHstd.add(new Hstd(
                                            object.getInt("id"),
                                            object.getString("title"),
                                            object.getString("namefrom"),
                                            object.getString("nameto"),
                                            object.getString("phone"),
                                            object.getString("price"),
                                            object.getString("day_go"),
                                            object.getString("seat"),
                                            object.getString("number")
                                    ));
                                   Toast.makeText(getApplicationContext(), tieude[i]+"dia chi: "+dchi[i]+"ntd: "+ntd[i], Toast.LENGTH_LONG).show();
                                    adapter.notifyDataSetChanged();
                            }
                                /*if(ntdung.equals(ntd[i])||tentimkiem.equals(tieude[i])){
                                    put(activity_mota.class,String.valueOf(id[i]),ntd[i],dchi[i]);
                                }*/

                            }

                            //Toast.makeText(getApplicationContext(), tieude[1], Toast.LENGTH_LONG).show();

                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"looix: "+ e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"xin lỗi chưa có chuyến đi này", Toast.LENGTH_SHORT).show();
                    }
                }

        );
        requestQueue.add(jsonArrayRequest);
    }
//    private void put(Class cl,String id, String ntd, String dchi){
//        Intent intent = new Intent(this,cl);
//        intent.putExtra("id",id);
//        intent.putExtra("ntd",ntd);
//        intent.putExtra("dchi",dchi);
//        startActivity(intent);
//    }

    private void put(Class cl,String id, String namefrom, String nameto){
        Intent intent = new Intent(this,cl);
        intent.putExtra("id",id);
        intent.putExtra("ntd",nameto);
        intent.putExtra("dchi",namefrom);
        startActivity(intent);
    }
    public void dat(String url){
        RequestQueue requestQueue =  Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(MainActivity.this,response.toString(), Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray jsonArray = new JSONArray(response.toString());
                            JSONObject jsonObjectA[]=new JSONObject[response.length()];
                            for(int i=0;i<response.length();i++){
                                jsonObjectA[i]= (JSONObject)jsonArray.get(i);
                            }
                            String title[] = new String[response.length()];
                            String namefrom[]= new String[response.length()];
                            /*String nameto[] =new String[response.length()];
                            String day_go[] = new String[response.length()];
                            String price[] = new String[response.length()];
                            String phone[] = new String[response.length()];
                            String seat[] = new String[response.length()];*/
                            for(int i=0;i<response.length();i++) {
                                title[i] = jsonObjectA[i].getString("title");
                                namefrom[i] = jsonObjectA[i].getString("namefrom");

                            }
                            Toast.makeText(getApplicationContext(),title[0].toString()+": "+namefrom[0]+": "+response.length(), Toast.LENGTH_LONG).show();

                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"looix: "+ e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_LONG).show();
                    }
                } ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("key","Đại Học Cần Thơ");
                //params.put("pass1word",editpassword.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(jsonArrayRequest);
    }
    }

    // them phan Search
    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {

        //getMenuInflater().inflate(R.menu.toolbar_search_menu,menu);

        //MenuItem menuItem = menu.findItem(R.id.action_search);
        //SearchView searchView = (SearchView) menuItem.getActionView();
        //searchView.setQueryHint("Search");

        //searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //@Override
            //public boolean onQueryTextSubmit(String query) {

                //return false;
            //}

            //@Override
            //public boolean onQueryTextChange(String newText) {
               // return false;
           // }
       // });
        //return super.onCreateOptionsMenu(menu);
   //}


