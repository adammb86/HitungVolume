package com.example.adammb.hitungvolume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtpanjang, edtlebar, edttinggi;
    private Button btnhitungvolume;
    private TextView txv_volume;
    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onSaveInstanceState(Bundle outState){

        outState.putString(STATE_HASIL, txv_volume.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtpanjang = (EditText) findViewById(R.id.edt_panjang);
        edtlebar = (EditText) findViewById(R.id.edt_lebar);
        edttinggi = (EditText) findViewById(R.id.edt_tinggi);
        btnhitungvolume = (Button) findViewById(R.id.btn_hitungvolume);
        txv_volume = (TextView) findViewById(R.id.txv_volume);

        btnhitungvolume.setOnClickListener(this);

        if(savedInstanceState != null){
            String hasil= savedInstanceState.getString(STATE_HASIL);
            txv_volume.setText(hasil);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_hitungvolume) {
            String panjang = edtpanjang.getText().toString().trim();
            String lebar = edtlebar.getText().toString().trim();
            String tinggi = edttinggi.getText().toString().trim();
            boolean isEmptyField = false;

            if (TextUtils.isEmpty(panjang)) {
                isEmptyField = true;
                edtpanjang.setError("Panjang harus diisi");
            }

            if (TextUtils.isEmpty(lebar)) {
                isEmptyField = true;
                edtpanjang.setError("Lebar harus diisi");
            }

            if (TextUtils.isEmpty(tinggi)) {
                isEmptyField = true;
                edtpanjang.setError("Tinggi harus diisi");
            }

            if (!isEmptyField){
                double p=Double.parseDouble(panjang);
                double l=Double.parseDouble(lebar);
                double t=Double.parseDouble(tinggi);
                double volume= p*l*t;
                txv_volume.setText(String.valueOf(volume));
            }
        }
    }
}
