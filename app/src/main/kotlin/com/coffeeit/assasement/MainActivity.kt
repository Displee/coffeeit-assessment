package com.coffeeit.assasement

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.coffeeit.assasement.activity.SelectYourStyleActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view: ImageView = findViewById(R.id.scan_img)
        view.setOnClickListener {
            val intent = Intent(this, SelectYourStyleActivity::class.java)
            startActivity(intent)
        }
    }

}