package com.example.serializableparcelable

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var firstNameText: TextView
    private lateinit var lastNameText: TextView
    private lateinit var addressText: TextView
    private lateinit var phoneText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        firstNameText = findViewById(R.id.firstNameText)
        lastNameText = findViewById(R.id.lastNameText)
        addressText = findViewById(R.id.addressText)
        phoneText = findViewById(R.id.phoneText)

        val person = intent.getParcelableExtra<Person>("person")
        person?.let {
            firstNameText.text = it.firstName
            lastNameText.text = it.lastName
            addressText.text = it.address
            phoneText.text = it.phone
        }
    }
}

