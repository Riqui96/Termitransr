package com.example.equipo.termitransr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.equipo.termitransr.databinding.TemplateDestinosbaseBinding;
import com.example.equipo.termitransr.models.DestinoBase;

import java.util.List;

/**
 * Created by EQUIPO on 1/06/2016.
 */
public class DestinoBaseAdapter extends BaseAdapter {

    LayoutInflater inflater;
    List<DestinoBase> data;
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
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TemplateDestinosbaseBinding binding = TemplateDestinosbaseBinding.inflate(inflater);
        binding.setDestinobase(data.get(position));
        return binding.getRoot();
    }
}
