package com.example.carlos.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText cajanumerouno, cajanumerodos;
    private TextView cajaresultado;
    int n1,n2,suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajanumerouno = (EditText)findViewById(R.id.editText3);
        cajanumerodos = (EditText)findViewById(R.id.editText4);
        cajaresultado = (TextView)findViewById(R.id.txtresultado);

    }

    public void calcular(View v) {

        double n1, n2, suma;

        if (validar()) {
            n1 = Double.parseDouble(cajanumerouno.getText().toString());
            n2 = Double.parseDouble(cajanumerodos.getText().toString());
            suma = n1 + n2;
            cajaresultado.setText("" + suma);
        }
    }

    private boolean validar() {
        if (cajanumerouno.getText().toString().isEmpty()){
            cajanumerouno.setError(this.getResources().getString(R.string.error_numero_uno));
            cajanumerouno.requestFocus();
            return false;
        } else if (cajanumerodos.getText().toString().isEmpty()){
            cajanumerodos.setError(this.getResources().getString(R.string.error_numero_dos));
            cajanumerodos.requestFocus();
            return false;
        }return true;
    }

    public void borrar(View v){
        cajanumerouno.setText("");
        cajanumerodos.setText("");
        cajaresultado.setText("");
        cajanumerouno.requestFocus();
    }


}
