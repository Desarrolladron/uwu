package com.example.kevin.vale.GridView_segundoFragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.kevin.vale.R;

public class potencia extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,punto;
    private EditText editText;
    private Spinner spinner1 ;

    private TextView res;
    private EditText edNumeros, gradoCente,gradoSexa, milan,minArco,rad, segSe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potencia);


        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar...
                finish();
            }
        });
        gradoCente =(EditText)findViewById(R.id.vatio);
        gradoSexa = (EditText)findViewById(R.id.kilovatio);
        milan = (EditText)findViewById(R.id.megaV);
        minArco = (EditText) findViewById(R.id.caballoK);
        rad = (EditText) findViewById(R.id.caballoHP);
        segSe = (EditText) findViewById(R.id.julioxSeg);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);


        punto = (Button) findViewById(R.id.punto);


        edNumeros = (EditText) findViewById(R.id.numero);
        spinner1 = (Spinner) findViewById(R.id.spinner1);



        String[] opciones = {"Grado centesimal","Grado sexagesimal","Mil angular","Minuto de arco","Radián",
                "Segundo sexagesimal"};




        // Ocultar teclado virtual
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edNumeros.getWindowToken(), 0);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.spinner_item,opciones);




        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                edNumeros.setText("");
                limpiar();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        edNumeros.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //el primero es el kilometro
                String seleccion = spinner1.getSelectedItem().toString();

                if(!charSequence.toString().isEmpty()) {


                    if (seleccion.equals("Grado centesimal")) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 1;
                        gradoCente.setText("" + op);//tonelada

                        double op2 = valor1 * 180/200;//kg
                        gradoSexa.setText("" + op2);

                        double op3 = valor1 * (1000*Math.PI/200);//gr
                        milan.setText("" + op3);

                        double op4 = valor1 * 54;//quilate
                        minArco.setText("" + op4);

                        double op5 = valor1 * (Math.PI/200)    ;//mg
                        rad.setText("" + op5);

                        double op6 = valor1 * 3240;//stone
                        segSe.setText("" + op6);



                    }    else if (seleccion.equals("Grado sexagesimal")) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 200/180;
                        gradoCente.setText("" + op);//tonelada

                        double op2 = valor1 * 1;//kg
                        gradoSexa.setText("" + op2);

                        double op3 = valor1 * (1000*Math.PI/180);//gr
                        milan.setText("" + op3);

                        double op4 = valor1 * 60;//quilate
                        minArco.setText("" + op4);

                        double op5 = valor1 * (Math.PI/180)    ;//mg
                        rad.setText("" + op5);

                        double op6 = valor1 * 3600;//stone
                        segSe.setText("" + op6);



                    }
                    else if (seleccion.equals("Mil angular")) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * (200/1000*Math.PI);
                        gradoCente.setText("" + op);//tonelada

                        double op2 = valor1 * (180/1000*Math.PI);//kg
                        gradoSexa.setText("" + op2);

                        double op3 = valor1 * 1;//gr
                        milan.setText("" + op3);

                        double op4 = valor1 * ((60 * 180)/1000*Math.PI);//quilate
                        minArco.setText("" + op4);

                        double op5 = valor1 /1000   ;//mg
                        rad.setText("" + op5);

                        double op6 = valor1 * ((3600 * 180)/1000*Math.PI);//stone
                        segSe.setText("" + op6);



                    }

                    else if (seleccion.equals("Minuto de arco")) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 60;
                        gradoCente.setText("" + op);//tonelada

                        double op2 = valor1 /60;//kg
                        gradoSexa.setText("" + op2);

                        double op3 = valor1 * (1000*Math.PI/(60 * 180));//gr
                        milan.setText("" + op3);

                        double op4 = valor1 * 1;//quilate
                        minArco.setText("" + op4);

                        double op5 = valor1 *  (Math.PI/(60 * 180))  ;//mg
                        rad.setText("" + op5);

                        double op6 = valor1 * 60;//stone
                        segSe.setText("" + op6);



                    }
                    else if (seleccion.equals("Radián")) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 *  (200/Math.PI);
                        gradoCente.setText("" + op);//tonelada

                        double op2 = valor1 *  (180/Math.PI);//kg
                        gradoSexa.setText("" + op2);

                        double op3 = valor1 * 1000;//gr
                        milan.setText("" + op3);

                        double op4 = valor1 *  ((60 * 180)/Math.PI) ;//quilate
                        minArco.setText("" + op4);

                        double op5 = valor1 *  1 ;//mg
                        rad.setText("" + op5);

                        double op6 = valor1 *(  (3600 * 180)/Math.PI) ;//stone
                        segSe.setText("" + op6);



                    }
                    else if (seleccion.equals("Segundo sexagesimal")) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1/ 3240;
                        gradoCente.setText("" + op);//tonelada

                        double op2 = valor1 / 3600;//kg
                        gradoSexa.setText("" + op2);

                        double op3 = valor1 * ( 1000*Math.PI/(180 * 3600));//gr
                        milan.setText("" + op3);

                        double op4 = valor1 / 60 ;//quilate
                        minArco.setText("" + op4);

                        double op5 = valor1 *  (Math.PI/(180 * 3600)) ;//mg
                        rad.setText("" + op5);

                        double op6 = valor1 * 1 ;//stone
                        segSe.setText("" + op6);



                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void punto(View view){
        int length = edNumeros.getText().length();
        if (length == 0) {
            edNumeros.setText(edNumeros.getText() + "0.");

        }else if(length > 0 && !edNumeros.getText().toString().contains(".")){
            edNumeros.setText(edNumeros.getText() + ".");

        }
    }


    public void onClick1(View view) {
        edNumeros.setText(edNumeros.getText() + "1");
    }

    public void onClick2(View view) {
        edNumeros.setText(edNumeros.getText() + "2");
    }    public void onClick3(View view) {
        edNumeros.setText(edNumeros.getText() + "3");
    }    public void onClick4(View view) {
        edNumeros.setText(edNumeros.getText() + "4");
    }    public void onClick5(View view) {
        edNumeros.setText(edNumeros.getText() + "5");
    }    public void onClick6(View view) {
        edNumeros.setText(edNumeros.getText() + "6");
    }
    public void onClick7(View view) {
        edNumeros.setText(edNumeros.getText() + "7");
    }
    public void onClick8(View view) {
        edNumeros.setText(edNumeros.getText() + "8");
    }
    public void onClick9(View view) {
        edNumeros.setText(edNumeros.getText() + "9");
    }
    public void onClick0(View view) {
        edNumeros.setText(edNumeros.getText() + "0");
    }

    public void borrar(View view){
        int length = edNumeros.getText().length();
        if (length > 0) {
            edNumeros.getText().delete(length - 1, length);


        }
        else if(length==0){

            limpiar();
        }
    }
    public void borrarTodo(View view){
        int length = edNumeros.getText().length();
        if (length > 0) {
            edNumeros.getText().delete(length - length,length);
            edNumeros.setText("");
            limpiar();

        }
    }

    public void limpiar(){ //unidades de masa
        gradoSexa.setText("0" );

        gradoCente.setText("0" );

        milan.setText("0" );

        minArco.setText("0" );

        rad.setText("0" );

        segSe.setText("0" );



    }
}
