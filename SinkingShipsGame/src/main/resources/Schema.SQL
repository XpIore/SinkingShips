CREATE TABLE IF NOT EXISTS GAME
(
    ID            bigint auto_increment PRIMARY KEY,
    PLAYER_ONE_ID bigint,
    PLAYER_TWO_ID bigint,
    MAP           varchar
);