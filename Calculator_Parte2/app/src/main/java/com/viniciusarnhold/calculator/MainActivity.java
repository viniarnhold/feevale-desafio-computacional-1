package com.viniciusarnhold.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botao9, botao0,
    botaoSoma, botaoSubtrac, botaoDivisao, botaoMultip, botaoPonto, botaoResultado, botaoClear;
    private TextView expressao, resultado;
    private Double numero1, numero2, numeroResultado;
    private String numeroString, operacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();

        numero1 = null;
        numero2 = null;
        numeroResultado = null;
        numeroString = "";
        operacao = "";

        botao0.setOnClickListener(this);
        botao1.setOnClickListener(this);
        botao2.setOnClickListener(this);
        botao3.setOnClickListener(this);
        botao4.setOnClickListener(this);
        botao5.setOnClickListener(this);
        botao6.setOnClickListener(this);
        botao7.setOnClickListener(this);
        botao8.setOnClickListener(this);
        botao9.setOnClickListener(this);
        botaoSoma.setOnClickListener(this);
        botaoSubtrac.setOnClickListener(this);
        botaoDivisao.setOnClickListener(this);
        botaoMultip.setOnClickListener(this);
        botaoPonto.setOnClickListener(this);
        botaoClear.setOnClickListener(this);
        botaoResultado.setOnClickListener(this);
    }
    
    public void abrirHistory(View view) {
        Intent intent = new Intent(getBaseContext(), History.class);
        intent.putStringArrayListExtra("listHistory", Global.history);
        startActivity(intent);
    }

    public void adicionarExpressao(String string, boolean clear, boolean numero){
        if(numero1 != null && numeroResultado != null && (numero && operacao.equals(""))){
            return;
        }
        if(numeroString.isEmpty() && numero == false && string.equals("=")){
            return;
        }
        if(string.equals("=") && numero1 != null && !numeroString.isEmpty()){
            numero2 = Double.valueOf(numeroString);
            switch(operacao) {
                case "+":
                    numeroResultado = numero1 + numero2;
                    break;
                case "-":
                    numeroResultado = numero1 - numero2;
                    break;
                case "*":
                    numeroResultado = numero1 * numero2;
                    break;
                case "/":
                    numeroResultado = numero1 / numero2;
                    break;
            }
            resultado.setText(numeroResultado.toString());
            Global.history.add(expressao.getText() + " = " + resultado.getText());

            numero1 = numeroResultado;
            numero2 = null;
            operacao = "";
            numeroString = "";
        }
        if(clear){
            numeroString = "";
            operacao = null;
            numero1 = null;
            numero2 = null;
            expressao.setText("");
            resultado.setText("");
            return;
        }
        if(numero == true){
            numeroString = numeroString + string;

        } else if(numero == false && !numeroString.isEmpty()){
            numero1 = Double.valueOf(numeroString);
            operacao = string;
            numeroString = "";
        } else {
            operacao = string;
        }
        if("=".equals(operacao)){
            operacao = "";
        }
        if(numero1 == null){
            expressao.setText(numeroString);
        } else {
            expressao.setText(numero1.toString() + " " + operacao + " " +numeroString);
        }
    }

    public void iniciarComponentes(){
        botao1 = findViewById(R.id.button1);
        botao2 = findViewById(R.id.button2);
        botao3 = findViewById(R.id.button3);
        botao4 = findViewById(R.id.button4);
        botao5 = findViewById(R.id.button5);
        botao6 = findViewById(R.id.button6);
        botao7 = findViewById(R.id.button7);
        botao8 = findViewById(R.id.button8);
        botao9 = findViewById(R.id.button9);
        botao0 = findViewById(R.id.button0);
        botaoSoma = findViewById(R.id.buttonAdicao);
        botaoSubtrac = findViewById(R.id.buttonSubtracao);
        botaoDivisao = findViewById(R.id.buttonDivisao);
        botaoMultip = findViewById(R.id.buttonMultiplicacao);
        botaoResultado = findViewById(R.id.buttonResultado);
        botaoPonto = findViewById(R.id.buttonPonto);
        resultado = findViewById(R.id.resultado);
        botaoClear = findViewById(R.id.buttonClear);
        expressao = findViewById(R.id.expressao);
        resultado = findViewById(R.id.resultado);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button0){
            adicionarExpressao("0", false, true);
        }
        if(v.getId() == R.id.button1){
            adicionarExpressao("1", false, true);
        }
        if(v.getId() == R.id.button2){
            adicionarExpressao("2", false, true);
        }
        if(v.getId() == R.id.button3){
            adicionarExpressao("3", false, true);
        }
        if(v.getId() == R.id.button4){
            adicionarExpressao("4", false, true);
        }
        if(v.getId() == R.id.button5){
            adicionarExpressao("5", false, true);
        }
        if(v.getId() == R.id.button6){
            adicionarExpressao("6", false, true);
        }
        if(v.getId() == R.id.button7){
            adicionarExpressao("7", false, true);
        }
        if(v.getId() == R.id.button8){
            adicionarExpressao("8", false, true);
        }
        if(v.getId() == R.id.button9){
            adicionarExpressao("9", false, true);
        }
        if(v.getId() == R.id.buttonAdicao){
            adicionarExpressao("+", false, false);
        }
        if(v.getId() == R.id.buttonSubtracao){
            adicionarExpressao("-", false, false);
        }
        if(v.getId() == R.id.buttonDivisao){
            adicionarExpressao("/", false, false);
        }
        if(v.getId() == R.id.buttonMultiplicacao){
            adicionarExpressao("*", false, false);
        }
        if(v.getId() == R.id.buttonPonto){
            adicionarExpressao(".", false, true);
        }
        if(v.getId() == R.id.buttonClear){
            adicionarExpressao("", true, false);
        }
        if(v.getId() == R.id.buttonResultado){
            adicionarExpressao("=", false, false);
        }

    }
}