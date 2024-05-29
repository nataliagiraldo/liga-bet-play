package com.natalia.juego;

public class Equipo {
    String nombreEquipo;
    int pj;
    int pg;
    int pp;
    int pe;
    int gf;
    int gc;
    int tp;

    public Equipo (){
        this.nombreEquipo = "";
        this.pj = 0;
        this.pg = 0;
        this.pp = 0;
        this.pe = 0;
        this.gf = 0;
        this.gc = 0;
        this.tp = 0;

    }

    public Equipo(String nombreEquipo){
        this.nombreEquipo = nombreEquipo;
        this.pj = 0;
        this.pg = 0;
        this.pp = 0;
        this.pe = 0;
        this.gf = 0;
        this.gc = 0;
        this.tp = 0;
    }

    // incrementar partidos jugados
    public void incrementarPj(){
        this.pj++;
    }

    public void sumarPuntos(int x){
        this.tp += x;
    }

    public void ganar(){
        this.pg++;
        incrementarPj();
        sumarPuntos(3);
    }

    public void perder(){
        this.pp++;
        incrementarPj();
    }

    public void empatar(){
        this.pe++;
        incrementarPj();
        sumarPuntos(1);
    }

    // get partidos jugados
    public int getPj(){
        return pj;
    }

    public void sumarGolesAfavor(int gf){
        this.gf += gf;
    }

    public void sumarGolesContra(int gc){
        this.gc += gc;
    }

    public String getNombre(){
        return nombreEquipo;
    }

    public int getGf() {
        return gf;
    }

    public int getGc() {
        return gc;
    }

    public int getTp() {
        return tp;
    }

    public int getPg() {
        return pg;
    }

    public int getPe() {
        return pe;
    }

    public int getPp() {
        return pp;
    }

}
