package practice1;

import com.google.common.collect.ImmutableList;

public class Security {

    private SecurityChecker securityChecker;

    public Security(SecurityChecker checker) {
        this.securityChecker = checker;
    }

   /* public boolean hasAccess(User user, Permission permission, ImmutableList<Permission> permissions) {

        boolean isAccess = false;
        if (user == null) {
            return isAccess;
        }

        if (permission == null) {
            return isAccess;
        }

        if (permissions.size() == 0) {
            return isAccess;
        }

        if (securityChecker.isAdmin()) {
            isAccess = true;
        }



        if (this.securityChecker.checkPermission(user, permission) || permissions.contains(permission)) {
            isAccess = true;
        }


        return isAccess;
    }*/

    public boolean hasAccess(User user, Permission permission, ImmutableList<Permission> permissions) {

        if (user == null) return false;
        if (permission == null) return false;
        if (permissions.size() == 0) return false;
        if (securityChecker.isAdmin()) return true;
        if (!this.securityChecker.checkPermission(user, permission) && !permissions.contains(permission)) return false;
        return true;
    }
}
