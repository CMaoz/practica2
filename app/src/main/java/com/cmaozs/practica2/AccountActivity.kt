package com.cmaozs.practica2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

       btaccount.setOnClickListener {
            var email: String = etEmail_account.text.toString()
            var password: String = etPassword_account.text.toString()
            var reppassword: String = etRepassword.text.toString()
            var intent: Intent = Intent(this, LoginActivity::class.java)



            if(email.equals("") && password.equals("") && reppassword.equals("")){
                etEmail_account.setError("Ingrese el correo")
                etPassword_account.setError("Ingrese la contraseña")
            }

           else if (!validarEmail(email)){
                etEmail_account.setError("Correo no válido")
           }

           else if (password.length < 6){
               etPassword_account.setError("Contraseña mínima 6 caracteres")
           }

           else if(password.equals("")){

               etPassword_account.setError("Ingrese la contraseña")
           }

           else if(reppassword.equals("")){

               etRepassword.setError("Ingrese repetir contraseña")
           }

            else if (!password.equals(reppassword)){
               etPassword_account.setError("Contraseñas no coinciden")
               etRepassword.setError("Contraseñas no coinciden")
            }


            else{
                intent.putExtra("Correo", email)
                intent.putExtra("Password", password)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }


    private fun validarEmail(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }
}



