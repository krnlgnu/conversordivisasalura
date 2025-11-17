# 🌎💱 Conversor de Divisas --- Proyecto Java

![Status](https://img.shields.io/badge/status-active-brightgreen)
![Java](https://img.shields.io/badge/Java-17+-red)
![Gson](https://img.shields.io/badge/Gson-2.10.1-blue)
![Build](https://img.shields.io/badge/build-manual-orange)

Proyecto en **Java** para convertir montos entre diversas divisas usando
una API de tasas de cambio.\
Incluye pluralización natural del nombre de las monedas, validaciones,
manejo de errores y una arquitectura clara.

## ✨ Características principales

-   🔄 Conversión entre monedas con API real.
-   🚧 Manejo avanzado de errores HTTP.
-   🎯 Validación robusta de entrada.
-   🗣️ Pluralización automática y natural.
-   🧩 Código organizado en clases pequeñas y reutilizables.
-   📡 Cliente HTTP propio sin frameworks externos.

## 📦 Dependencias

Este proyecto **NO utiliza Maven**.\
Se usa **Gson**, agregado manualmente.

    lib/gson-2.10.1.jar

## 🧰 Estructura del Proyecto

    /src
      ├── Main.java
      ├── ConversorDivisas.java
      ├── ClienteAPI.java
      ├── Moneda.java
      ├── ParDivisa.java
      ├── Pluralizador.java
    /lib
      └── gson-2.10.1.jar
    README.md

## 🌐 API utilizada

Se utiliza **ExchangeRate API**:

    https://v6.exchangerate-api.com/

## ▶️ Cómo ejecutar el proyecto

### 1️⃣ Compilar

Windows:

``` bash
javac -cp lib/gson-2.10.1.jar src/*.java
```

Linux / macOS:

``` bash
javac -cp lib/gson-2.10.1.jar:src src/*.java
```

### 2️⃣ Ejecutar

Windows:

``` bash
java -cp lib/gson-2.10.1.jar;src Main
```

Linux / macOS:

``` bash
java -cp lib/gson-2.10.1.jar:src Main
```

## 🧠 Pluralización inteligente

Ejemplos: - 1 peso mexicano → **1 peso mexicano** - 2 pesos mexicanos →
**2 pesos mexicanos** - 1 yen japonés → **1 yen japonés** - 8 yenes
japoneses → **8 yenes japoneses**

## 📄 Ejemplo real de conversión

Entrada:

    Cantidad: 250
    Base: MXN
    Objetivo: USD

Salida:

    250 pesos mexicanos equivalen a 13.80 dólares estadounidenses.

## 🛠️ Clases del proyecto

Clase              Función
  ------------------ --------------------------------
Main               Punto de entrada
ConversorDivisas   Lógica principal de conversión
ClienteAPI         Comunicación HTTP con la API
Moneda             Representa cada divisa
ParDivisa          Relación base → objetivo
Pluralizador       Pluralización natural
