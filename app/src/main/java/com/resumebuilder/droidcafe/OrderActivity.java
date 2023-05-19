package com.resumebuilder.droidcafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
private TextView textView;
private RadioGroup radioGroup;
private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        radioGroup=findViewById(R.id.radio_group);
        textView= findViewById(R.id.order_textview);
        Intent intent=getIntent();
        String message=intent.getStringExtra("order");
        textView.setText(message);
        Spinner spinner=findViewById(R.id.label_spinner);
        if(spinner !=null)
        {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> arrayAdapter= ArrayAdapter.createFromResource(this,R.array.labels_array, android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if(spinner !=null)
        {
            spinner.setAdapter(arrayAdapter);
        }
    }
    public void onRadioButtonClicked(View view) {
        int radioid=radioGroup.getCheckedRadioButtonId();
        radioButton= findViewById(radioid);
        Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();
        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked.
//        switch (view.getId()) {
//            case R.id.sameday:
//                if (checked)
//                    // Same day service
//                    displayToast(getString(R.string.same_day_messenger_service));
//                break;
//            case R.id.nextday:
//                if (checked)
//                    // Next day delivery
//                    displayToast(getString(R.string.next_day_ground_delivery));
//                break;
//            case R.id.pickup:
//                if (checked)
//                    // Pick up
//                    displayToast(getString(R.string.pick_up));
//                break;
//            default:
//                // Do nothing.
//                break;

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    private void displayToast(String spinnerLabel1) {
        Toast.makeText(this, spinnerLabel1, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}