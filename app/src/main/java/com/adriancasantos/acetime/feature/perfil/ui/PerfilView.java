package com.adriancasantos.acetime.feature.perfil.ui;

import com.adriancasantos.acetime.data.model.Usuario;

public interface PerfilView {
    void mostrarUsuario(Usuario usuario);
    void onLogout();
}
