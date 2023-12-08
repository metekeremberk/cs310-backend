package com.gymgyme.exercise.model;

public class LoginResponseDTO {

    private ApplicationUser applicationUser;
    private String jwt;

    public LoginResponseDTO() {
        super();
    }

    public LoginResponseDTO(ApplicationUser applicationUser, String jwt) {
        super();
        this.applicationUser = applicationUser;
        this.jwt = jwt;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
