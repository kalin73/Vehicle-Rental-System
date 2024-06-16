# Vehicle Rental System
For the development of this application are followed "SOLID" principles. Functionality is separated between different packages and classes responsible for every vehicle type. New functions and vehicle types can be added without modifying the existing classes.

# Project structure
The project contains 3 main packages and **"Main"** class:
- [business](https://github.com/kalin73/Vehicle-Rental-System/tree/main/business) : contains the business logic for calculations and output construction 
- [model](https://github.com/kalin73/Vehicle-Rental-System/tree/main/model) : contains information for the entities of this application (vehicles and client) 
- [utils](https://github.com/kalin73/Vehicle-Rental-System/tree/main/utils) : contains reusable utilities

Package **business** has 3 more packages **(insurance, rental, and invoice)**
- [insurance](https://github.com/kalin73/Vehicle-Rental-System/tree/main/business/insurance) : contains calculator classes and interfaces for calculating the insurance for different vehicle  types
- [rental](https://github.com/kalin73/Vehicle-Rental-System/tree/main/business/rental) : classes with the specific rental information for every vehicle type
- [invoice](https://github.com/kalin73/Vehicle-Rental-System/tree/main/business/invoice) : classes for constructing the specific output

Package **model** has 2 more packages **(vehicle and client)**
- [vehicle](https://github.com/kalin73/Vehicle-Rental-System/tree/main/model/vehicle) : contains one abstract base class and three child classes for every type vehicle
- [client](https://github.com/kalin73/Vehicle-Rental-System/tree/main/model/client) : contains client information

Package **utils** has 1 class **(CurrencyFormatter)** which is responsible for formatting currencies in the application.

The **"Main"** class is used for generating the input and running the application.
