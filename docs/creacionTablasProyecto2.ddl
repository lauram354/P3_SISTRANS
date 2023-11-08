-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2023-11-07 23:28:08 COT
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE bar (
    idservicio INTEGER NOT NULL,
    capacidad  INTEGER,
    estilo     VARCHAR2(200),
    nombre     VARCHAR2(200)
);

ALTER TABLE bar ADD CONSTRAINT bar_pk PRIMARY KEY ( idservicio );

CREATE TABLE consumos (
    idconsumo           INTEGER NOT NULL,
    pagado              NUMBER NOT NULL,
    costofinal          FLOAT NOT NULL,
    cuentas_idcuenta    INTEGER NOT NULL,
    fecha               DATE NOT NULL,
    habis_id_habitacion INTEGER NOT NULL
);

CREATE UNIQUE INDEX consumos__idx ON
    consumos (
        habis_id_habitacion
    ASC );

ALTER TABLE consumos ADD CONSTRAINT consumos_pk PRIMARY KEY ( idconsumo );

CREATE TABLE cuentas (
    idcuenta INTEGER NOT NULL,
    valor    FLOAT NOT NULL
);

ALTER TABLE cuentas ADD CONSTRAINT cuentas_pk PRIMARY KEY ( idcuenta );

CREATE TABLE gym (
    idservicio INTEGER NOT NULL,
    capacidad  INTEGER
);

ALTER TABLE gym ADD CONSTRAINT gym_pk PRIMARY KEY ( idservicio );

CREATE TABLE habis (
    id_habitacion        INTEGER NOT NULL,
    tv                   NUMBER NOT NULL,
    cafetera             NUMBER NOT NULL,
    minibar              NUMBER NOT NULL,
    tiposhabi_idtipohabi INTEGER NOT NULL
);

ALTER TABLE habis ADD CONSTRAINT habis_pk PRIMARY KEY ( id_habitacion );

CREATE TABLE horarios (
    idhorario          INTEGER NOT NULL,
    dias               VARCHAR2(200) NOT NULL,
    horainicial        VARCHAR2(200) NOT NULL,
    horafinal          VARCHAR2(200) NOT NULL,
    piscina_idservicio INTEGER NOT NULL,
    gym_idservicio     INTEGER NOT NULL,
    spa_idservicio     INTEGER NOT NULL,
    ocupado            NUMBER NOT NULL,
    salones_idservicio INTEGER NOT NULL
);

ALTER TABLE horarios ADD CONSTRAINT horarios_pk PRIMARY KEY ( idhorario );

