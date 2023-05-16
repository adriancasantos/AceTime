package com.adriancasantos.acetime.feature.arbitraje.model;

import com.adriancasantos.acetime.data.model.Usuario;

import java.io.Serializable;

public class Arbitraje implements Serializable
{
    private String id;
    private String acesJ1;
    private String acesJ2;
    private String dobleFaltaJ1;
    private String dobleFaltaJ2;
    private String winnerJ1;
    private String winnerJ2;
    private String erroresNFJ1;
    private String erroresNFJ2;
    private String netJ1;
    private String netJ2;
    private String breakJ1;
    private String breakJ2;
    private String nombreJ1;
    private String nombreJ2;
    private String fechaPartido;
    private String torneo;


    public Arbitraje(String id, String acesJ1, String acesJ2, String dobleFaltaJ1, String dobleFaltaJ2, String winnerJ1, String winnerJ2, String erroresNFJ1, String erroresNFJ2, String netJ1, String netJ2, String breakJ1, String breakJ2, String nombreJ1, String nombreJ2, String fechaPartido, String torneo) {
        this.id = id;
        this.acesJ1 = acesJ1;
        this.acesJ2 = acesJ2;
        this.dobleFaltaJ1 = dobleFaltaJ1;
        this.dobleFaltaJ2 = dobleFaltaJ2;
        this.winnerJ1 = winnerJ1;
        this.winnerJ2 = winnerJ2;
        this.erroresNFJ1 = erroresNFJ1;
        this.erroresNFJ2 = erroresNFJ2;
        this.netJ1 = netJ1;
        this.netJ2 = netJ2;
        this.breakJ1 = breakJ1;
        this.breakJ2 = breakJ2;
        this.nombreJ1 = nombreJ1;
        this.nombreJ2 = nombreJ2;
        this.fechaPartido = fechaPartido;
        this.torneo = torneo;

    }


    public Arbitraje (){}



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcesJ1() {
        return acesJ1;
    }

    public void setAcesJ1(String acesJ1) {
        this.acesJ1 = acesJ1;
    }

    public String getAcesJ2() {
        return acesJ2;
    }

    public void setAcesJ2(String acesJ2) {
        this.acesJ2 = acesJ2;
    }

    public String getDobleFaltaJ1() {
        return dobleFaltaJ1;
    }

    public void setDobleFaltaJ1(String dobleFaltaJ1) {
        this.dobleFaltaJ1 = dobleFaltaJ1;
    }

    public String getDobleFaltaJ2() {
        return dobleFaltaJ2;
    }

    public void setDobleFaltaJ2(String dobleFaltaJ2) {
        this.dobleFaltaJ2 = dobleFaltaJ2;
    }

    public String getWinnerJ1() {
        return winnerJ1;
    }

    public void setWinnerJ1(String winnerJ1) {
        this.winnerJ1 = winnerJ1;
    }

    public String getWinnerJ2() {
        return winnerJ2;
    }

    public void setWinnerJ2(String winnerJ2) {
        this.winnerJ2 = winnerJ2;
    }

    public String getErroresNFJ1() {
        return erroresNFJ1;
    }

    public void setErroresNFJ1(String erroresNFJ1) {
        this.erroresNFJ1 = erroresNFJ1;
    }

    public String getErroresNFJ2() {
        return erroresNFJ2;
    }

    public void setErroresNFJ2(String erroresNFJ2) {
        this.erroresNFJ2 = erroresNFJ2;
    }

    public String getNetJ1() {
        return netJ1;
    }

    public void setNetJ1(String netJ1) {
        this.netJ1 = netJ1;
    }

    public String getNetJ2() {
        return netJ2;
    }

    public void setNetJ2(String netJ2) {
        this.netJ2 = netJ2;
    }

    public String getBreakJ1() {
        return breakJ1;
    }

    public void setBreakJ1(String breakJ1) {
        this.breakJ1 = breakJ1;
    }

    public String getBreakJ2() {
        return breakJ2;
    }

    public void setBreakJ2(String breakJ2) {
        this.breakJ2 = breakJ2;
    }

    public String getNombreJ1() {
        return nombreJ1;
    }

    public void setNombreJ1(String nombreJ1) {
        this.nombreJ1 = nombreJ1;
    }

    public String getNombreJ2() {
        return nombreJ2;
    }

    public void setNombreJ2(String nombreJ2) {
        this.nombreJ2 = nombreJ2;
    }

    public String getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(String fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public String getTorneo() {
        return torneo;
    }

    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }
}