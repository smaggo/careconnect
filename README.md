![careconnect](src/main/resources/static/img/careconnect.png)

Care Connect
==============

Care Connect is a portal for a clinic. It helps the patients manage their appointments. It has dashboard so that patient can create their appointments online and get notified about that. It also helps the doctors to manage their appointments.

Table of contents
==================

- [Introduction](#introduction)
- [Usage scenarios](#usage-scenarios)
	- [Patient registration](#patient-registration)
	- [Registration of doctor by admin](#registration-of-doctor-by_admin)
	- [Patient appointment](#patient-appointment)
	- [Doctor updates appointment](#doctor-updates-appointment)
- [Design](#detail-design)
	- [Domain](#domain)
- [Issues](#issues)
- [Future considerations](#future-considerations)

Introduction
=============
This website helps the patient to communicate with the hospital to create an appointment. Doctors can accept the appointment. And patients can view the prescriptions and history.

Purpose
========

The purpose of the project is to understand the web application architecture. Here we used spring framework, as we learnt it in the theoratical study. As it is only demonstration, it is not fully featured website for patient. 

Usage scenarios
===============

The site has three kinds of users. 

- Patient
- Doctor
- Administrator

The administrator creates doctor. The patient registers in the site and creates appointment. And doctors agrees upon the appointment. Afterwards the patient can see appointment history.

character | description | task 
----------|:------------|:---------------------
Patient | The patient is the client of the hospital. He needs therapy for his or her illness. And he wants to see a doctor. He needs an appointment to do that. | He registers in the hospital and creates appointments.
Doctor | Doctor gives the patient the therapy for illness. He has specialization for some illness. | Doctor confirms registration and he updates the appointments.
Administrator | He is the hospital administrator | He creates new doctor accounts and updates the site.

#### Patient registration

![patient registration](doc/diagrams/patient_registration.svg)

The patient/user clicks on the Register link on the home page and is directed to the Patient Registration page where they need to fill the patient information. They need to input their firstname, lastname, street address, city, state, zipcode, phone number, date of birth, Social Security Number, email address and password.
After successful registration, they are directed to the Patient dashboard.

#### Registration of doctor by admin

![doctor registration](doc/diagrams/doctor_registration.svg)

The master admin user will login and clicks on the Add Doctor link which will load the Doctor Registration page.  The Admin fills in the Doctor firstname, lastname, street address, phone, email address, license number, specialization, Social Security Number and a temporary password.  
The doctor is notified via email with his username and password. The doctor will login, enters his username and password in the login page.  After successful login, the doctor is directed to the doctor dashboard.  The doctor then clicks on Account link and is directed to the Account page where the doctor can change his email address and/or password.  

#### Patient appointment

![patient asks for appointment](doc/diagrams/patient_appointment.svg)

A patient can request an appointment with a specific doctor.  The patient needs to login and proceeds to the patient dashboard where there is a link to create an appointment.  
In the appointment page, the patient needs to fill the form and enter the illness, date the illness started, date and time of appointment request.  The system will check for available date and time of the doctor selected. If no doctor is selected, the system will assign a doctor who is available on the given date. The appointment for also needs to get the Credit Card information from the user.  This is to ensure the user is serious about the appointment.  

#### Doctor updates appointment

![doctor updates the appointment](doc/diagrams/doctor_updates_appointment.svg)

The doctor will login and proceeds to the dashboard where a list of appointments (sorted by date, most recent first) with the status (Pending, Completed).  The doctor clicks on an appointment link and will then shown the appointment page.  In the appointment page the doctor can enter comments or prescriptions and change the status to Completed. When an appointment status is changed to Completed, an automatic payment is created by the system using the patient credit card details.  A payment notification is then sent to the patient email address.


Technologies
=============



