package com.example.serializableparcelable

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AddressBookTest {

    private lateinit var addressBook: AddressBook

    @Before
    fun setUp() {
        addressBook = AddressBook()
    }

    @Test
    fun addPerson_addsPersonToList() {
        val person = Person("John", "Doe", "123 Main St", "1234567890")
        addressBook.addPerson(person)
        assertEquals(1, addressBook.getPersonList().size)
        assertEquals(person, addressBook.getPerson(0))
    }

    @Test
    fun getPersonList_returnsCorrectList() {
        val person1 = Person("John", "Doe", "123 Main St", "1234567890")
        val person2 = Person("Jane", "Doe", "456 Elm St", "0987654321")
        addressBook.addPerson(person1)
        addressBook.addPerson(person2)
        val personList = addressBook.getPersonList()
        assertEquals(2, personList.size)
        assertEquals(person1, personList[0])
        assertEquals(person2, personList[1])
    }
}
