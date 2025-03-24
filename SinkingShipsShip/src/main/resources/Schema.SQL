CREATE TABLE SHIP
(
    ID                bigint auto_increment PRIMARY KEY,
    PLAYER_ID         bigint  NOT NULL,
    GAME_ID           bigint  NOT NULL,
    SHIP_X_COORDINATE int     NOT NULL,
    SHIP_Y_COORDINATE int     NOT NULL,
    HIT               boolean NOT NULL
);