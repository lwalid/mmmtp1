package com.example.nounou.tp1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    /** Called when the activity is first created. */

    private boolean added = false;
    EditText name, surname,town;
    String departement;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText phoneNumber = (EditText) findViewById(R.id.editPhone);
        phoneNumber.setVisibility(View.GONE);
        final Button submit = (Button) findViewById(R.id.button);
        final EditText dateOfBirth = (EditText) findViewById(R.id.editDateOfBirth);

        //nous avons ajouté un  ClickListener sur le editText dateOfBirth
        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();

                int y = c.get(Calendar.YEAR);
                int m = c.get(Calendar.MONTH);
                int d = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dp = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                String date = "";
                                date = String.valueOf(dayOfMonth);
                                date += "-" + String.valueOf(monthOfYear);
                                date += "-" + year;

                                 dateOfBirth.setText(date);

                            }

                        }, y, m, d);

                dp.show();



            }
        });


        submit.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                 name = (EditText) findViewById(R.id.editName);
                 surname = (EditText) findViewById(R.id.editSurname);
                 town = (EditText) findViewById(R.id.editTown);



                Spinner spinner = (Spinner)findViewById(R.id.spinner);
                departement = spinner.getSelectedItem().toString();

               // le toast
                String textSaisi = name.getText()   + "\n"
                        + surname.getText()         + "\n"
                        + dateOfBirth.getText()     + "\n"
                        + town.getText()            + "\n"
                        + departement;
                 Toast.makeText(getApplicationContext(), textSaisi,
                         Toast.LENGTH_SHORT).show();



              Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                //Intent contenant les informations saisies
               /* intent.putExtra("Name", name.getText().toString());
                intent.putExtra("Surname", surname.getText().toString());
                intent.putExtra("Town", town.getText().toString());
                intent.putExtra("DateOfBirth", dateOfBirth.getText().toString());*/

                //Intent contenant un objet parcelable
                intent.putExtra("parcelableObject", new ParcelableObject(name.getText().toString(),
                        dateOfBirth.getText().toString(),surname.getText().toString(),town.getText().toString()));

                 startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
      /* test second commit */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_raz:
                EditText name = (EditText) findViewById(R.id.editName);
                EditText surname = (EditText) findViewById(R.id.editSurname);
                EditText town = (EditText) findViewById(R.id.editTown);
                EditText dateOfBirth = (EditText) findViewById(R.id.editDateOfBirth);

                name.setText("");
                surname.setText("");
                dateOfBirth.setText("");
                town.setText("");
                break;
            case R.id.action_phone:

                EditText phoneNumber = (EditText) findViewById(R.id.editPhone);
                phoneNumber.setVisibility(View.VISIBLE);
                item.setEnabled(false);
                break;
            
            case R.id.action_browser:
                Spinner departement = (Spinner) findViewById(R.id.spinner);
                Intent recherche = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://fr.wikipedia.org/wiki/"
                                + ((String) departement.getSelectedItem())));
                startActivity(recherche);


                break;

        }
        return true;
    }
}