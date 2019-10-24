package com.example.jeuyt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private EditText txtNumber = null;
    private Button btnCompare;
    private ProgressBar pgbScore;
    private TextView lblResult;
    private TextView txtHistory;
    private int searchedValue;
    private int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumber = (EditText) findViewById(R.id.txtNumber);
        btnCompare = (Button) findViewById(R.id.btnCompare);
        pgbScore = (ProgressBar) findViewById(R.id.pgbScore);
        lblResult = (TextView) findViewById(R.id.lblResult);
        txtHistory = (TextView) findViewById(R.id.txtHistory);

        btnCompare.setOnClickListener(btnComparerListener);

        init();
    }

    private void init(){
        score = 0;
        searchedValue = 1+(int)(Math.random()*100);
        Log.i("DEBUG", "Valeur cherchée" + searchedValue);

        txtNumber.setText( "" );
        pgbScore.setProgress(score);
        lblResult.setText( "" );
        txtHistory.setText( "" );

        txtNumber.requestFocus();
    }

    private void congratulations()
    {
        lblResult.setText("CONGRATS");
    }

    private View.OnClickListener btnComparerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i("DEBUG", "Bouton clique");

            String strNumber = txtNumber.getText().toString();


            if(strNumber.equals(""))
            {
                return;
            }
            txtHistory.append(strNumber + "\r\n");
            pgbScore.incrementProgressBy(1);
            score++;
            int enteredValue = Integer.parseInt(strNumber);
            if(enteredValue == searchedValue)
            {
                congratulations();
            }
            else if(enteredValue < searchedValue)
            {
                lblResult.setText("Plus grand");

            }
            else
            {
                lblResult.setText("Plus petit");
            }

        }
    };


}
