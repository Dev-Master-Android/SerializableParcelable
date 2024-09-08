package com.example.serializableparcelable

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.serializableparcelable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var firstNameInput: EditText
    private lateinit var lastNameInput: EditText
    private lateinit var addressInput: EditText
    private lateinit var phoneInput: EditText
    private lateinit var saveButton: Button
    private lateinit var personListView: ListView
    private lateinit var toolbar: Toolbar

    private val addressBook = AddressBook()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firstNameInput = binding.firstNameInput
        lastNameInput = binding.lastNameInput
        addressInput = binding.addressInput
        phoneInput = binding.phoneInput
        saveButton = binding.saveButton
        personListView = binding.personListView


        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            addressBook.getPersonList().map {""})
        personListView.adapter = adapter

        onClickButton(saveButton, firstNameInput, lastNameInput,
            addressInput, phoneInput, addressBook, adapter)

        personListView.setOnItemClickListener { _, _, position, _ ->
            val selectedPerson = addressBook.getPerson(position)
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("person", selectedPerson)
            }
            startActivity(intent)
        }
    }

    private fun onClickButton(
        button: Button,
        firstName: EditText,
        lastName: EditText,
        address: EditText,
        phone: EditText,
        addressBook: AddressBook,
        adapter: ArrayAdapter<String>
    ) {
        button.setOnClickListener {
            val person = Person(
                firstName.text.toString(),
                lastName.text.toString(),
                address.text.toString(),
                phone.text.toString()
            )
            addressBook.addPerson(person)
            adapter.add("${person.firstName} ${person.lastName}")
            firstName.text.clear()
            lastName.text.clear()
            address.text.clear()
            phone.text.clear()
        }
    }
}
