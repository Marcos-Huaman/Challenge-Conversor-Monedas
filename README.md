# 💱 Conversor de Monedas en Java

Una aplicación de consola desarrollada en Java que permite realizar conversiones entre distintas monedas utilizando datos reales obtenidos desde [ExchangeRate-API](https://www.exchangerate-api.com/).

---

## 🚀 Características

- ✅ Conversión rápida entre monedas comunes (USD ↔ ARS, BRL, COP)
- ✅ Conversión personalizada entre cualquier par de monedas (ej. EUR → JPY)
- ✅ Historial de conversiones con marca de tiempo
- ✅ Integración con la API ExchangeRate para tasas de cambio actualizadas
- ✅ Validación de entradas numéricas

---

## 📷 Capturas (Modo Consola)
![image](https://github.com/user-attachments/assets/41ad8b35-6570-4958-a3b2-60313bf8d32a)
![image](https://github.com/user-attachments/assets/cec71c86-3a35-497f-af44-98b181184f26)

---

## 🛠️ Tecnologías usadas

- Java 17 o superior
- Librería [Gson](https://github.com/google/gson) para parseo de JSON
- API pública de tasas de cambio: [https://www.exchangerate-api.com](https://www.exchangerate-api.com)

---

## 📦 Estructura del Proyecto
src/
└── com/
└── alurachallenge/
└── convertersormonedas/
├── ConversorApp.java // Clase principal con menú
├── Conversor.java // Lógica de conversión + API
└── Moneda.java // Modelo de datos (POJO)

---
