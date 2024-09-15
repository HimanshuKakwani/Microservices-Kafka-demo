Kafka demo using microservices architechture.
There are 3 microservices:
1. Order microservice: Used to send orders to kafka broker
2. Stock microservice: Used to recieve the order from the Kafka Producer(Order service)
3. Email microservice: Used to send an email to user regarding the order

Single broker architechture for Kafka has been implemented

![Architechture diagram](https://github.com/user-attachments/assets/90ece0b6-f06d-4353-bef4-830fdf9ea72e)
