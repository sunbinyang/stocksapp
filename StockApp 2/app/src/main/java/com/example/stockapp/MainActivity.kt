
package com.example.stockapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSelect = findViewById<Button>(R.id.btnSelectStock)

        btnSelect.setOnClickListener {
            val intent = Intent(this, StockListActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            findViewById<TextView>(R.id.tvStockName).text = data?.getStringExtra("name")
            findViewById<TextView>(R.id.tvStockPrice).text = "$" + data?.getDoubleExtra("price", 0.0)
            findViewById<TextView>(R.id.tvStockChange).text =
                data?.getDoubleExtra("change", 0.0).toString() + "%"
        }
    }
}
