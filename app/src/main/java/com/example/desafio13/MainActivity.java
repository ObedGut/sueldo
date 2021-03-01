package com.example.desafio13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name1, name2, name3;
    EditText lastname1, lastname2, lastname3;
    EditText charge1, charge2, charge3;
    EditText hours1, hours2, hours3;
    TextView result, result2;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        name1 = (EditText) findViewById(R.id.name1);
        name2 = (EditText) findViewById(R.id.name2);
        name3 = (EditText) findViewById(R.id.name3);
        lastname1 = (EditText) findViewById(R.id.lastname1);
        lastname2 = (EditText) findViewById(R.id.lastname2);
        lastname3 = (EditText) findViewById(R.id.lastname3);
        charge1 = (EditText) findViewById(R.id.charge1);
        charge2 = (EditText) findViewById(R.id.charge2);
        charge3 = (EditText) findViewById(R.id.charge3);
        hours1 = (EditText) findViewById(R.id.hours1);
        hours2 = (EditText) findViewById(R.id.hours2);
        hours3 = (EditText) findViewById(R.id.hours3);
        result = (TextView) findViewById(R.id.result);
        result2 = (TextView) findViewById(R.id.result2);
        calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = name1.getText().toString();
                String n2 = name2.getText().toString();
                String n3 = name3.getText().toString();
                String ln1 = lastname1.getText().toString();
                String ln2= lastname2.getText().toString();
                String ln3 = lastname3.getText().toString();
                String c1 = charge1.getText().toString();
                String c2 = charge2.getText().toString();
                String c3 = charge3.getText().toString();
                double h1 = Double.parseDouble(hours1.getText().toString());
                double h2 = Double.parseDouble(hours2.getText().toString());
                double h3 = Double.parseDouble(hours3.getText().toString());
                double AFP = 9.75*h1*(0.0688);
                double ISSS = 9.75*h1-AFP*(0.0525);
                double RENTA = 9.75*h1-ISSS*(0.10);

              if (h1<=0 && h2<=0 && h3<=0){
                  Toast.makeText(MainActivity.this,"Numero de horas invalido", Toast.LENGTH_SHORT).show();
              }else if(h1<=160){
                  result.setText("Empleado 1" +"\n"+ n1+""+""+ln1+","+c1 +"," + "se le pagara:" + "" + (9.75*h1) + "\n" + "Empleado 2" +"\n"+ n2+""+""+ln2+","+c2 +"," + "se le pagara:" + "" + (9.75*h2)+ "\n"+ "Empleado 3" +"\n"+ n3+""+""+ln3+","+c3 +"," + "se le pagara:" + "" + (9.75*h3) );
                  result2.setText("Deducciones de Ley" + "\n" + "Empleado 1"+ " " + "AFP" + AFP + "" + "ISSS" + ISSS + "" + "Renta" + RENTA + "\n" + "Sueldo liquido:" + RENTA);
              }

            }
        });

    }
}