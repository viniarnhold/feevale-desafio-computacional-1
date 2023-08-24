package com.example.freqmax;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    public EditText nomePessoa, idadePessoa;
    public ListView listViewPessoas;
    public List<Pessoa> pessoas = new ArrayList<>();
    public PessoaAdapter pessoaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPessoas = findViewById(R.id.listPessoas);
        pessoaAdapter = new PessoaAdapter(getBaseContext(), pessoas);
        listViewPessoas.setAdapter(pessoaAdapter);

    }

    public void adicionarPessoas(View view){
        nomePessoa = findViewById(R.id.editNome);
        idadePessoa = findViewById(R.id.editIdade);
        String nome = String.valueOf(nomePessoa.getText());
        Integer idade = Integer.valueOf(String.valueOf(idadePessoa.getText()));
        if(idade < 0){
            Toast toast = Toast.makeText(getBaseContext(), "Idade inválida!", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if(nome.isEmpty()){
            Toast toast = Toast.makeText(getBaseContext(),
                    "Deve ser informado um nome válidp", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        Pessoa pessoa = new Pessoa(nome, idade);
        pessoas.add(pessoa);

        List<Pessoa> sortedList = pessoas.stream()
                .sorted(Comparator.comparing(Pessoa::getIdade))
                .collect(Collectors.toList());
        pessoas.clear();
        for(Pessoa pessoaAux : sortedList){
            pessoas.add(pessoaAux);
        }
        nomePessoa.setText("");
        idadePessoa.setText("");
        pessoaAdapter.notifyDataSetChanged();
    }
}