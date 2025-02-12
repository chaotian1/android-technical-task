package com.example.minimoneybox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import java.util.regex.Pattern
import android.animation.Animator
import android.content.Intent
import android.view.View


/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

    lateinit var btn_sign_in : Button
    lateinit var til_email : TextInputLayout
    lateinit var et_email : EditText
    lateinit var til_password : TextInputLayout
    lateinit var et_password : EditText
    lateinit var til_name : TextInputLayout
    lateinit var et_name : EditText
    lateinit var pigAnimation : LottieAnimationView
    val USER_NAME = "userName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupViews()
    }

    override fun onStart() {
        super.onStart()
        setupAnimation()
        configAnimation()
    }



    private fun setupViews() {
        btn_sign_in = findViewById(R.id.btn_sign_in)
        til_email = findViewById(R.id.til_email)
        et_email = findViewById(R.id.et_email)
        til_password = findViewById(R.id.til_password)
        et_password = findViewById(R.id.et_password)
        til_name = findViewById(R.id.til_name)
        et_name = findViewById(R.id.et_name)
        pigAnimation = findViewById(R.id.animation)

        btn_sign_in.setOnClickListener {
            if (allFieldsValid()) {
                Toast.makeText(this, R.string.input_valid, Toast.LENGTH_LONG).show()
                sendMessage()
            }
        }
    }

    fun sendMessage() {
        val message = et_name.text.toString()
        val intent = Intent(this, UserAccountActivity::class.java).apply {
            putExtra(USER_NAME, message)
        }
        startActivity(intent)
    }

    private fun allFieldsValid() : Boolean {
        var allValid = 2

        if (Pattern.matches(EMAIL_REGEX, et_email.text.toString())) {
         //   allValid = true
            allValid --
        } else {
            til_email.error = getString(R.string.email_address_error)
        }

        if (Pattern.matches(PASSWORD_REGEX, et_password.text.toString())) {
        //    allValid = true
            allValid --
        } else {
            til_password.error = getString(R.string.password_error)
        }

        if(!et_name.text.isEmpty()){
        if (!Pattern.matches(NAME_REGEX, et_name.text.toString())) {
            allValid ++
            til_email.error = getString(R.string.full_name_error)
        }}
        when (allValid){
            0 -> return true
            else -> return false
        }
    }

    private fun setupAnimation() {
        pigAnimation.playAnimation()
    }

    private fun configAnimation(){

        pigAnimation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animator: Animator) { pigAnimation.setMaxFrame(109) }
            override fun onAnimationRepeat(animator: Animator) { /* no operation */ }
            override fun onAnimationCancel(animator: Animator) { /* no operation */ }
            override fun onAnimationEnd(animator: Animator) {
                pigAnimation.playAnimation()
                pigAnimation.setMinAndMaxFrame(131, 158)
                pigAnimation.repeatCount = LottieDrawable.INFINITE            }
        })
    }

    companion object {
        val EMAIL_REGEX = "[^@]+@[^.]+\\..+"
        val NAME_REGEX = "[a-zA-Z]{6,30}"
        val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[A-Z]).{10,50}$"
    }
}
