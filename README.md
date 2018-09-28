# Green Sense
An Open Source Project for Smart Plant Monitoring for Precision Farming

![GitHub](https://img.shields.io/badge/NTWoC-2018-blue.svg)



### Abstract
It is extremely difficult for the farmers to maintain huge plantations by themselves, hence our product “Green Sense” provides one stop solution to farmers to ease their work in all most every aspects of farming.

### What our Project offers to the farmers:
* Localized weather forecast and prediction system.
* Real Time Soil Monitoring – pH, Humidity
* Plant Health based on the Chlorophyll Content – using Spectroscopic Techniques
* Market Forecast of various Crops
* Smart Crop Management
* Creating a repository of images of diseased plants for research purposes
* Redundant network = 0 downtime

### For this Project, we primarily have two subsets: 

### Software
* primarily responsible for providing a Smart Dashboard to the farmers which is accessible through their smartphones. We are also providing SMS based interaction portal with the Smart Dashboard for those farmers who are not capable of affording a smartphone.
* Smart Dashboard provides the real time data i.e. (pH, Soil Moisture Content, Chlorophyll Content of Leaves, Air Humidity, Pressure and Temperature, Hours of Sunlight received by the plant, Centimetres of rainfall received).
* The Dashboard will also provide predictions of the weather and suggest the farmer accordingly what they have to do, in order the greatest efficiency - for example it’ll suggest how much water you have to irrigate, how much of manure needs to be added to the soil and so on using Data Analytics and Machine Learning Algorithms.
* We’ll be implementing Deep Learning Algorithms to detect Chlorophyll content of the leaves to predict how healthy the leaves are.



### Hardware 
* deals with collection of data with help of various sensors and using various communication protocol to push these data to the Cloud.
* NodeMCU along with an ADC is used to collect data from various sensors.
* The NodeMCU then pushes the data to another node MCU which is connected to the internet over the GSM network, this other node MCU which acts as the gateway to the internet.
* We also have secondary DigiMesh network for redundancy, i.e. in case the GSM network is not available or it goes down, this redundant link to the gateway will insure 0 downtime. 



## Tech Stack
### Hardware
* NodeMCU - ESP8266 WiFi Module
* Bunch of Sensors to monitor weather conditions - DHT Sensor, pH Sensor etc


### Skill Requirements (You can apply if you have any one of the skills mentioned below)

* Hardware Programmer
* Front End Developer - Flask/Django
* Back End Developer
* Python
* Deep Learning




### New Ideas
New Ideas are always welcome. Talk to your mentor and convince him/her that this new idea/feature for this hardware is useful, easy to build and can be built in the time duration. 


## Project Maintainers
The project is currently being maintained by :  
1) Arko Chatterjee (arkochatterjee)


