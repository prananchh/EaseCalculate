package com.example.easecalculate

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonAdd: Button
    private lateinit var buttonSub: Button
    private lateinit var buttonMul: Button
    private lateinit var buttonDiv: Button
    private lateinit var editTextN1: EditText
    private lateinit var editTextN2: EditText
    private lateinit var textView: TextView

    private var num: Int = 0;
    private var num2: Int =0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonAdd = findViewById(R.id.btn_add)
        buttonSub = findViewById(R.id.btn_sub)
        buttonMul = findViewById(R.id.btn_mul)
        buttonDiv = findViewById(R.id.btn_div)
        editTextN1 = findViewById(R.id.number1)
        editTextN2 = findViewById(R.id.number2)
        textView = findViewById(R.id.answer)

        buttonAdd.setOnClickListener(this)
        buttonSub.setOnClickListener(this)
        buttonMul.setOnClickListener(this)
        buttonDiv.setOnClickListener(this)

    }

    fun getIntFromEditText(editText: EditText): Int {
        return if (editText.text.toString().isEmpty()) {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show()
            0
        } else {
            editText.text.toString().toInt()
        }
    }

    override fun onClick(view: View?) {
        var num1 = getIntFromEditText(editTextN1)
        var num2 = getIntFromEditText(editTextN2)

        when (view?.id) {
            R.id.btn_add -> textView.text = "Answer = ${num1 + num2}"
            R.id.btn_sub -> textView.text = "Answer = ${num1 - num2}"
            R.id.btn_mul -> textView.text = "Answer = ${num1 * num2}"
            R.id.btn_div -> textView.text = if (num2 != 0) { "Answer = ${num1.toFloat() / num2.toFloat()}"
            } else {
                "Cannot divide by zero"
            }
        }
    }

    }






