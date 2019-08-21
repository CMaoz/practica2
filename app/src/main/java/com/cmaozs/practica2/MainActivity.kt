package com.cmaozs.practica2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.os.Handler
import android.provider.Settings
import androidx.core.os.HandlerCompat.postDelayed





class MainActivity : AppCompatActivity() {

    private var email = ""
    private var password = ""
    private var canExitApp = false
    private var backpressedtime:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val extras = intent.getExtras()
        if (extras != null) {
            email = extras.getString("Email").toString()
            password = extras.getString("Password").toString()
        }
        tvEmail_main.setText(email)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        var id = item.itemId
        if (id == R.id.mCerrar){
            var intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.putExtra("Correo", email)
            intent.putExtra("Password", password)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        return true
    }

    override fun onBackPressed() {

        super.onBackPressed()

    }

}
