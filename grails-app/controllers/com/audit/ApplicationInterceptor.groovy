package com.audit

class ApplicationInterceptor {

    def springSecurityService

    ApplicationInterceptor() {
        match(uri: '/*/*/*')
        match(uri: '/*/*')
        match(uri: '/*')
    }

    boolean before() {
        println "####### Date : ${new Date()}, Params : ${params}"
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
