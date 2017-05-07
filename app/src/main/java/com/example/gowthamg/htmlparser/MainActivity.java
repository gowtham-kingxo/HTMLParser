package com.example.gowthamg.htmlparser;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public class  DownloadTask extends AsyncTask<String,Void,String>
    {


        @Override
        protected String doInBackground(String... urls) {
           String result ="";
            URL url;
            HttpURLConnection urlconnection = null;






            try {
                url = new URL(urls[0]);
                urlconnection = (HttpURLConnection) url.openConnection();
                InputStream inputstream = urlconnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputstream);
               // long a = reader.skip(41600);
                int data = reader.read();
              //  int i =1;

                while(data != -1 )
                {
                    char current = (char) data;
                    result+= current;
                    data = reader.read();
                  //  i++;

                }

            } catch (IOException e) {
                e.printStackTrace();
                return  "failed";
            }

            return result;
        }
    }

    public static class ImageDownload extends AsyncTask<String, Void ,Bitmap>
    {

        @Override
        protected Bitmap doInBackground(String... strings) {
            String result = "";
            URL url;
            HttpURLConnection connection = null;


            try {
                url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                Bitmap mybitmap = BitmapFactory.decodeStream(is);
                return mybitmap;



            } catch (IOException e) {
                e.printStackTrace();

            }

            return null;


        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll = (LinearLayout) findViewById(R.id.layout);
        LinearLayout.LayoutParams lp =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final Intent intent = new Intent(MainActivity.this,ShopFullDetails.class);
       /* DownloadTask task =  new DownloadTask();
        try {
            String a = task.execute("https://kart.la/search-results/?gmw_keywords&gmw_address%5B0%5D=Nanganallur%2C%20Chennai%2C%20Tamil%20Nadu&gmw_post=post&tax_category%5B0%5D=235&gmw_distance=2&gmw_units=metric&gmw_form=2&gmw_per_page=10&gmw_lat=12.9753604&gmw_lng=80.19012190000001&gmw_px=pt&action=gmw_post").get();
            int index = a.indexOf("<!-- Title -->");
            index = a.indexOf("src=",index);
            int index2 = a.indexOf("\"",index+5);
            String str = a.substring(index+5,index2);
           // Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            ImageDownload itask = new ImageDownload();
            Bitmap b = itask.execute(str).get();
            iv.setImageBitmap(b);
            iv.setMinimumHeight(1000);
            iv.setMinimumWidth(1000);
            ll.addView(iv,lp);
            Log.d("result",a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
*/
        DownloadTask task =  new DownloadTask();
        try {
            String html = task.execute("https://kart.la/search-results/?gmw_keywords&gmw_address%5B0%5D=ambattur&gmw_post=post&tax_category%5B0%5D=235&gmw_distance=100&gmw_units=metric&gmw_form=2&gmw_per_page=10&gmw_lat=13.1143167&gmw_lng=80.14805509999997&gmw_px=pt&action=gmw_post").get();
           Log.d("html content",html);
          int index1 = 0,index2 =0,i=0;
            String imgurl="";
           if(html.indexOf("<!-- Title -->") != -1)
            {
                //Toast.makeText(this, "inside if", Toast.LENGTH_SHORT).show();

                while (html.indexOf("<!-- Title -->",index1) != -1)
                {
                    i++;
                    index1 += 10;
                            //  Toast.makeText(this, "inside while", Toast.LENGTH_SHORT).show();
                    Log.d("Starting index value",""+index1);
                    index1 = html.indexOf("<!-- Title -->",index1);
                    Log.d("index value1",""+index1);
                    index1 = html.indexOf(")",index1);
                    Log.d("index value2",""+index1);
                    index2 = html.indexOf("(",index1);

                    Button bt = new Button(this);
                    final String shop_name = html.substring(index1+1,index2);
                    bt.setText(html.substring(index1+1,index2));
            Log.d("before shop name",html.substring(index1+1,index2));

            ll.addView(bt,lp);

            Log.d("After shop name",html.substring(index1+1,index2));


            index1 = index2+1;
                    Log.d("index value3",""+index1);
                    index2 = html.indexOf(")",index1);

                    TextView tv = new TextView(this);
           Log.d("Contact","Contact : "+html.substring(index1,index2));

            tv.setText("Contact : "+html.substring(index1,index2));
                    final String contact =html.substring(index1,index2);
            tv.setWidth(200);
            tv.setHeight(100);
            tv.setTextSize(25);
                    ll.addView(tv,lp);
            Log.d("After Contact",html.substring(index1,index2));
            //tv.setText(" After Contact : "+html.substring(index1,index2));
                    index1 = html.indexOf("src=\"",index2);
                    index1+= 5;
                    Log.d("index value4",""+index1);
                    index2 = html.indexOf("-150",index1);
                    imgurl = html.substring(index1,index2)+".jpeg";
                    final String image_url = html.substring(index1,index2);
            Log.d("Image Url",html.substring(index1+5,index2));


           // Toast.makeText(this, imgurl, Toast.LENGTH_SHORT).show();
                    index1 = html.indexOf("address\">",index2);
                    index1 =index1+9;
                    index2 = html.indexOf("</div>",index1);
                    final  String address = html.substring(index1,index2).trim();

                   // Toast.makeText(this,address, Toast.LENGTH_SHORT).show();

                    ImageDownload itask = new ImageDownload();
            final Bitmap b = itask.execute(imgurl).get();


            ImageView iv = new ImageView(this);
            iv.setImageBitmap(b);
            iv.setMinimumWidth(1000);
            iv.setMinimumHeight(1000);
            ll.addView(iv,lp);
                    Log.d("Ending index value",""+index1);
                    final int finalI = i;
                    bt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //Toast.makeText(MainActivity.this, ""+ finalI, Toast.LENGTH_SHORT).show();
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            b.compress(Bitmap.CompressFormat.PNG, 100, stream);
                            byte[] byteArray = stream.toByteArray();

                            intent.putExtra("address",address);
                            intent.putExtra("image",byteArray);
                            intent.putExtra("contact", contact);
                            intent.putExtra("shop_name",shop_name);
                            startActivity(intent);
                        }
                    });

                }
            }
            else
            {
                Toast.makeText(this, "Sorry no results found!! ", Toast.LENGTH_SHORT).show();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

