package com.example.equipo.termitransr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.equipo.termitransr.databinding.TemplateDestinosBinding;
import com.example.equipo.termitransr.models.Destino;

import java.util.List;


public class DestinoAdapter extends BaseAdapter {

    LayoutInflater inflater;
    List<Destino> data;

    public DestinoAdapter(LayoutInflater inflater, List<Destino> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TemplateDestinosBinding binding = TemplateDestinosBinding.inflate(inflater);
        binding.setDestino(data.get(position));
        return binding.getRoot();


    }
}
