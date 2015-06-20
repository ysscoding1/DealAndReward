package dnr.capitalone.com.dealandreward;

/**
 * Created by EXB795 on 6/19/2015.
 */
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;

public class ButtonPushedOnTouchListener implements OnTouchListener
{

    private float mPrevX;
    private float mPrevY;

    public dealMainActivity mainActivity;
    public ButtonPushedOnTouchListener(dealMainActivity mainActivity1) {
        mainActivity = mainActivity1;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        float currX,currY;
        int action = event.getAction();
        switch (action ) {
            case MotionEvent.ACTION_DOWN: {

                currX = event.getX();
                currY = event.getY();
                MarginLayoutParams marginParams = new MarginLayoutParams(view.getLayoutParams());
                marginParams.setMargins((int)(currX - 5), (int)(currY - 5),0, 0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
                view.setLayoutParams(layoutParams);
                break;
            }

            case MotionEvent.ACTION_MOVE:
            {

                /*currX = event.getRawX();
                currY = event.getRawY();


                MarginLayoutParams marginParams = new MarginLayoutParams(view.getLayoutParams());
                marginParams.setMargins((int)(currX - mPrevX), (int)(currY - mPrevY),0, 0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
                view.setLayoutParams(layoutParams);

                */
                break;
            }



            case MotionEvent.ACTION_CANCEL:
                break;

            case MotionEvent.ACTION_UP:

                break;
        }

        return true;
    }

}