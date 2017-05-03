package com.example.lucia.contacto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ConfirmarContactoActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaNac;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_contacto);

        Bundle parametros = getIntent().getExtras();
        String Nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String Fecha_Nac = parametros.getString(getResources().getString(R.string.pfecha_nac));
        String Telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String Email = parametros.getString(getResources().getString(R.string.pemail));
        String Descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

        tvNombre = (TextView) findViewById(R.id.tv_nombre);
        tvFechaNac = (TextView) findViewById(R.id.tv_fecha_nacimiento2);
        tvTelefono= (TextView) findViewById(R.id.tv_telefono2);
        tvEmail= (TextView) findViewById(R.id.tv_email2);
        tvDescripcion = (TextView) findViewById(R.id.tv_descripcion2);

        tvNombre.setText(Nombre);
        tvFechaNac.setText(Fecha_Nac);
        tvTelefono.setText(Telefono);
        tvEmail.setText(Email);
        tvDescripcion.setText(Descripcion);
    }

    public void llama_editar_datos (View view) {
         Intent intent = new Intent();
         setResult(RESULT_OK,intent);
         finish();
    }
}
