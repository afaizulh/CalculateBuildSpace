package com.example.fileawal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.fileawal.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var edtLength: TextInputLayout
    lateinit var edtWidth: TextInputLayout
    lateinit var edtHeight: TextInputLayout
    lateinit var btnResult: Button
    lateinit var btnResultIntent: Button
    lateinit var tvResult: TextView
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        edtLength = binding.edtLength
        edtWidth = binding.edtWidth
        edtHeight = binding.edtHeight
        btnResult = binding.btnResult
        btnResultIntent = binding.btnResultIntent
        tvResult = binding.tvResult

        btnResult.setOnClickListener(this)
        btnResultIntent.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_result -> {
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
            }

            R.id.btn_result_intent -> {
                val intent = Intent(this@MainActivity, IntentHasilActivity::class.java)
                intent.putExtra(IntentHasilActivity.DATA_RES, tvResult.text)
                startActivity(intent)
            }
        }
    }
}
