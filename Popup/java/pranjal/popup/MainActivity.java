package pranjal.popup;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    private Button closePopUp;
    private PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showThePopup(View view){
        initiatePop();
    }

    private void initiatePop() {
        try {
            LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View layout = inflater.inflate(R.layout.popup_view, (ViewGroup) findViewById(R.id.popupElement));

            popupWindow = new PopupWindow(layout, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, false);

            // getting the device width & height
//            Display display = getWindowManager().getDefaultDisplay();
//            Point size = new Point();
//            display.getSize(size);
//            int width = size.x;
//            int height = size.y;
            // view, height, width, focusable
            popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);
            // parent, gravity, x, y
            closePopUp = (Button) layout.findViewById(R.id.buttonPopupClose);
            closePopUp.setOnClickListener(cancelPopup);
        }
        catch (Exception e){
        }
    }

    private View.OnClickListener cancelPopup = new View.OnClickListener() {
        public void onClick(View v) {
            popupWindow.dismiss();
        }
    };

}
