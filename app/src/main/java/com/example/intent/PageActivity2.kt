package com.example.intent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PageActivity2 : AppCompatActivity() {
    private lateinit var txtNama: TextView
    private lateinit var txtAlamat: TextView
    private lateinit var txtHobi: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent = getIntent()
        val bundle = intent.extras
        val nama = intent.extras?.getString("Nama") ?: ""
        val alamat = intent.extras?.getString("Alamat") ?: ""
        val hobi = intent.extras?.getString("Hobi") ?: ""

        txtNama = findViewById(R.id.txt1)
        txtAlamat = findViewById(R.id.txt2)
        txtHobi = findViewById(R.id.txt3)

        txtNama.text = "Nama: $nama"
        txtAlamat.text = "Alamat: $alamat"
        txtHobi.text = "Hobi: $hobi"

    }
}