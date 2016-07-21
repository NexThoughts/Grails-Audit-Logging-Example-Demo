package com.audit

class City {

    static auditable = [ignoreEvents: ["onSave"], ignore: ['version', 'lastUpdated', 'dateCreated']]

    String name
    String state
    String country
    Date dateCreated
    Date lastUpdated

    static hasMany = [persons: Person]

    static constraints = {
    }
}
