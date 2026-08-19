CREATE TABLE guest
(
    id BIGSERIAL PRIMARY KEY,

    first_name VARCHAR(100) NOT NULL,

    last_name VARCHAR(100) NOT NULL,

    attendance_status VARCHAR(30) NOT NULL,

    created_at TIMESTAMP NOT NULL
);

CREATE TABLE guest_drinks
(
    guest_id BIGINT NOT NULL,

    drink_type VARCHAR(30) NOT NULL,

    CONSTRAINT fk_guest_drinks_guest
        FOREIGN KEY (guest_id)
            REFERENCES guest(id)
            ON DELETE CASCADE
);