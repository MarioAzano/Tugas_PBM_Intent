package com.example.intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var btnExplicit: Button
    private lateinit var edtNama: EditText
    private lateinit var edtAlamat: EditText
    private lateinit var edtHobi: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnExplicit = findViewById(R.id.btnExplicit)
        btnExplicit.setOnClickListener(this)
        edtNama = findViewById(R.id.EdtNama)
        edtAlamat = findViewById(R.id.Edtalamat)
        edtHobi = findViewById(R.id.EdtHobi)
    }



    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnExplicit -> {
                //fungsi intent dijalankan (di dlm aksi button)
                //deklarasi intent
                val intentExplicit = Intent(this@HomeActivity,
                    PageActivity2::class.java)

                val nama: String = edtNama.getText().toString()
                val alamat: String = edtAlamat.getText().toString()
                val hobi: String = edtHobi.getText().toString()

                val bundle = Bundle()
                bundle.putString("Nama", nama)
                bundle.putString("Alamat", alamat)
                bundle.putString("Hobi", hobi)

                intentExplicit.putExtras(bundle);
                //run intent
                startActivity(intentExplicit)
            }
        }
    }
}