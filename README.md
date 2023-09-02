# Product-Review-Management-Application-with-Angular-SpringBoot

This repository contains the source code for a Product Community Website, consisting of two applications: a frontend built with Angular and a backend built with Spring Boot. The website allows users to register, log in, browse products, post reviews, request reviews, and view statistics.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

### Backend (Spring Boot)

- **User Authentication API**: Support successful/unsuccessful user authentication validation.
- **User Registration API**: Register new users.
- **Search Product API**: Search products by name, brand, and product code.
- **Post Reviews API**: Post new reviews.
- [BONUS] **Approve Review API**: Approve a review.
- **Request Review API**: Request a review for a product.
- **Stats API**: Get homepage statistics.

### Frontend (Angular)

- User-friendly, responsive design.
- Homepage with registration and login links.
- User authentication and registration pages.
- Product search and filtering functionality.
- Search results with product details, reviews, and ratings.
- Product review submission and approval (admin only).
- Requesting reviews for products.
- Displaying statistics on the homepage.

## Technologies Used

### Backend

- **Java**: Core programming language.
- **Spring Boot**: Backend framework for creating RESTful APIs.
- **Spring Security**: For user authentication and authorization.
- **Spring Data JPA**: For database interactions.
- **Database**: Choose a database system (e.g., PostgreSQL, MySQL).
- **Maven**: Build and dependency management.

### Frontend

- **Angular 11**: Frontend framework.
- **Angular CLI**: For project setup and development.
- **Angular Material**: UI component library (optional).
- **RxJS**: Reactive programming for handling asynchronous operations.
- **SASS/LESS**: Stylesheet preprocessor (optional).
- **Node.js/NPM**: Package manager and runtime environment.

## Getting Started

To run this project locally, follow these steps:

1. **Clone the repository**:

   ```shell
   git clone https://github.com/your-username/product-community-website.git
   cd product-community-website

2. **Backend (Spring Boot)**:

- **Open the backend project in your preferred Java IDE.**
- **Configure your database settings in application.properties.**
- **Run the Spring Boot application.**
- **The backend will be accessible at http://localhost:8080.**
  
3. **Frontend (Angular)**:

      3.1 Navigate to the frontend directory:
    cd frontend 
    
    3.2 Install dependencies:
    `npm install`
  
    3.3 Start the Angular development server:
   `ng serve`
   
    3.4 The frontend will be accessible at http://localhost:3000.

## Project Structure
The project is organized as follows:

- **backend/**: Spring Boot backend application.
- **frontend/**: Angular frontend application.

## Usage
- Access the frontend application at http://localhost:3000 and interact with the website.
- Use the backend API endpoints as documented in the API documentation.

## Contributing
Contributions are welcome! Feel free to open issues and pull requests.

## License
This project is licensed under the MIT License.
