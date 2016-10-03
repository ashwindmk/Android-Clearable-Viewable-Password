package com.example.ashwin.clearableviewablepasswordfield;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mPassword;
    private Button mClear;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClear = (Button) findViewById(R.id.clear);

        mTextView = (TextView) findViewById(R.id.textView);

        mPassword = (EditText) findViewById(R.id.password);

        mPassword.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                //do nothing
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0) {
                    mClear.setVisibility(View.VISIBLE);
                } else {
                    mClear.setVisibility(View.GONE);
                }
            }
        });
    }

    public void done(View view) {
        String password = mPassword.getText().toString();
        mTextView.setText(password);
    }

    public void clear(View view) {
        mPassword.setText("");
        mClear.setVisibility(View.GONE);
    }
}
