package com.example.serializableparcelable

class AddressBook {
    private val personList = mutableListOf<Person>()

    fun addPerson(person: Person) {
        personList.add(person)
    }

    fun getPersonList(): List<Person> {
        return personList
    }

    fun getPerson(position: Int): Person {
        return personList[position]
    }
}
