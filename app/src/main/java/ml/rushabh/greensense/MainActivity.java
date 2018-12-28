package ml.rushabh.greensense;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import ml.rushabh.greensense.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(FirebaseAuth.getInstance().getCurrentUser()==null){
            Intent intent = new Intent(MainActivity.this,SignIn.class);
            startActivity(intent);
            finish();
        }
        else {
            final ProgressBar pb = (ProgressBar) findViewById(R.id.pb);
            final TextView tv = (TextView)findViewById(R.id.tv);
            final ListView listView = (ListView)findViewById(R.id.datalist);
            final ArrayList<DeviceData> list = new ArrayList<DeviceData>();
            pb.setVisibility(View.VISIBLE);
            final CardAdapter adapter = new CardAdapter(this,R.layout.card, list);

            listView.setAdapter(adapter);
            // Get a reference to our posts
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("data/device1");
            // Attach a listener to read the data at our posts reference
            ref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                    DeviceData data = dataSnapshot.getValue(DeviceData.class);
                    String st = "";
                    //list.add(data);
                    adapter.add(data);
                    pb.setVisibility(View.GONE);
                    st+=("\nairHumidity : "+data.airHumidity);
                    st+=("\ngps : "+data.gps);
                    st+=("\npH : "+data.pH);
                    st+=("\nsoilMoisture : "+data.soilMoisture);
                    st+=("\ntemperature : "+data.temperature);
                    st+=("\nTimeUnderSunlight : "+data.timeUnderSunlight);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {}

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    tv.setText("error"+ databaseError.getDetails());
                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sign_out:
                AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                Intent intent = new Intent(MainActivity.this,SignIn.class);
                                startActivity(intent);
                                finish();
                            }
                        });
        }
        return true;
    }
}
