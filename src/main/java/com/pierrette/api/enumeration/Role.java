package com.pierrette.api.enumeration;

public enum Role {
    Operateur_formel, Operateur_informel, Administrateur, Utilisateur;

    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
