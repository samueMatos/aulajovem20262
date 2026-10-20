package com.example.aulajovem20262ia.DTO;

public class LoginResponse {

    public LoginResponse(){}

    private  String mensagem;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
