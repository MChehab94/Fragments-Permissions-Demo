package mchehab.com.fragmentpermissions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getFragmentManager().beginTransaction().add(R.id.frameLayout, new PermissionFragment())
                    .commit();
        }
    }
}