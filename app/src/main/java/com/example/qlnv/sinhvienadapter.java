package com.example.qlnv;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class sinhvienadapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<SinhVien> list;

    public sinhvienadapter(Context context, ArrayList<SinhVien> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_list,parent,false);
        //ánh xạ
        TextView txtmasv = convertView.findViewById(R.id.txtma);
        TextView txttensv = convertView.findViewById(R.id.ten);
        TextView txttuoisv = convertView.findViewById(R.id.tuoi);
        Button btnud = convertView.findViewById(R.id.btnupdate);
        Button btndelete = convertView.findViewById(R.id.btndelete);


        //gans dl
        txtmasv.setText(list.get(position).getMssv());
        txttensv.setText(list.get(position).getTen());
 txttuoisv.setText(list.get(position).getTuoi());
        //btn xoa
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);

                notifyDataSetChanged();
                Xfile.ghifile(context,"sv.txt",list);
                Toast.makeText(context, "ĐÃ XÓA", Toast.LENGTH_SHORT).show();

            }
        });
        SinhVien sv = list.get(position);
        btnud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendiaogud(sv);
            }
        });







        return convertView;
    }
    public void opendiaogud(SinhVien sv){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context ).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_update,null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        //Ánh xạ
        EditText txtmasv1 = view.findViewById(R.id.txtmssv1);
        EditText txttenv1 = view.findViewById(R.id.txthoten1);
        EditText txttuoisv1 = view.findViewById(R.id.txttuoii1);
        Button btnudd = view.findViewById(R.id.btnsubmit1);
        //gán dl len tv
        txtmasv1.setText(sv.getMssv());
        txttenv1.setText(sv.getTen());
        txttuoisv1.setText(sv.getTuoi());
        //click update
        btnudd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv.setMssv(txtmasv1.getText().toString());
                sv.setTen(txttenv1.getText().toString());
                sv.setTuoi(txttuoisv1.getText().toString());
                dialog.dismiss();
                Xfile.ghifile(context,"sv.txt",list);
                notifyDataSetChanged();
            }
        });







    }
}
