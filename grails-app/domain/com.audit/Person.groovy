package com.audit

class Person {

    String firstName
    String lastName
    Long age
    Date dateCreated
    Date lastUpdated


    static belongsTo = [city: City]

    static constraints = {
        firstName(nullable: false)
        lastName(nullable: false)
    }


    def onSave = {
        println "new person inserted"
        // may optionally refer to newState map
    }

    def onDelete = {
        println "person was deleted"
        // may optionally refer to oldState map
    }

    def onChange = { oldMap, newMap ->
        println "Person was changed ..."
        oldMap.each({ key, oldVal ->
            if (oldVal != newMap[key]) {
                println " * $key changed from $oldVal to " + newMap[key]
            }
        })
    }
}