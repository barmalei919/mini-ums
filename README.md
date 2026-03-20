# Mini UMS — Универсальная Система Сообщений

REST API сервис для отправки сообщений по различным каналам.
Создан как учебный проект, вдохновлённый архитектурой реальных UMS систем.

## Стек технологий

- Java 17
- Spring Boot 3.5
- Spring Data JPA + Hibernate
- PostgreSQL 16
- Docker & Docker Compose
- Lombok
- Maven

## Архитектура

Проект построен по слоистой архитектуре:

- **Controller** — REST эндпоинты
- **Service** — бизнес-логика
- **Repository** — доступ к БД через Spring Data JPA
- **Entity** — JPA сущности, маппированные на таблицы PostgreSQL

## Сущности

- `User` — пользователь системы
- `Channel` — канал отправки (SMS, EMAIL, PUSH)
- `Message` — сообщение, привязанное к пользователю и каналу (связь ManyToOne)

## Запуск

### Требования
- Java 17+
- Docker Desktop

### Старт
```bash
docker-compose up -d
./mvnw spring-boot:run
```

## API

### Пользователи
| Метод | URL | Описание |
|-------|-----|----------|
| POST | /api/users | Создать пользователя |
| GET | /api/users | Получить всех |
| GET | /api/users/{id} | Получить по id |
| DELETE | /api/users/{id} | Удалить |

### Каналы
| Метод | URL | Описание |
|-------|-----|----------|
| POST | /api/channels | Создать канал |
| GET | /api/channels | Получить все |
| GET | /api/channels/{id} | Получить по id |
| GET | /api/channels/type/{type} | Получить по типу (SMS/EMAIL/PUSH) |

### Сообщения
| Метод | URL | Описание |
|-------|-----|----------|
| POST | /api/messages/send | Отправить сообщение |
| GET | /api/messages | Получить все |
| GET | /api/messages/user/{userId} | Сообщения пользователя |
| PATCH | /api/messages/{id}/status | Обновить статус |