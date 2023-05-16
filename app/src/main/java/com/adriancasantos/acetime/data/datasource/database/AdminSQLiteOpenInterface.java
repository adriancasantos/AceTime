package com.adriancasantos.acetime.data.datasource.database;

import com.adriancasantos.acetime.data.model.Usuario;
import com.adriancasantos.acetime.feature.arbitraje.model.Arbitraje;
import com.adriancasantos.acetime.feature.jugador.model.Jugador;

import java.util.ArrayList;

public interface AdminSQLiteOpenInterface {
    boolean insertarUsuario(Usuario usuario);
    int buscarUsuario(String username);
    ArrayList<Usuario> selectUsuarios();
    int login(String username, String password);
    Usuario getUsuario(String username, String password);
    Usuario getUsuarioById(int id);
    boolean eliminarUsuario(int id);
    boolean editarUsuario(Usuario usuario);
    boolean insertarArbitraje(Arbitraje arbitraje);
    int buscarArbitraje(String id);
    ArrayList<Arbitraje> selectArbitrajes();
    Arbitraje getArbitrajeById(String id);
    boolean eliminarArbritraje(String id);
    boolean editarArbitraje(Arbitraje arbitraje);
}
