package me.ederign.casadocodigo;

class Usuario {

    private String nome;
    private int pontos;
    private boolean moderador;

    public Usuario(){

    }

    public Usuario( String nome,
                    int pontos ) {
        this.nome = nome;
        this.pontos = pontos;
        this.moderador = false;
    }

    public Usuario( String nome,
                    int pontos, boolean moderador ) {
        this.nome = nome;
        this.pontos = pontos;
        this.moderador = moderador;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public boolean isModerador() {
        return moderador;
    }

    public void tornaModerador(){
        this.moderador = true;
    }

    public void distornaModerador(){
        this.moderador = false;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", pontos=" + pontos +
                ", moderador=" + moderador +
                '}';
    }
}
