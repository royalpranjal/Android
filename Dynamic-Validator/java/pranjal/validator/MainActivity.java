package pranjal.validator;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener{

    EditText name, number;
    TextInputLayout layoutName, layoutNumber;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editTextName);
        number = (EditText) findViewById(R.id.editTextNumber);

        name.setOnFocusChangeListener(this);
        number.setOnFocusChangeListener(this);

        layoutName = (TextInputLayout) findViewById(R.id.layoutEditTextName);
        layoutNumber = (TextInputLayout) findViewById(R.id.layoutEditTextNumber);
        submitBtn = (Button) findViewById(R.id.buttonSubmit);

        submitBtn.setClickable(false);

        number.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    if(number.getText().toString().isEmpty()){
                        layoutNumber.setError("Please enter a number");
                    }
                    else if(number.getText().toString().length() != 10){
                        layoutNumber.setError("The number should be of 10 digits");
                    }
                        submitBtn.setClickable(true);
                        submitBtn.setBackgroundColor(Color.RED);
                }
                return false;
            }
        });
    }

    public void submit(View view){
        submitBtn.setClickable(false);
        name.setEnabled(false);
        number.setEnabled(false);
        Snackbar.make(view, "Successful", Snackbar.LENGTH_LONG).show();
    }

    private boolean validations(){
        if(name.getText().toString().length() < 4 || !name.getText().toString().isEmpty()){
            return false;
        }
        if(number.getText().toString().length() != 10){
            return false;
        }
        return true;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(v.getId() == R.id.editTextName){
            if(hasFocus) {
                layoutName.setErrorEnabled(false);
            }
            else{
                if(name.getText().toString().isEmpty()){
                    layoutName.setError("Please enter a name");
                }
                else if(name.getText().toString().trim().length() < 4){
                    layoutName.setError("The name should be at least 5 char");
                }
                else{
                    layoutName.setErrorEnabled(false);
                }
            }
        }
        if(v.getId() == R.id.editTextNumber){
            if (hasFocus) {
                layoutNumber.setErrorEnabled(false);
            }
            else{
                if(number.getText().toString().isEmpty()){
                    layoutNumber.setError("Please enter a number");
                }
                else if(number.getText().toString().length() != 10){
                    layoutNumber.setError("The number should be of 10 digits");
                }
                else{
                    layoutNumber.setErrorEnabled(false);
                }
            }
        }
    }
}
