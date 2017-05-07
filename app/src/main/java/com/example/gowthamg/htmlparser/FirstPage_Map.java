package com.example.gowthamg.htmlparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FirstPage_Map extends AppCompatActivity {

    //MANIFEST

//       <meta-data
//    android:name="com.google.android.geo.API_KEY"
//    android:value="@string/google_maps_key" />
//
//        <activity
//    android:name=".Map_activity"
//    android:label="@string/title_activity_map_activity">
//
//        </activity>


    // LocationManager locationManager;
    //LocationListener locationListener;

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
//            }
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page__map);
        // open map focusiing that
//        Uri gmmIntentUri = Uri.parse("geo:13.1143167,80.14805509999997");
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//        mapIntent.setPackage("com.google.android.apps.maps");

            //start navigation
//        Uri gmmIntentUri = Uri.parse("google.navigation:q=13.1143167,80.14805509999997");
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//        mapIntent.setPackage("com.google.android.apps.maps");

            //marker
//        Uri gmmIntentUri = Uri.parse("geo:0,0?q=13.1143167,80.14805509999997");
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//        mapIntent.setPackage("com.google.android.apps.maps");
        String name  = "(SS Hyderabad Biriyani)";
//
//        Uri gmmIntentUri = Uri.parse("geo:0,0?q=13.1143167,80.14805509999997"+name);
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//        mapIntent.setPackage("com.google.android.apps.maps");

//        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//        mapIntent.setPackage("com.google.android.apps.maps");
                //get directions
//        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW,
//                Uri.parse("http://maps.google.com/maps?daddr=13.1143167,80.14805509999997"));
//        if (mapIntent.resolveActivity(getPackageManager()) != null) {
//            startActivity(mapIntent);
//        }


//     locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
//       locationListener = new LocationListener() {
//            @Override
//            public void onLocationChanged(Location location) {
//                Log.i("Location",location.toString());
//               // Toast.makeText(FirstPage_Map.this, "got it", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onStatusChanged(String s, int i, Bundle bundle) {
//
//            }
//
//            @Override
//            public void onProviderEnabled(String s) {
//
//            }
//
//            @Override
//            public void onProviderDisabled(String s) {
//
//            }
//        };
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
//        {
//            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
//        }
//


    }
}
