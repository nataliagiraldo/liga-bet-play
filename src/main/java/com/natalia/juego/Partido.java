package com.natalia.juego;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private int golesLocal;
    private int golesVisitante;

    public Partido(Equipo local, Equipo visitante, int golesLocal, int golesVisitante) {
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;

        actualizarEstadisticas();
    }

    private void actualizarEstadisticas() {
        local.sumarGolesAfavor(golesLocal);
        local.sumarGolesContra(golesVisitante);
        visitante.sumarGolesAfavor(golesVisitante);
        visitante.sumarGolesContra(golesLocal);

        if (golesLocal == golesVisitante) {
            local.empatar();
            visitante.empatar();
        } else if (golesLocal > golesVisitante) {
            local.ganar();
            visitante.perder();
        } else {
            local.perder();
            visitante.ganar();
        }
    }
}
