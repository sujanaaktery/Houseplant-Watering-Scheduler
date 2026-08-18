🌱 Houseplant Watering Scheduler

📌 Project Overview

Houseplant Watering Scheduler (PlantCare) is a Java Swing desktop application designed to help users manage and track their houseplants' watering schedules. It allows users to add, search, remove, and water plants while automatically calculating their next watering date and current watering status.

✨ Features

- Add new plants
- Remove plants
- Search plants by name
- Water plants
- Check watering reminders
- Track plant status
- View plant statistics
- Save plant data using file serialization

🛠️ Technologies Used

- Java
- Java Swing
- Java Serialization
- Java Collections
- NetBeans IDE

🧩 OOP Concepts

- Abstraction
- Inheritance
- Polymorphism
- Encapsulation
- Interface
- Singleton Design Pattern

📂 Project Structure

Houseplant-Watering-Scheduler/
│
├── src/
│   ├── interfaces/
│   │   └── Alertable.java
│   │
│   ├── plants/
│   │   ├── Plant.java
│   │   ├── Fern.java
│   │   └── Succulent.java
│   │
│   ├── manager/
│   │   └── PlantManager.java
│   │
│   └── gui/
│       ├── WelcomeFrame.java
│       ├── MainFrame.java
│       ├── AddPlantFrame.java
│       └── StatisticsFrame.java
│
├── screenshots/
│   ├── welcome.png
│   ├── main.png
│   ├── add-plant.png
│   └── statistics.png
│
├── README.md
└── .gitignore

▶️ How to Run

1. Open the project in NetBeans IDE.
2. Make sure Java JDK is installed.
3. Open the project.
4. Build the project.
5. Run "WelcomeFrame.java".
6. Click Start to open the application.

🖼️ Screenshots

1. Welcome Frame

"Welcome Frame" (screenshots/welcome.png)

2. Main Frame

"Main Frame" (screenshots/main.png)

3. Add Plant Frame

"Add Plant Frame" (screenshots/add-plant.png)

4. Statistics Frame

"Statistics Frame" (screenshots/statistics.png)

🔄 Application Flow

Start Application
       ↓
Welcome Frame
       ↓
     Start
       ↓
   Main Frame
       ↓
 ┌─────┼──────────┬─────────────┐
 ↓     ↓          ↓             ↓
Add   Search    Water Now    Statistics
Plant   ↓          ↓             ↓
      Find      Update       View Plant
      Plant     Date         Statistics
 └─────┬──────────┴─────────────┘
          ↓
 Check Watering Reminder
          ↓
Healthy / Needs Water / Overdue
          ↓
   Save Plant Data
          ↓
        Exit

The application starts from the Welcome Frame and moves to the Main Frame. From the main frame, users can add, search, remove, or water plants, check reminders, and view statistics. Plant data is saved using file serialization.

💡 Example

Plant Name| Plant Type| Last Watered| Next Due Date| Status
Peace Lily| Fern| 2026-08-16| 2026-08-18| Needs Water
Aloe Vera| Succulent| 2026-08-10| 2026-08-17| Overdue
Money Plant| Fern| 2026-08-17| 2026-08-19| Healthy

The application automatically calculates the Next Due Date and updates the plant's Status based on the current date.

🚀 Future Improvements

- Add more plant types with customizable watering intervals
- Add automatic desktop notifications for watering reminders
- Add an option to edit existing plant information
- Add a calendar-based watering schedule
- Improve the statistics section with charts and graphs
- Add user/plant owner management
- Replace file serialization with a database
- Add plant images and customizable icons

🎯 Project Goal

The goal of this project is to develop a simple and useful plant management system while applying Java, GUI development, file handling, and Object-Oriented Programming concepts in a practical project.

👥 Developed By

Group 01
⭐ If you find this project useful, feel free to give it a star!
