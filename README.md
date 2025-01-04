# File Hider Java Project

## Overview

The **File Hider** is a Java-based application designed to securely hide files on a desktop and store them in a **MySQL database**. The project is built using the **MVC architecture**, combining the **service** and **controller** layers for simplicity. Users authenticate via email and OTP to hide and unhide files, ensuring that the application provides a secure and easy-to-use way to manage files.

---

## Features

- **Email and OTP Authentication**: Secure login and registration with email and OTP verification.
- **File Management**: Users can hide, unhide, and view their files stored in the database.
- **Interactive Views**: Two types of views are available:
  - **Welcome View**: For user login, registration, and authentication.
  - **User View**: For managing hidden files (view, unhide, hide).
- **Database Integration**: MySQL is used to store user and file data, ensuring that files are securely stored even after being hidden from the desktop.

- ## Setup

### 1. Clone the Repository
[```bash
git clone <repository-url>](https://github.com/ramnaik018/FileEncrypter)
