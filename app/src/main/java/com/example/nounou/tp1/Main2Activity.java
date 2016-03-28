package com.example.nounou.tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText name = (EditText) findViewById(R.id.editName);
        EditText surname =(EditText) findViewById(R.id.editSurname);
        EditText town =(EditText) findViewById(R.id.editTown);
        EditText dateOfBirth = (EditText) findViewById(R.id.editDateOfBirth);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

              //Intent contenant les informations saisies
           /* String valueName = extras.getString("Name");
            String valueSurname = extras.getString("Surname");
            String valueTown = extras.getString("Town");
            String valueDateOfBirth = extras.getString("DateOfBirth");

            name.setText(valueName);
            surname.setText(valueSurname);
            town.setText(valueTown);
            dateOfBirth.setText(valueDateOfBirth);*/

           //Intent contenant un objet parcelable
            ParcelableObject parcelableObject = (ParcelableObject) extras.getParcelable("parcelableObject");
            name.setText(parcelableObject.getName());
            surname.setText(parcelableObject.getSurname());
            town.setText(parcelableObject.getTown());
            dateOfBirth.setText(parcelableObject.getDateOfBirth());

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
