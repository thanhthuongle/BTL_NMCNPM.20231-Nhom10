# Resident Management Desktop Application

Resident Management Desktop Application is a Java-based application built with Apache Maven for efficient management of resident information on desktop platforms.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)

## Introduction

Resident Management Desktop Application is designed to provide a user-friendly interface for managing resident information efficiently on desktop systems. The application offers features to create, update, search for resident profiles and fee management features.

## Prerequisites

- Java (use JDK 11) [Download here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html). Remember to set JAVA_HOME in env path.
- Apache Maven (3.8.6) [Download here](https://maven.apache.org/download.cgi). Remember to set MAVEN_HOME and M2_HOME in env path.
- SQL Server 2019
- Eclipse 2022

## Installation

1. Select File > Import > Git > Projects from Git (with smart import)
2. Select File > Import > Maven > Existing Maven Projects

## Usage

1. **Create Database**: 
- Create database `vietnamese_provinces`, run all SQL files in the `create_database/vietnamese_provinces` folder in the following order: `vn_provinces.sql`, `add_data_vn_provinces.sql`, `add_fulltext_vn_provinces.sql`.
- Create database `quan_ly_nhan_khau`, run all SQL files in the `create_database/household_management` folder in the following order: `household_management.sql`, `add_data_household_management.sql`, `fee_management.sql`.
and `add_data_fee_management.sql`.
2. **Setup SQL Server**: Config sql server params in `config.txt`.
3. **Run App**: Open the project in Eclipse. Navigate to `src/app`. Run the `Main.java` file.
