# 🌱 Houseplant Watering Scheduler

A Java-based desktop application that helps users manage their houseplants and keep track of their watering schedules.

## 📌 Project Overview

**Houseplant Watering Scheduler** is a Java Swing application designed to make plant care easier. Users can add plants, assign them to owners, set watering frequencies, and track when each plant needs to be watered.

The system automatically calculates the next watering date and displays whether a plant is **Due Today**, **Overdue**, or **Not Due Yet**.

## ✨ Features

* 🌱 Add and manage plants
* 👤 Store plant owner information
* 💧 Set watering frequency
* 📅 Track the last watering date
* ⏰ Automatically calculate the next watering date
* ⚠️ Show plant watering status
* 🔴 Identify overdue plants
* 🟢 Identify plants that are not due yet
* 🖥️ User-friendly Java Swing GUI
* 🔎 Search and view plant information

## 🛠️ Technologies Used

* **Java**
* **Java Swing**
* **Object-Oriented Programming (OOP)**
* **NetBeans IDE**
* **Git & GitHub**

## 🧩 OOP Concepts Used

This project demonstrates several important OOP concepts:

* **Encapsulation**
* **Inheritance**
* **Polymorphism**
* **Abstraction**
* **Interfaces**

The project also uses an `Alertable` interface to handle watering-related alerts.

## 📂 Project Structure

```text
Houseplant-Watering-Scheduler/
│
├── src/
│   ├── gui/
│   │   └── MainFrame.java
│   │
│   ├── plants/
│   │   └── Plant.java
│   │
│   ├── manager/
│   │   └── PlantManager.java
│   │
│   └── interfaces/
│       └── Alertable.java
│
└── README.md
```

## 🚀 How to Run

1. Clone the repository.
2. Open the project in **NetBeans IDE**.
3. Make sure Java/JDK is installed.
4. Build the project.
5. Run the `MainFrame` class.

## 📋 Example

A plant can have information such as:

| Information   | Example    |
| ------------- | ---------- |
| Owner         | Suva       |
| Plant Name    | Aloe Vera  |
| Plant Type    | Succulent  |
| Frequency     | 7 Days     |
| Last Watered  | 2026-08-03 |
| Next Watering | 2026-08-10 |
| Status        | Overdue    |

## 🎯 Project Goal

The main goal of this project is to provide a simple and convenient way to organize houseplant watering schedules while demonstrating practical **Java OOP and GUI programming** concepts.

## 👩‍💻 Developed By

**Sujana Aktery and my team**

---

⭐ If you find this project useful, feel free to give it a star!
