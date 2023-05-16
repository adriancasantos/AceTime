package com.adriancasantos.acetime.data.datasource.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.adriancasantos.acetime.data.model.Usuario;
import com.adriancasantos.acetime.feature.arbitraje.model.Arbitraje;
import com.adriancasantos.acetime.feature.jugador.model.Jugador;

import java.util.ArrayList;

public class AdminSQLiteOpenHelper implements AdminSQLiteOpenInterface {

    Context context;
    ArrayList<Usuario> listaUsuarios;
    ArrayList<Arbitraje> listaArbitrajes;
    SQLiteDatabase sqLiteDatabaseUsuarios_;
    SQLiteDatabase sqLiteDatabaseArbitrajes_;
    String bd_usuarios = "bd_usuarios";
    String tabla_usuarios = "create table if not exists usuarios(id integer primary key autoincrement, username text, password text, nombre text, apellido text, email text)";
    String bd_arbitrajes = "bd_arbitrajes";
    String tabla_arbitrajes = "create table if not exists arbitrajes(id integer primary key autoincrement, nombreJ1 TEXT, nombreJ2 TEXT, fecha TEXT, torneo TEXT, acesJ1 TEXT, acesJ2 TEXT, dobleFaltaJ1 TEXT, dobleFaltaJ2 TEXT, winnerJ1 TEXT, winnerJ2 TEXT, erroresNFJ1 TEXT, erroresNFJ2 TEXT, netJ1 TEXT, netJ2 TEXT, breakJ1 TEXT, breakJ2 TEXT)";

    public AdminSQLiteOpenHelper(Context context) {
        this.context = context;
        sqLiteDatabaseUsuarios_ = context.openOrCreateDatabase(bd_usuarios, Context.MODE_PRIVATE, null);
        sqLiteDatabaseUsuarios_.execSQL(tabla_usuarios);
        sqLiteDatabaseArbitrajes_ = context.openOrCreateDatabase(bd_arbitrajes, Context.MODE_PRIVATE, null);
        sqLiteDatabaseArbitrajes_.execSQL(tabla_arbitrajes);

    }

    public boolean insertarUsuario(Usuario usuario) {

        if (buscarUsuario(usuario.getUsername()) == 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("username", usuario.getUsername());
            contentValues.put("password", usuario.getPassword());
            contentValues.put("nombre", usuario.getNombre());
            contentValues.put("apellido", usuario.getApellido());
            contentValues.put("email", usuario.getEmail());
            return (sqLiteDatabaseUsuarios_.insert("usuarios", null, contentValues) > 0);

        } else {
            return false;
        }
    }

    public int buscarUsuario(String username) {
        int x = 0;
        listaUsuarios = selectUsuarios();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUsername().equals(username)) {
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> selectUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.clear();
        Cursor cursor = sqLiteDatabaseUsuarios_.rawQuery("select * from usuarios", null);

        if (cursor != null && cursor.moveToFirst()) {

            do {
                Usuario usuario = new Usuario();
                usuario.setId(cursor.getInt(0));
                usuario.setUsername(cursor.getString(1));
                usuario.setPassword(cursor.getString(2));
                usuario.setNombre(cursor.getString(3));
                usuario.setApellido(cursor.getString(4));
                usuario.setEmail(cursor.getString(5));
                listaUsuarios.add(usuario);

            } while (cursor.moveToNext());

        }

        return listaUsuarios;
    }

    public int login(String username, String password) {

        int x = 0;
        Cursor cursor = sqLiteDatabaseUsuarios_.rawQuery("select * from usuarios", null);
        if (cursor != null && cursor.moveToFirst()) {
            System.out.println("cursor: " + cursor);
            do {
                if (cursor.getString(1).equals(username) && cursor.getString(2).equals(password)) {
                    x++;
                }
            } while (cursor.moveToNext());
        }
        return x;
    }

