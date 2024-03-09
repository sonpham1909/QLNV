package com.example.qlnv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Listnhanvien extends AppCompatActivity {
ListView lstsv;
private ArrayList<SinhVien> listsv = new ArrayList<>();

sinhvienadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listnhanvien);

        //ánh xạ
        lstsv=findViewById(R.id.lstsinhvien);
        Button btnadd = findViewById(R.id.btnadd);

themdl();

if(listsv != null){
    listsv = (ArrayList<SinhVien>) Xfile.docfile(Listnhanvien.this,"nv.txt");
}

        adapter = new sinhvienadapter(this,listsv);
        lstsv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    public void themdl(){
        listsv.add(new SinhVien("ph001","Phạm A","18"));
        listsv.add(new SinhVien("ph002","Phạm b","20"));



    }
    public void opendialogthem(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Listnhanvien.this);
        View view = getLayoutInflater().inflate(R.layout.item_add,null );
        builder1.setView(view);
        Dialog dialog =builder1.create();
        dialog.show();
        //
        EditText txtid = findViewById(R.id.txtmssv);
        EditText txtht = findViewById(R.id.txthoten);
        EditText txtt = findViewById(R.id.txttuoii);
        Button btnthem = findViewById(R.id.btnsubmit);

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String manv = txtid.getText().toString();
                String tennv = txtht.getText().toString();
                String tuoii = txtt.getText().toString();
                listsv.add(new SinhVien(manv,tennv,tuoii));
                Xfile.ghifile(Listnhanvien.this,"sv.txt",listsv);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });





    }
}