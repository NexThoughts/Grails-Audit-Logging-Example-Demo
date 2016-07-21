//import grails.plugin.springsecurity.SpringSecurityUtils

//import org.codehaus.groovy.grails.plugin.springsecurity.SpringSecurityUtils

dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'
}

environments {
    development {
        grails.serverURL = "http://127.0.0.1:8080"

        dataSource {
            dbCreate = "create"
            url = "jdbc:mysql://localhost:3306/audit_demo?autoreconnect=true"
            username = "root"
            password = "nextdefault"
        }
    }
    production {
    }
    test {
        dataSource {
            username = "root"
            password = "nextdefault"
            dbCreate = "none"
            url = "jdbc:mysql://localhost:3306/audit_demo?autoreconnect=true"
            pooled = true
            properties {
                maxActive = -1
                minEvictableIdleTimeMillis = 1800000
                timeBetweenEvictionRunsMillis = 1800000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1"
            }


        }
    }

}
grails.plugin.springsecurity.debug.useFilter = true
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.successHandler.alwaysUseDefault = true
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/public/landing'

// Added by the Audit-Logging plugin:
//grails {
//    plugin {
//        auditLog {
//            auditDomainClassName = 'com.audit.audit.AuditTrail'
//            logIds = true  // log db-ids of associated objects.
//            actorClosure = { request, session ->
//                if (request.applicationContext.springSecurityService.principal instanceof String) {
//                    return request.applicationContext.springSecurityService.principal
//                }
//                def username = request.applicationContext.springSecurityService.principal?.username
//                if (SpringSecurityUtils.isSwitched()) {
//                    username = SpringSecurityUtils.switchedUserOriginalUsername + " AS " + username
//                }
//                return username
//            }
//        }
//    }
//}


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.audit.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.audit.security.UserRole'
grails.plugin.springsecurity.authority.className = 'com.audit.security.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