    public Usuario getUsuario(String username, String password) {
        listaUsuarios = selectUsuarios();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario getUsuarioById(int id) {
        listaUsuarios = selectUsuarios();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarUsuario(int id) {
        return sqLiteDatabaseUsuarios_.delete("usuarios", "id=?", new String[]{String.valueOf(id)}) > 0;
    }

    @Override
    public boolean editarUsuario(Usuario usuario) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", usuario.getUsername());
        contentValues.put("nombre", usuario.getNombre());
        contentValues.put("apellido", usuario.getApellido());
        contentValues.put("email", usuario.getEmail());

        return sqLiteDatabaseUsuarios_.update("usuarios", contentValues, "id=?", new String[]{String.valueOf(usuario.getId())}) > 0;
    }

    @Override
    public boolean insertarArbitraje(Arbitraje arbitraje) {

        if (buscarArbitraje(arbitraje.getId()) == 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nombreJ1", arbitraje.getNombreJ1());
            contentValues.put("nombreJ2", arbitraje.getNombreJ2());
            contentValues.put("fecha", arbitraje.getFechaPartido());
            contentValues.put("torneo", arbitraje.getTorneo());
            contentValues.put("acesJ1", arbitraje.getAcesJ1());
            contentValues.put("acesJ2", arbitraje.getAcesJ2());
            contentValues.put("dobleFaltaJ1", arbitraje.getDobleFaltaJ1());
            contentValues.put("dobleFaltaJ2", arbitraje.getDobleFaltaJ2());
            contentValues.put("winnerJ1", arbitraje.getWinnerJ1());
            contentValues.put("winnerJ2", arbitraje.getWinnerJ2());
            contentValues.put("erroresNFJ1", arbitraje.getErroresNFJ1());
            contentValues.put("erroresNFJ2", arbitraje.getErroresNFJ2());
            contentValues.put("netJ1", arbitraje.getNetJ1());
            contentValues.put("netJ2", arbitraje.getNetJ2());
            contentValues.put("breakJ1", arbitraje.getBreakJ1());
            contentValues.put("breakJ2", arbitraje.getBreakJ2());
            return (sqLiteDatabaseArbitrajes_.insert("arbitrajes", null, contentValues) > 0);

        } else {
            return false;
        }
    }

    @Override
    public int buscarArbitraje(String id) {

        int x = 0;
        listaArbitrajes = selectArbitrajes();
        for (Arbitraje arbitraje : listaArbitrajes) {
            if (arbitraje.getId().equals(id)  ) {
                x++;
            }
        }
        return x;
    }

    @Override
    public ArrayList<Arbitraje> selectArbitrajes() {
        ArrayList<Arbitraje> listaArbitrajes = new ArrayList<Arbitraje>();
        listaArbitrajes.clear();
        Cursor cursor = sqLiteDatabaseArbitrajes_.rawQuery("select * from arbitrajes", null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Arbitraje arbitraje = new Arbitraje();
                arbitraje.setId(String.valueOf(cursor.getInt(0)));
                arbitraje.setNombreJ1(cursor.getString(1));
                arbitraje.setNombreJ2(cursor.getString(2));
                arbitraje.setFechaPartido(cursor.getString(3));
                arbitraje.setTorneo(cursor.getString(4));
                arbitraje.setAcesJ1(cursor.getString(5));
                arbitraje.setAcesJ2(cursor.getString(6));
                arbitraje.setDobleFaltaJ1(cursor.getString(7));
                arbitraje.setDobleFaltaJ2(cursor.getString(8));
                arbitraje.setWinnerJ1(cursor.getString(9));
                arbitraje.setWinnerJ2(cursor.getString(10));
                arbitraje.setErroresNFJ1(cursor.getString(11));
                arbitraje.setErroresNFJ2(cursor.getString(12));
                arbitraje.setNetJ1(cursor.getString(13));
                arbitraje.setNetJ2(cursor.getString(14));
                arbitraje.setBreakJ1(cursor.getString(15));
                arbitraje.setBreakJ2(cursor.getString(16));

                listaArbitrajes.add(arbitraje);
            } while (cursor.moveToNext());
        }

        return listaArbitrajes;

    }

    @Override
    public Arbitraje getArbitrajeById(String id) {
        listaArbitrajes = selectArbitrajes();
        for (Arbitraje arbitraje : listaArbitrajes) {
            if (arbitraje.getId().equals(id)) {
                return arbitraje;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarArbritraje(String id) {

        return sqLiteDatabaseArbitrajes_.delete("arbitrajes", "id=?", new String[]{String.valueOf(id)}) > 0;
    }

    @Override
    public boolean editarArbitraje(Arbitraje arbitraje) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombreJ1", arbitraje.getNombreJ1());
        contentValues.put("nombreJ2", arbitraje.getNombreJ2());
        contentValues.put("fecha", arbitraje.getFechaPartido());
        contentValues.put("torneo", arbitraje.getTorneo());
        contentValues.put("acesJ1", arbitraje.getAcesJ1());
        contentValues.put("acesJ2", arbitraje.getAcesJ2());
        contentValues.put("dobleFaltaJ1", arbitraje.getDobleFaltaJ1());
        contentValues.put("dobleFaltaJ2", arbitraje.getDobleFaltaJ2());
        contentValues.put("winnerJ1", arbitraje.getWinnerJ1());
        contentValues.put("winnerJ2", arbitraje.getWinnerJ2());
        contentValues.put("erroresNFJ1", arbitraje.getErroresNFJ1());
        contentValues.put("erroresNFJ2", arbitraje.getErroresNFJ2());
        contentValues.put("netJ1", arbitraje.getNetJ1());
        contentValues.put("netJ2", arbitraje.getNetJ2());
        contentValues.put("breakJ1", arbitraje.getBreakJ1());
        contentValues.put("breakJ2", arbitraje.getBreakJ2());
        return sqLiteDatabaseArbitrajes_.update("arbitrajes", contentValues, "id=?", new String[]{String.valueOf(arbitraje.getId())}) > 0;

    }



}