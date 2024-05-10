package com.example.traveljournal2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            // As per the current requirement, it allows any username and password to log in
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Simple check for empty fields
            if (username.isEmpty() || password.isEmpty()) {
                if (username.isEmpty()) usernameEditText.error = "Username cannot be empty"
                if (password.isEmpty()) passwordEditText.error = "Password cannot be empty"
            } else {
                startJournalListActivity()
            }
        }
    }

    private fun startJournalListActivity() {
        // Start the JournalListActivity
        val intent = Intent(this, JournalListActivity::class.java)
        startActivity(intent)
        finish()  // Close LoginActivity
    }
}

