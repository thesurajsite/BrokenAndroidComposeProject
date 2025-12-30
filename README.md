# Assignment: By Suraj Verma

### 📹 Video Explanation  
https://drive.google.com/drive/folders/1_L9GV9_BwzEJYFboXBSgceMY6EAUFEUR?usp=sharing

---

## ✅ Overview

I implemented the **Fake News API** provided in the project since there was no API key available for the real News API.

I also made small modifications to the fake JSON and **added 4 more demo news items** including:

- image URLs  
- titles  
- content  

---

## ✨ Key Changes Made

### 1️⃣ MainActivity.kt
- Removed the companion object  
- Removed memory leak caused by static data reference  
- Cleaned up unused and unnecessary code  

---

### 2️⃣ Navigation
Implemented proper navigation architecture.

Files created:

- `NavGraph.kt`
- `Routes.kt`

Also:

- Replaced `NewsScreen` call with `NavGraph` inside `MainActivity.kt`

---

### 3️⃣ Article.kt
- Added `@SerializedName` annotations to map JSON response correctly  
- Modified Fake JSON to include:
  - 5 demo news articles  
  - image URLs  
  - content text  
- No changes to existing field names  

---

### 4️⃣ NewsScreen.kt
- Removed `LaunchedEffect` and `GlobalScope` usage  
- Shifted API calls into `ViewModel`  
- Major UI improvements:
  - Better layout design
  - Displaying images using **Coil**
  - Cleaner list styling  

---

### 5️⃣ MyViewModel.kt
- Created a **ViewModel** with proper state management  
- Repository now handles data fetching  
- UI observes state using flows  
- Followed **MVVM architecture best practices**

---

### 6️⃣ DetailScreen.kt
- Passed selected article through navigation  
- Displayed chosen article details on detail screen  
- Implemented enhanced UI for news details  

---

### 7️⃣ Gradle Changes
Added dependencies for:

- Navigation
- ViewModel / Lifecycle
- Coil (image loading)

---

## 🚀 Result

The app now:

- follows MVVM architecture  
- uses Navigation Compose  
- separates UI and data layers  
- displays news list and detailed news content cleanly  

---
