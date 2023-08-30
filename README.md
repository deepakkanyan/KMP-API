# Kotlin Multiplatform Project [ComposeUI, SwiftUI]

KMP-API is a Kotlin Multiplatform project aimed at to understand Simple API code shared on Both platform. 
Utilizing the power of Kotlin Multiplatform, this project demonstrates how to share code seamlessly across Android, iOS.

# Data Source

This project fetches its data from the SpaceX Data API. The SpaceX API provides company, vehicle, launch, and event data for SpaceX.
[SpaceX Rockets API Endpoint](https://docs.spacexdata.com/)

# Demo
<table>
  <tr>
    <td>Android/iOS</td>
  </tr>
  <tr>
    <td valign="top"><img src="https://github.com/deepakkanyan/KMP-API/blob/master/images/Untitled_Project_V1.gif" alt="iOS screenshot" width="400"/></td>
  </tr>
 </table>

## Features

- Share code across Android and iOS.
- Kotlin serialization with version `1.8.20`.
- Coroutines support with version `1.7.1`.
- Ktor client for network operations with version `2.3.2`.
- ComposeUI for Android
- SwiftUI for iOS

## Getting Started

### Prerequisites

- Kotlin 1.8.20 or later.
- Android SDK with compileSdk 34 and minSdk 26.
- ioS above 15.0

### Setting up the project

1. Clone the repository:

   ```bash
   git clone https://github.com/deepakkanyan/KMP-API.git
   ```

2. Navigate to the project directory and ensure you have the specified prerequisites installed.

## Dependencies

- **Kotlinx Coroutines**: For managing asynchronous tasks and more.
- **Ktor**: A flexible and powerful Kotlin client for networking tasks.

## Acknowledgments

- Kotlin for making multiplatform development a reality.
- The maintainers and contributors of the libraries used in this project.
