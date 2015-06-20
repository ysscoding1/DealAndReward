package dnr.capitalone.com.dealandreward;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.transition.TransitionManager;


public class dealMainActivity extends ActionBarActivity {

    ImageButton imgButton;
    Button button;
    ImageButton couponButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Facebook.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_deal_main);

        imgButton =(ImageButton)findViewById(R.id.icon1);
        imgButton.setOnTouchListener(new ButtonHighlighterOnTouchListener(imgButton));
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  Toast.makeText(getApplicationContext(), "You download is resumed", Toast.LENGTH_LONG).show();*/

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Sharing URL");
                i.putExtra(Intent.EXTRA_TEXT, "http://www.url.com");
                startActivity(Intent.createChooser(i, "Share URL"));
            }
        });

        button = (Button)findViewById(R.id.imageButton);
        /*ButtonPushedOnTouchListener touchListener = new ButtonPushedOnTouchListener(this);
        button.setOnTouchListener(touchListener);*/
        button.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                ViewGroup layout = (ViewGroup)findViewById(R.id.restaurantsLayout);
                TransitionManager.beginDelayedTransition(layout);
                button.setSelected(arg1.getAction() == MotionEvent.ACTION_DOWN);
                return true;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(dealMainActivity.this, CouponActivity.class);
                startActivity(i);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_deal_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
