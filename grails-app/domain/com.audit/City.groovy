package com.audit

class City {

    String name
    String state
    String country
    Date dateCreated
    Date lastUpdated

    static hasMany = [persons: Person]

    static constraints = {
    }
}
