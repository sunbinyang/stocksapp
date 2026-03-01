
package com.example.stockapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView

class StockListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock_list)

        val listView = findViewById<ListView>(R.id.listViewStocks)

        val stocks = listOf(
            Stock("AAPL", 175.23, 2.15),
            Stock("GOOGL", 2801.12, -1.12),
            Stock("TSLA", 250.55, 3.75),
            Stock("AMZN", 134.66, -0.52),
            Stock("MSFT", 330.25, 1.08)
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, stocks.map { it.name })
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selected = stocks[position]
            val intent = Intent()
            intent.putExtra("name", selected.name)
            intent.putExtra("price", selected.price)
            intent.putExtra("change", selected.changePercent)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
