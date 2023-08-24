package com.example.freqmax;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PessoaAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<Pessoa> pessoas;

    public PessoaAdapter(Context context, List<Pessoa> pessoas){
        this.inflater = LayoutInflater.from(context);
        this.pessoas = pessoas;
    }

    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Object getItem(int position) {
        return pessoas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.pessoa_item, null);
        TextView textNome = view.findViewById(R.id.textNomeItem);
        TextView textFcm = view.findViewById(R.id.textFcmItem);
        Pessoa pessoa = pessoas.get(position);
        textNome.setText(pessoa.getNome());
        textFcm.setText("FCM: " + pessoa.getFcm().toString());
        return view;
    }
}