CREATE TABLE hoteles (
    nombre VARCHAR2(200) NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( nombre );

CREATE TABLE internet (
    idservicio INTEGER NOT NULL,
    capacidad  INTEGER NOT NULL
);

ALTER TABLE internet ADD CONSTRAINT internet_pk PRIMARY KEY ( idservicio );

CREATE TABLE lavanderia (
    idservicio INTEGER NOT NULL,
    tipoprenda VARCHAR2(200)
);

ALTER TABLE lavanderia ADD CONSTRAINT lavanderia_pk PRIMARY KEY ( idservicio );

CREATE TABLE menu (
    idproducto INTEGER NOT NULL,
    producto   VARCHAR2(200) NOT NULL,
    precio     FLOAT NOT NULL
);

ALTER TABLE menu ADD CONSTRAINT menu_pk PRIMARY KEY ( idproducto );

CREATE TABLE menubar (
    bar_idservicio  INTEGER NOT NULL,
    menu_idproducto INTEGER NOT NULL
);

ALTER TABLE menubar ADD CONSTRAINT menubar_pk PRIMARY KEY ( bar_idservicio,
                                                            menu_idproducto );

CREATE TABLE menuresto (
    resto_idservicio INTEGER NOT NULL,
    menu_idproducto  INTEGER NOT NULL
);

ALTER TABLE menuresto ADD CONSTRAINT menuresto_pk PRIMARY KEY ( resto_idservicio,
                                                                menu_idproducto );

CREATE TABLE piscina (
    idservicio  INTEGER NOT NULL,
    capacidad   INTEGER,
    profundidad FLOAT
);

ALTER TABLE piscina ADD CONSTRAINT piscina_pk PRIMARY KEY ( idservicio );

CREATE TABLE planes (
    idtipoplan     INTEGER NOT NULL,
    tipo_plan      VARCHAR2(200) NOT NULL,
    descuento      FLOAT NOT NULL,
    hoteles_nombre VARCHAR2(200) NOT NULL
);

ALTER TABLE planes ADD CONSTRAINT planes_pk PRIMARY KEY ( idtipoplan );

CREATE TABLE productos (
    idproducto     INTEGER NOT NULL,
    costo          FLOAT NOT NULL,
    nombreproducto VARCHAR2(200) NOT NULL
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( idproducto );

CREATE TABLE productsuper (
    super_idservicio     INTEGER NOT NULL,
    productos_idproducto INTEGER NOT NULL
);

ALTER TABLE productsuper ADD CONSTRAINT productsuper_pk PRIMARY KEY ( super_idservicio,
                                                                      productos_idproducto );

CREATE TABLE producttienda (
    tiendas_idservicio   INTEGER NOT NULL,
    productos_idproducto INTEGER NOT NULL
);

ALTER TABLE producttienda ADD CONSTRAINT producttienda_pk PRIMARY KEY ( tiendas_idservicio,
                                                                        productos_idproducto );

CREATE TABLE reservas (
    idreserva           INTEGER NOT NULL,
    fecha_entrada       DATE NOT NULL,
    fecha_salida        DATE NOT NULL,
    cant_personas       INTEGER NOT NULL,
    habis_id_habitacion INTEGER NOT NULL,
    cuentas_idcuenta    INTEGER NOT NULL,
    planes_idtipoplan   INTEGER NOT NULL,
    hoteles_nombre      VARCHAR2(200) NOT NULL
);

CREATE UNIQUE INDEX reservas__idx ON
    reservas (
        cuentas_idcuenta
    ASC );

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( idreserva );

CREATE TABLE reservaserv (
    idreserva            INTEGER NOT NULL,
    usuarios_id          VARCHAR2(200) NOT NULL,
    consumos_idconsumo   INTEGER NOT NULL,
    servicios_idservicio INTEGER NOT NULL
);

CREATE UNIQUE INDEX reservaserv__idx ON
    reservaserv (
        consumos_idconsumo
    ASC );

CREATE UNIQUE INDEX reservaserv__idxv1 ON
    reservaserv (
        servicios_idservicio
    ASC );

ALTER TABLE reservaserv ADD CONSTRAINT reservaserv_pk PRIMARY KEY ( idreserva );

CREATE TABLE resto (
    idservicio INTEGER NOT NULL,
    capacidad  INTEGER,
    estilo     VARCHAR2(200),
    nombre     VARCHAR2(200)
);

ALTER TABLE resto ADD CONSTRAINT resto_pk PRIMARY KEY ( idservicio );

CREATE TABLE salones (
    idservicio       INTEGER NOT NULL,
    horas            FLOAT,
    tipo             VARCHAR2(200),
    horarioadicional FLOAT
);

ALTER TABLE salones
    ADD CHECK ( tipo IN ( 'CONFERENCIA', 'REUNION' ) );

ALTER TABLE salones ADD CONSTRAINT salones_pk PRIMARY KEY ( idservicio );

CREATE TABLE servicios (
    idservicio     INTEGER NOT NULL,
    descripcion    VARCHAR2(200),
    costo          FLOAT,
    tipo_servicio  VARCHAR2(200),
    hoteles_nombre VARCHAR2(200) NOT NULL,
    servicios_type VARCHAR2(10) NOT NULL
);

ALTER TABLE servicios
    ADD CONSTRAINT ch_inh_servicios CHECK ( servicios_type IN ( 'Bar', 'Gym', 'Internet', 'Lavanderia', 'Piscina',
                                                                'Resto', 'SPA', 'Salones', 'Servicios', 'Super',
                                                                'Tiendas', 'Utensilios' ) );

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( idservicio );

CREATE TABLE spa (
    idservicio INTEGER NOT NULL,
    duracion   FLOAT
);

ALTER TABLE spa ADD CONSTRAINT spa_pk PRIMARY KEY ( idservicio );

CREATE TABLE super (
    idservicio INTEGER NOT NULL,
    estilo     VARCHAR2(200)
);

ALTER TABLE super ADD CONSTRAINT super_pk PRIMARY KEY ( idservicio );

CREATE TABLE tiendas (
    idservicio INTEGER NOT NULL,
    nombre     VARCHAR2(200)
);

ALTER TABLE tiendas ADD CONSTRAINT tiendas_pk PRIMARY KEY ( idservicio );

CREATE TABLE tiposhabi (
    idtipohabi        INTEGER NOT NULL,
    tipo              VARCHAR2(200) NOT NULL,
    hoteles_nombre    VARCHAR2(200) NOT NULL,
    costo_alojamiento FLOAT NOT NULL,
    capacidad         INTEGER NOT NULL
);

ALTER TABLE tiposhabi ADD CONSTRAINT tiposhabi_pk PRIMARY KEY ( idtipohabi );

CREATE TABLE tiposusu (
    idtipo INTEGER NOT NULL,
    tipo   VARCHAR2(200) NOT NULL
);

ALTER TABLE tiposusu ADD CONSTRAINT tiposusu_pk PRIMARY KEY ( idtipo );

CREATE TABLE usuarios (
    id              VARCHAR2(200) NOT NULL,
    tipoid          VARCHAR2(200) NOT NULL,
    nombre          VARCHAR2(200) NOT NULL,
    email           VARCHAR2(200) NOT NULL,
    tiposusu_idtipo INTEGER NOT NULL,
    contrasenia     VARCHAR2(200) NOT NULL,
    login           VARCHAR2(200) NOT NULL
);

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( id );

CREATE TABLE usuhotel (
    usuarios_id    VARCHAR2(200) NOT NULL,
    hoteles_nombre VARCHAR2(200) NOT NULL
);

ALTER TABLE usuhotel ADD CONSTRAINT usuhotel_pk PRIMARY KEY ( usuarios_id,
                                                              hoteles_nombre );

CREATE TABLE usureservas (
    usuarios_id        VARCHAR2(200) NOT NULL,
    reservas_idreserva INTEGER NOT NULL,
    checkin            NUMBER,
    checkout           NUMBER
);

ALTER TABLE usureservas ADD CONSTRAINT usureservas_pk PRIMARY KEY ( usuarios_id,
                                                                    reservas_idreserva );

CREATE TABLE utensilios (
    idservicio INTEGER NOT NULL,
    tipo       VARCHAR2(200),
    costodanio FLOAT
);

ALTER TABLE utensilios ADD CONSTRAINT utensilios_pk PRIMARY KEY ( idservicio );

ALTER TABLE bar
    ADD CONSTRAINT bar_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_cuentas_fk FOREIGN KEY ( cuentas_idcuenta )
        REFERENCES cuentas ( idcuenta );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_habis_fk FOREIGN KEY ( habis_id_habitacion )
        REFERENCES habis ( id_habitacion );

ALTER TABLE gym
    ADD CONSTRAINT gym_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE habis
    ADD CONSTRAINT habis_tiposhabi_fk FOREIGN KEY ( tiposhabi_idtipohabi )
        REFERENCES tiposhabi ( idtipohabi );

ALTER TABLE horarios
    ADD CONSTRAINT horarios_gym_fk FOREIGN KEY ( gym_idservicio )
        REFERENCES gym ( idservicio );

ALTER TABLE horarios
    ADD CONSTRAINT horarios_piscina_fk FOREIGN KEY ( piscina_idservicio )
        REFERENCES piscina ( idservicio );

ALTER TABLE horarios
    ADD CONSTRAINT horarios_salones_fk FOREIGN KEY ( salones_idservicio )
        REFERENCES salones ( idservicio );

ALTER TABLE horarios
    ADD CONSTRAINT horarios_spa_fk FOREIGN KEY ( spa_idservicio )
        REFERENCES spa ( idservicio );

ALTER TABLE internet
    ADD CONSTRAINT internet_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE lavanderia
    ADD CONSTRAINT lavanderia_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE menubar
    ADD CONSTRAINT menubar_bar_fk FOREIGN KEY ( bar_idservicio )
        REFERENCES bar ( idservicio );

ALTER TABLE menubar
    ADD CONSTRAINT menubar_menu_fk FOREIGN KEY ( menu_idproducto )
        REFERENCES menu ( idproducto );

ALTER TABLE menuresto
    ADD CONSTRAINT menuresto_menu_fk FOREIGN KEY ( menu_idproducto )
        REFERENCES menu ( idproducto );

ALTER TABLE menuresto
    ADD CONSTRAINT menuresto_resto_fk FOREIGN KEY ( resto_idservicio )
        REFERENCES resto ( idservicio );

ALTER TABLE piscina
    ADD CONSTRAINT piscina_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE planes
    ADD CONSTRAINT planes_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE productsuper
    ADD CONSTRAINT productsuper_productos_fk FOREIGN KEY ( productos_idproducto )
        REFERENCES productos ( idproducto );

ALTER TABLE productsuper
    ADD CONSTRAINT productsuper_super_fk FOREIGN KEY ( super_idservicio )
        REFERENCES super ( idservicio );

ALTER TABLE producttienda
    ADD CONSTRAINT producttienda_productos_fk FOREIGN KEY ( productos_idproducto )
        REFERENCES productos ( idproducto );

ALTER TABLE producttienda
    ADD CONSTRAINT producttienda_tiendas_fk FOREIGN KEY ( tiendas_idservicio )
        REFERENCES tiendas ( idservicio );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_cuentas_fk FOREIGN KEY ( cuentas_idcuenta )
        REFERENCES cuentas ( idcuenta );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_habis_fk FOREIGN KEY ( habis_id_habitacion )
        REFERENCES habis ( id_habitacion );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_planes_fk FOREIGN KEY ( planes_idtipoplan )
        REFERENCES planes ( idtipoplan );

ALTER TABLE reservaserv
    ADD CONSTRAINT reservaserv_consumos_fk FOREIGN KEY ( consumos_idconsumo )
        REFERENCES consumos ( idconsumo );

ALTER TABLE reservaserv
    ADD CONSTRAINT reservaserv_servicios_fk FOREIGN KEY ( servicios_idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE reservaserv
    ADD CONSTRAINT reservaserv_usuarios_fk FOREIGN KEY ( usuarios_id )
        REFERENCES usuarios ( id );

ALTER TABLE resto
    ADD CONSTRAINT resto_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE salones
    ADD CONSTRAINT salones_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE spa
    ADD CONSTRAINT spa_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE super
    ADD CONSTRAINT super_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE tiendas
    ADD CONSTRAINT tiendas_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE tiposhabi
    ADD CONSTRAINT tiposhabi_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_tiposusu_fk FOREIGN KEY ( tiposusu_idtipo )
        REFERENCES tiposusu ( idtipo );

ALTER TABLE usuhotel
    ADD CONSTRAINT usuhotel_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE usuhotel
    ADD CONSTRAINT usuhotel_usuarios_fk FOREIGN KEY ( usuarios_id )
        REFERENCES usuarios ( id );

ALTER TABLE usureservas
    ADD CONSTRAINT usureservas_reservas_fk FOREIGN KEY ( reservas_idreserva )
        REFERENCES reservas ( idreserva );

ALTER TABLE usureservas
    ADD CONSTRAINT usureservas_usuarios_fk FOREIGN KEY ( usuarios_id )
        REFERENCES usuarios ( id );

ALTER TABLE utensilios
    ADD CONSTRAINT utensilios_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

CREATE OR REPLACE TRIGGER arc_fkarc_2_super BEFORE
    INSERT OR UPDATE OF idservicio ON super
    FOR EACH ROW
DECLARE
    d VARCHAR2(10);
BEGIN
    SELECT
        a.servicios_type
    INTO d
    FROM
        servicios a
    WHERE
        a.idservicio = :new.idservicio;

    IF ( d IS NULL OR d <> 'Super' ) THEN
        raise_application_error(-20223, 'FK Super_Servicios_FK in Table Super violates Arc constraint on Table Servicios - discriminator column Servicios_TYPE doesn''t have value ''Super'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_2_tiendas BEFORE
    INSERT OR UPDATE OF idservicio ON tiendas
    FOR EACH ROW
DECLARE
    d VARCHAR2(10);
BEGIN
    SELECT
        a.servicios_type
    INTO d
    FROM
        servicios a
    WHERE
        a.idservicio = :new.idservicio;

    IF ( d IS NULL OR d <> 'Tiendas' ) THEN
        raise_application_error(-20223, 'FK Tiendas_Servicios_FK in Table Tiendas violates Arc constraint on Table Servicios - discriminator column Servicios_TYPE doesn''t have value ''Tiendas'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_2_lavanderia BEFORE
    INSERT OR UPDATE OF idservicio ON lavanderia
    FOR EACH ROW
DECLARE
    d VARCHAR2(10);
BEGIN
    SELECT
        a.servicios_type
    INTO d
    FROM
        servicios a
    WHERE
        a.idservicio = :new.idservicio;

    IF ( d IS NULL OR d <> 'Lavanderia' ) THEN
        raise_application_error(-20223, 'FK Lavanderia_Servicios_FK in Table Lavanderia violates Arc constraint on Table Servicios - discriminator column Servicios_TYPE doesn''t have value ''Lavanderia'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_2_internet BEFORE
    INSERT OR UPDATE OF idservicio ON internet
    FOR EACH ROW
DECLARE
    d VARCHAR2(10);
BEGIN
    SELECT
        a.servicios_type
    INTO d
    FROM
        servicios a
    WHERE
        a.idservicio = :new.idservicio;

    IF ( d IS NULL OR d <> 'Internet' ) THEN
        raise_application_error(-20223, 'FK Internet_Servicios_FK in Table Internet violates Arc constraint on Table Servicios - discriminator column Servicios_TYPE doesn''t have value ''Internet'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_2_spa BEFORE
    INSERT OR UPDATE OF idservicio ON spa
    FOR EACH ROW
DECLARE
    d VARCHAR2(10);
BEGIN
    SELECT
        a.servicios_type
    INTO d
    FROM
        servicios a
    WHERE
        a.idservicio = :new.idservicio;

    IF ( d IS NULL OR d <> 'SPA' ) THEN
        raise_application_error(-20223, 'FK SPA_Servicios_FK in Table SPA violates Arc constraint on Table Servicios - discriminator column Servicios_TYPE doesn''t have value ''SPA'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_2_salones BEFORE
    INSERT OR UPDATE OF idservicio ON salones
    FOR EACH ROW
DECLARE
    d VARCHAR2(10);
BEGIN
    SELECT
        a.servicios_type
    INTO d
    FROM
        servicios a
    WHERE
        a.idservicio = :new.idservicio;

    IF ( d IS NULL OR d <> 'Salones' ) THEN
        raise_application_error(-20223, 'FK Salones_Servicios_FK in Table Salones violates Arc constraint on Table Servicios - discriminator column Servicios_TYPE doesn''t have value ''Salones'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_2_piscina BEFORE
    INSERT OR UPDATE OF idservicio ON piscina
    FOR EACH ROW
DECLARE
    d VARCHAR2(10);
BEGIN
    SELECT
        a.servicios_type
    INTO d
    FROM
        servicios a
    WHERE
        a.idservicio = :new.idservicio;

    IF ( d IS NULL OR d <> 'Piscina' ) THEN
        raise_application_error(-20223, 'FK Piscina_Servicios_FK in Table Piscina violates Arc constraint on Table Servicios - discriminator column Servicios_TYPE doesn''t have value ''Piscina'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_2_resto BEFORE
    INSERT OR UPDATE OF idservicio ON resto
    FOR EACH ROW
DECLARE
    d VARCHAR2(10);
BEGIN
    SELECT
        a.servicios_type
    INTO d
    FROM
        servicios a
    WHERE
        a.idservicio = :new.idservicio;

    IF ( d IS NULL OR d <> 'Resto' ) THEN
        raise_application_error(-20223, 'FK Resto_Servicios_FK in Table Resto violates Arc constraint on Table Servicios - discriminator column Servicios_TYPE doesn''t have value ''Resto'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_2_gym BEFORE
    INSERT OR UPDATE OF idservicio ON gym
    FOR EACH ROW
DECLARE
    d VARCHAR2(10);
BEGIN
    SELECT
        a.servicios_type
    INTO d
    FROM
        servicios a
    WHERE
        a.idservicio = :new.idservicio;

    IF ( d IS NULL OR d <> 'Gym' ) THEN
        raise_application_error(-20223, 'FK Gym_Servicios_FK in Table Gym violates Arc constraint on Table Servicios - discriminator column Servicios_TYPE doesn''t have value ''Gym'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_2_bar BEFORE
    INSERT OR UPDATE OF idservicio ON bar
    FOR EACH ROW
DECLARE
    d VARCHAR2(10);
BEGIN
    SELECT
        a.servicios_type
    INTO d
    FROM
        servicios a
    WHERE
        a.idservicio = :new.idservicio;

    IF ( d IS NULL OR d <> 'Bar' ) THEN
        raise_application_error(-20223, 'FK Bar_Servicios_FK in Table Bar violates Arc constraint on Table Servicios - discriminator column Servicios_TYPE doesn''t have value ''Bar'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_2_utensilios BEFORE
    INSERT OR UPDATE OF idservicio ON utensilios
    FOR EACH ROW
DECLARE
    d VARCHAR2(10);
BEGIN
    SELECT
        a.servicios_type
    INTO d
    FROM
        servicios a
    WHERE
        a.idservicio = :new.idservicio;

    IF ( d IS NULL OR d <> 'Utensilios' ) THEN
        raise_application_error(-20223, 'FK Utensilios_Servicios_FK in Table Utensilios violates Arc constraint on Table Servicios - discriminator column Servicios_TYPE doesn''t have value ''Utensilios'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE SEQUENCE consumos_idconsumo_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER consumos_idconsumo_trg BEFORE
    INSERT ON consumos
    FOR EACH ROW
    WHEN ( new.idconsumo IS NULL )
BEGIN
    :new.idconsumo := consumos_idconsumo_seq.nextval;
END;
/

CREATE SEQUENCE cuentas_idcuenta_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER cuentas_idcuenta_trg BEFORE
    INSERT ON cuentas
    FOR EACH ROW
    WHEN ( new.idcuenta IS NULL )
BEGIN
    :new.idcuenta := cuentas_idcuenta_seq.nextval;
END;
/

CREATE SEQUENCE habis_id_habitacion_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER habis_id_habitacion_trg BEFORE
    INSERT ON habis
    FOR EACH ROW
    WHEN ( new.id_habitacion IS NULL )
BEGIN
    :new.id_habitacion := habis_id_habitacion_seq.nextval;
END;
/

CREATE SEQUENCE horarios_idhorario_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER horarios_idhorario_trg BEFORE
    INSERT ON horarios
    FOR EACH ROW
    WHEN ( new.idhorario IS NULL )
BEGIN
    :new.idhorario := horarios_idhorario_seq.nextval;
END;
/

CREATE SEQUENCE menu_idproducto_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER menu_idproducto_trg BEFORE
    INSERT ON menu
    FOR EACH ROW
    WHEN ( new.idproducto IS NULL )
BEGIN
    :new.idproducto := menu_idproducto_seq.nextval;
END;
/

CREATE SEQUENCE planes_idtipoplan_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER planes_idtipoplan_trg BEFORE
    INSERT ON planes
    FOR EACH ROW
    WHEN ( new.idtipoplan IS NULL )
BEGIN
    :new.idtipoplan := planes_idtipoplan_seq.nextval;
END;
/

CREATE SEQUENCE productos_idproducto_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER productos_idproducto_trg BEFORE
    INSERT ON productos
    FOR EACH ROW
    WHEN ( new.idproducto IS NULL )
BEGIN
    :new.idproducto := productos_idproducto_seq.nextval;
END;
/

CREATE SEQUENCE reservas_idreserva_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER reservas_idreserva_trg BEFORE
    INSERT ON reservas
    FOR EACH ROW
    WHEN ( new.idreserva IS NULL )
BEGIN
    :new.idreserva := reservas_idreserva_seq.nextval;
END;
/

CREATE SEQUENCE reservaserv_idreserva_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER reservaserv_idreserva_trg BEFORE
    INSERT ON reservaserv
    FOR EACH ROW
    WHEN ( new.idreserva IS NULL )
BEGIN
    :new.idreserva := reservaserv_idreserva_seq.nextval;
END;
/

CREATE SEQUENCE servicios_idservicio_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER servicios_idservicio_trg BEFORE
    INSERT ON servicios
    FOR EACH ROW
    WHEN ( new.idservicio IS NULL )
BEGIN
    :new.idservicio := servicios_idservicio_seq.nextval;
END;
/

CREATE SEQUENCE tiposhabi_idtipohabi_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER tiposhabi_idtipohabi_trg BEFORE
    INSERT ON tiposhabi
    FOR EACH ROW
    WHEN ( new.idtipohabi IS NULL )
BEGIN
    :new.idtipohabi := tiposhabi_idtipohabi_seq.nextval;
END;
/

CREATE SEQUENCE tiposusu_idtipo_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER tiposusu_idtipo_trg BEFORE
    INSERT ON tiposusu
    FOR EACH ROW
    WHEN ( new.idtipo IS NULL )
BEGIN
    :new.idtipo := tiposusu_idtipo_seq.nextval;
END;
/



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            31
-- CREATE INDEX                             4
-- ALTER TABLE                             74
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                          23
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                         12
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
