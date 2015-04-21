package comsec.webviewvuln;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_btn);

        Button btnClick = (Button) findViewById(R.id.button);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebViewWithTitle("Comsec Training","http://yossilock.co.il/pt/");
            }
        });
    }

    public void openWebViewWithTitle(String title, String url) {
        Intent myIntent = new Intent(MainActivity.this, StartActivity.class);
        myIntent.putExtra("title", title);
        myIntent.putExtra("url", url);
        MainActivity.this.startActivity(myIntent);
    }
}