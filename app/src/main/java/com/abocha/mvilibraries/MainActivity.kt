package com.abocha.mvilibraries

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abocha.mvilibraries.mosby.MosbyActivity
import com.abocha.mvilibraries.mvicore.MviCoreActivity
import com.abocha.mvilibraries.roxie.RoxieActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.mosby_button).apply {
            setOnClickListener {
                val intent = Intent(this@MainActivity, MosbyActivity::class.java)
                startActivity(intent)
                Toast.makeText(this@MainActivity, "MVI", Toast.LENGTH_LONG).show()
            }
        }

        findViewById<Button>(R.id.roxie_button).apply {
            setOnClickListener {
                val intent = Intent(this@MainActivity, RoxieActivity::class.java)
                startActivity(intent)
                Toast.makeText(this@MainActivity, "cool", Toast.LENGTH_LONG).show()
            }
        }

        findViewById<Button>(R.id.mvi_core_button).apply {
            setOnClickListener {
                val intent = Intent(this@MainActivity, MviCoreActivity::class.java)
                startActivity(intent)
                Toast.makeText(this@MainActivity, "architecture", Toast.LENGTH_LONG).show()
            }
        }
    }
}