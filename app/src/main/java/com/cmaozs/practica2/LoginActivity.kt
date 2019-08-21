package com.cmaozs.practica2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import android.R.attr.data
import androidx.core.app.NotificationCompat.getExtras
import android.util.Patterns





class LoginActivity : AppCompatActivity() {

    private var email = "null"
    private var password = "null"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        btCreateaccount.setOnClickListener{
            var intent = Intent(this,AccountActivity::class.java)
            startActivityForResult(intent, 4598)
        }

        btSignin.setOnClickListener{
            var email_login: String = etEmail.text.toString()
            var password_login: String = etPassword.text.toString()
            if(email.equals("null") && password.equals("null")){
                etEmail.setError("Registrese por favor")
                etPassword.setError("Registrese por favor")
            }

            else {
                if (email_login.equals("") && password_login.equals("")){
                    etEmail.setError("Ingrese correo")
                    etPassword.setError("Ingrese contraseña")
                }

                else if (email_login.equals("")){
                    etEmail.setError("Ingrese correo")
                }

                else if (password_login.equals("")){
                    etPassword.setError("Ingrese contraseña")
                }

                else {
                    if (!email_login.equals(email) && !password_login.equals(password)){
                        etEmail.setError("Correos no coinciden")
                        etPassword.setError("Contraseñas no coinciden")
                    }

                    else if (!email_login.equals(email)){
                        etEmail.setError("Correos no coinciden")
                    }

                    else if (!password_login.equals(password)) {
                        etPassword.setError("Contraseñas no coinciden")
                    }

                    else {
                        var intent: Intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("Email", email)
                        intent.putExtra("Password", password)
                        startActivityForResult(intent, 4599)
                    }
                }

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 4598 && resultCode == Activity.RESULT_OK){
            val extras = data?.getExtras()
            if (extras != null) {
                email = extras.getString("Correo").toString()
                password = extras.getString("Password").toString()
            }
        }
        else if (requestCode == 4599 && resultCode == Activity.RESULT_OK){
            val extras = data?.getExtras()
            if (extras != null) {
                email = extras.getString("Correo").toString()
                password = extras.getString("Password").toString()
            }
        }
    }
}
