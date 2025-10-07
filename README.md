## Welcome to Book My Event 🌟
Book My Event is a modern web application designed to streamline event management for organizers, attendees, and staff. Built with a robust tech stack combining Spring Boot and React, it offers a seamless and secure platform for creating, purchasing, and validating tickets.

### Overview
Book My Event empowers organizers to set up and manage events, enables attendees to buy and manage tickets, and equips staff with tools to validate entries using QR codes. This intermediate-level project showcases full-stack development, focusing on secure authentication, real-time inventory management, and a comprehensive event lifecycle management system.

### Features 🎉
- **Event Creation**: Create events with customizable details such as name, date, venue, and multiple ticket types with varying prices.
- **Ticket Purchase**: Facilitate a user-friendly search and selection process with secure payment processing and real-time inventory management to prevent overselling.
- **Sales Management**: Provide an interactive dashboard for tracking sales metrics, purchaser details, and automated sales controls based on quantity and date rules.
- **Ticket Validation**: Enable instant QR code scanning at entry, prevent duplicate ticket use, and offer a manual fallback system.
- **Authentication**: Ensure secure user access with OAuth2 and OpenID Connect.
- **Real-Time Updates**: Maintain data integrity to avoid duplicate events or invalid ticket configurations.

### Prerequisites 🛠️
To set up and run the project, ensure you have the following tools installed:
- **Java**: JDK 21 or later (verify with `java -version`)
- **Node.js**: Version 20 or later (verify with `node -v`)
- **Maven**: Bundled with the Spring Boot project, no separate installation needed
- **IDE**: IntelliJ IDEA (Community Edition) recommended, or Visual Studio Code
- **Basic understanding of**: OAuth2, OpenID Connect, React, and npm

### Project Setup 🚀
1. **Clone the Repository**
   ```
   git clone https://github.com/your-username/book-my-event.git
   cd book-my-event
   ```
2. **Backend Setup**
   - Create a Spring Boot project via Spring Initializr with:
     - Language: Java 21
     - Build Tool: Maven
     - Packaging: Jar
     - Dependencies: Spring Web, Spring Security, Validation, Lombok
   - Download the generated ZIP, extract it to your workspace, and open in your IDE.
   - Configure `src/main/resources/application.properties` with:
     ```
     spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:9090/realms/book-my-event
     ```
   - Run the backend:
     ```
     mvn spring-boot:run
     ```
3. **Frontend Setup**
   - Download the React frontend source code from the project's Discord channel.
   - Extract the ZIP to a `frontend` directory in your project root.
   - Navigate to the `frontend` directory:
     ```
     cd frontend
     npm install
     npm run dev
     ```
   - Access the application at http://localhost:3000.

### Project Structure 📂
- **Backend**: Follows standard Spring Boot layout (src/main/java) with entities, repositories, services, controllers, and security configurations.
- **Frontend**: Built with React, located in the `frontend` directory, communicating with the backend via REST APIs.

### REST API Endpoints 🌐
- **Events**:
  - GET /api/events: Search events
  - POST /api/events: Create an event (auth required)
  - GET /api/events/{eventId}: Retrieve event details
  - PUT /api/events/{eventId}: Update event (auth required)
  - DELETE /api/events/{eventId}: Delete event (auth required)
- **Tickets**:
  - POST /api/events/{eventId}/tickets: Purchase ticket (auth required)
  - GET /api/events/{eventId}/tickets: List available tickets
- **Validation**:
  - POST /api/validate: Validate ticket via QR code (auth required)

