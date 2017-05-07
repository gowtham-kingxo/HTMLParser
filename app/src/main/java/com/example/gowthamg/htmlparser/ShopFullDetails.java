package com.example.gowthamg.htmlparser;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShopFullDetails extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_full_details);
        Bundle bundle = getIntent().getExtras();
        final String contact = bundle.getString("contact");
        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        String shop_name = bundle.getString("shop_name");
        String address = bundle.getString("address");


        LinearLayout ll = (LinearLayout) findViewById(R.id.layout2);
        LinearLayout.LayoutParams lp =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tv = new TextView(this);
        tv.setText(shop_name);
        tv.setWidth(200);
        tv.setHeight(100);
        tv.setTextSize(25);
       // tv.setTextColor(23);

        ll.addView(tv,lp);

        Button bt = new Button(this);
        bt.setText(contact);
        //bt.setBackgroundColor(6);
       // bt.setTextColor(2);
       // bt.setHeight(200);
       //bt.setWidth(200);
        bt.setTextSize(30);
       // final String f ="tel:"+contact.trim();
        final String c = contact.substring(0,3)+"-"+contact.substring(3,6)+"-"+contact.substring(6,9)+"-"+contact.substring(9);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",c, null));


                startActivity(intent);
            }
        });

        ll.addView(bt,lp);

        TextView tv2 = new TextView(this);
        tv2.setText(address);
        tv.setWidth(200);
        tv.setHeight(100);
        tv.setTextSize(20);

        ll.addView(tv2,lp);


        ImageView iv = new ImageView(this);
        iv.setImageBitmap(bmp);
        iv.setMinimumWidth(5000);
        iv.setMinimumHeight(1000);
        ll.addView(iv,lp);


    }
}
