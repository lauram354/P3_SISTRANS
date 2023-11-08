-- RFC1
CREATE INDEX idx_consumos_fecha ON consumos(fecha);

-- RFC2
CREATE INDEX idx_servicios_tipo_servicio ON servicios(tipo_servicio);

-- RFC4
CREATE INDEX idx_consumos_fecha ON consumos(fecha);

-- RFC5
CREATE INDEX idx_reservaserv_usuarios_id ON RESERVASERV(USUARIOS_ID);

-- RFC7
CREATE INDEX idx_ureservas_reservas_idreserva ON usureservas(reservas_idreserva);
CREATE INDEX idx_ureservas_usuarios_id ON usureservas(usuarios_id);
CREATE INDEX idx_consumos_costofinal ON consumos(costofinal);

-- RFC8
CREATE INDEX idx_servicios_tipo_servicio ON servicios(tipo_servicio);

-- RFC9
CREATE INDEX idx_reservaserv_usuarios_id ON reservaserv(usuarios_id);

-- RFC10
CREATE INDEX idx_consumos_fecha ON CONSUMOS(FECHA);
CREATE INDEX idx_servicios_idservicio_tipo_servicio ON SERVICIOS(IDSERVICIO, TIPO_SERVICIO);
CREATE INDEX idx_reservaserv_usuarios_id_servicios_idservicio_consumos_idconsumo ON RESERVASERV(USUARIOS_ID, SERVICIOS_IDSERVICIO, CONSUMOS_IDCONSUMO);
CREATE INDEX idx_usuarios_id_tipoid ON USUARIOS(ID, TIPOID);
