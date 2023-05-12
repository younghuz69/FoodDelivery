## 1.EventStorming : Model Design Level
![image](https://github.com/younghuz69/FoodDelivery/assets/132860007/ac08a9f2-a55a-498c-9b43-33fe7323499a)




## 2.Saga(Pub / Sub)
![image](https://github.com/younghuz69/FoodDelivery/assets/132860007/ff5960c5-2d0c-4adf-b917-63bf6a757c7b)



## 3.CQRS
![image](https://github.com/younghuz69/FoodDelivery/assets/132860007/073e4e34-bc24-43ab-a1bf-efd6d1a1b83d)
![image](https://github.com/younghuz69/FoodDelivery/assets/132860007/326f8712-e9b7-4c7c-b4c9-51100ace729a)
![image](https://github.com/younghuz69/FoodDelivery/assets/132860007/34ec11ef-36fc-4fdb-ab37-0f2e136a89d4)



## 4.Compensation / Correlation
![image](https://github.com/younghuz69/FoodDelivery/assets/132860007/43f645fa-1798-4b1c-abd4-e232573dff33)
![image](https://github.com/younghuz69/FoodDelivery/assets/132860007/2b2ba19e-b132-4ec9-b61b-d0ef3b6459b6)
![image](https://github.com/younghuz69/FoodDelivery/assets/132860007/00768215-d080-4d29-9b89-8af7a476ef0c)



# 

## Model
www.msaez.io/#/storming/fooddelivery10

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- front
- store
- rider
- customer


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- front
```
 http :8088/orders id="id" foodId="foodId" options="options" address="address" customerId="customerId" storeId="storeId" 
 http :8088/payments id="id" orderId="orderId" status="status" 
```
- store
```
 http :8088/foodCookings id="id" status="status" foodId="foodId" orderId="orderId" options="options" storeId="storeId" 
```
- rider
```
 http :8088/deliveries id="id" status="status" orderId="orderId" address="address" 
```
- customer
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

