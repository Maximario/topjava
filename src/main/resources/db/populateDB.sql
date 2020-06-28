DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (user_id, date_time, description, calories) VALUES
    (100000, '2020-06-25 10:00', 'Завтрак', 1000),
    (100000, '2020-06-25 14:00', 'Обед', 2000),
    (100000, '2020-06-25 20:00', 'Ужин', 2000),
    (100000, '2020-06-26 00:00', 'Поздний ужин', 1000),
    (100001, '2020-06-26 00:00', 'Завтрак Админ', 500),
    (100001, '2020-06-26 09:00', 'Завтрак Админ', 500),
    (100001, '2020-06-26 15:00', 'Обед Админ', 500),
    (100001, '2020-06-26 20:00', 'Ужин Админ', 400);