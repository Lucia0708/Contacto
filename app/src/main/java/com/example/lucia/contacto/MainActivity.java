package com.example.lucia.contacto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    public final static int VALOR_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     }

    public void llama_confirmar_datos(View view){
         String dat_nombre;
         String dat_telefono;
         String dat_email;
         String dat_descripcion;
         String fecha_nacimiento = "";

         int mes;
         String dias;
         String mess;
         String años;

         Intent intent = new Intent(MainActivity.this, ConfirmarContactoActivity.class);

         TextInputEditText textInputEditText1 = (TextInputEditText) findViewById(R.id.et_Nombre);
         DatePicker datepicker = (DatePicker) findViewById(R.id.dp_Fecha_nac);
         TextInputEditText textInputEditText2 = (TextInputEditText) findViewById(R.id.et_Telefono);
         TextInputEditText textInputEditText3 = (TextInputEditText) findViewById(R.id.et_Email);
         TextInputEditText textInputEditText4 = (TextInputEditText) findViewById(R.id.et_Descripcion);

         dat_nombre = textInputEditText1.getText().toString();
         dat_telefono = textInputEditText2.getText().toString();
         dat_email = textInputEditText3.getText().toString();
         dat_descripcion = textInputEditText4.getText().toString();

         dias = String.valueOf(datepicker.getDayOfMonth());
         mes = datepicker.getMonth()+1;
         mess = String.valueOf(mes);
         años = String.valueOf(datepicker.getYear());

         fecha_nacimiento = dias + "/"+ mess +"/"+ años;

         intent.putExtra(getResources().getString(R.string.pnombre), dat_nombre);
         intent.putExtra(getResources().getString(R.string.ptelefono), dat_telefono);
         intent.putExtra(getResources().getString(R.string.pemail), dat_email);
         intent.putExtra(getResources().getString(R.string.pdescripcion), dat_descripcion);
         intent.putExtra(getResources().getString(R.string.pfecha_nac), fecha_nacimiento);

// utilize esta llamada de startActivity porque asegura un canal y nos manda una respuesta de resultado.


        startActivityForResult(intent, VALOR_REQUEST_CODE);
     }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VALOR_REQUEST_CODE){
            if (resultCode == RESULT_OK ) {
              //  Se revisa que es respuesta a la misma peticion de este Activity y que no hubo errores
            }
        }
    }

   }
