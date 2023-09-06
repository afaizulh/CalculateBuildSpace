package com.example.fileawal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtLength : TextInputLayout
    private lateinit var edtWidth : TextInputLayout
    private lateinit var edtHeight : TextInputLayout
    private lateinit var btnResult : Button
    lateinit var btnResultIntent : Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        edtLength = findViewById(R.id.edt_length)
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        btnResult = findViewById(R.id.btn_result)
        btnResultIntent = findViewById(R.id.btn_result_intent)
        tvResult = findViewById(R.id.tv_result)

        btnResult.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_result) {
            val getLength = edtLength.editText?.text.toString().trim()
            val getWidth = edtWidth.editText?.text.toString().trim()
            val getHeight = edtHeight.editText?.text.toString().trim()
            val msg = "Tidak boleh kosong"

            if (getLength.isEmpty()) {
                edtLength.error = msg
                return
            }
            if (getWidth.isEmpty()) {
                edtWidth.error = msg
                return
            }
            if (getHeight.isEmpty()) {
                edtHeight.error = msg
                return
            }

            val result = getLength.toDouble() * getWidth.toDouble() * getHeight.toDouble()
            tvResult.text = result.toString()

            btnResultIntent.setOnClickListener{
                val intent = Intent(this@MainActivity, IntentHasilActivity::class.java)
                intent.putExtra(IntentHasilActivity.HASIL, result.toString())
                startActivity(intent)
            }
        }
    }
}