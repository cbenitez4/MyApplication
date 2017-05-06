package com.example.carlos.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText cajanumerouno, cajanumerodos;
    private TextView cajaresultado;
    private Spinner comboopciones;
    private String[] opciones;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajanumerouno = (EditText)findViewById(R.id.editText3);
        cajanumerodos = (EditText)findViewById(R.id.editText4);
        cajaresultado = (TextView)findViewById(R.id.txtresultado);
        comboopciones = (Spinner) findViewById(R.id.cmboperaciones);

        opciones = this.getResources().getStringArray(R.array.opciones);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opciones);
        comboopciones.setAdapter(adapter);

    }

    public void calcular(View v) {

        int op;
        double n1, n2, res=0;

        if (validar()) {

            n1 = Double.parseDouble(cajanumerouno.getText().toString());
            n2 = Double.parseDouble(cajanumerodos.getText().toString());

            op = comboopciones.getSelectedItemPosition();
            switch (op){
                case 0:
                    res = n1+n2;
                    break;
                case 1:
                    res = n1-n2;
                    break;
                case 2:
                    res = n1*n2;
                    break;
                case 3:
                    res = n1/n2;
                    break;
            }
            cajaresultado.setText("" + res);
        }
    }

    public boolean validar(){
        if(cajanumerouno.getText().toString().isEmpty()){
            cajanumerouno.requestFocus();
            cajanumerouno.setError(this.getResources().getString(R.string.error_numero_uno));
            return false;
        }
        if(cajanumerodos.getText().toString().isEmpty()){
            cajanumerodos.requestFocus();
            cajanumerodos.setError(this.getResources().getString(R.string.error_numero_dos));
            return false;
        }

        if(comboopciones.getSelectedItemPosition()==3 && Double.parseDouble( cajanumerodos.getText().toString())==0){
            cajanumerodos.requestFocus();
            cajanumerodos.setError(this.getResources().getString(R.string.error_numero_dos_division));
            return false;
        }

        return true;
    }

    public void borrar(View v){
        cajanumerouno.setText("");
        cajanumerodos.setText("");
        cajaresultado.setText("");
        cajanumerouno.requestFocus();
    }


}
