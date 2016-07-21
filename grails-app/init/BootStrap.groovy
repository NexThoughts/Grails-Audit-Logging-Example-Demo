import com.audit.security.User
import com.audit.security.Role
import com.audit.security.UserRole

class BootStrap {
    def springSecurityService

    public static final ROLE_SUPER_ADMIN = 'ROLE_SUPER_ADMIN'

    def init = { servletContext ->

        createRoles()
        createSuperAdminUsers()

    }
    def destroy = {

    }


    def createRoles() {
        Role.findByAuthority(ROLE_SUPER_ADMIN) ?: new Role(authority: ROLE_SUPER_ADMIN).save()
    }

    def createSuperAdminUsers() {
        println "****** Creating Admin Users ***********"
        Role superAdminRole = Role.findByAuthority(ROLE_SUPER_ADMIN) ?: new Role(authority: ROLE_SUPER_ADMIN).save(flush: true)
        createSuperAdminUser("vishal@nexthoughts.com", '1234', superAdminRole)
    }

    void createSuperAdminUser(String username, String password, Role role) {
        if (!User.findByUsername(username)) {
            User user = new User(username, password)
            user.password = password
            user.save(flush:true)
            UserRole.create(user, role, true)
            println "#### Created Super Admin User: " + username
        }
    }
}
