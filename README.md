# Grocery Booking API

This is a Spring Boot-based API for managing grocery items, allowing both **Admin** and **User** roles to interact with grocery items and place orders.

## Features

### Admin Features:
- **Add new grocery items** to the system.
- **View existing grocery items**.
- **Remove grocery items** from the system.
- **Update grocery item details** (e.g., name, price).
- **Manage inventory levels** of grocery items.

### User Features:
- **View available grocery items**.
- **Place an order** with multiple grocery items.

## Technologies Used

- **Spring Boot** (Version 3)
- **Spring Data JPA** for database interaction.
- **H2 Database** (for local development).
- **Docker** for containerization.
- **Gradle** for project build management.

## Prerequisites

To run this project, you'll need the following installed on your machine:

- [Java 17](https://adoptopenjdk.net/)
- [Gradle](https://gradle.org/install/)
- [Docker](https://www.docker.com/get-started)

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/grocery-booking-api.git
cd grocery-booking-api
