package cn.yixg.ckcoolweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Connector.getDatabase();

    }
}
