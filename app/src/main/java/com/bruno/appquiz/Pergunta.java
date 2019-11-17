package com.bruno.appquiz;

public class Pergunta {

 private String pergunta;
 private boolean respostacerta;
 private boolean resposta;

    public Pergunta(String pergunta, boolean respostacerta){
        this.pergunta = pergunta;
        this.respostacerta = respostacerta;

    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public boolean getRespostacerta() {
        return respostacerta;
    }

    public void setRespostacerta(boolean respostacertacerta) {
        this.respostacerta = respostacertacerta;
    }

    public boolean getResposta() {
        return resposta;
    }

    public void setResposta(boolean resposta) {
        this.resposta = resposta;
    }
}
