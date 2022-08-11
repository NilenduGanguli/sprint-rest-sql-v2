# sprint-rest-sql-v2

## Implementing a rest api using spring boot
for financial portfolio data management

Link For Jar file: \
https://drive.google.com/file/d/1fSR3SKog2_VRwgqht7xq3p3gfnYwduir/view?usp=sharing

json format for sending requests:

{ \
    "entityName" : "entity-type-entity-name", \
    "date" : "yyyy-mm-ddThh:mm:ss", \
    "buyOrSell" : "buy", \
    "quantity" : double, \
    "price" : double \
}

entity-type:  cash  :  eur,
gbp,
jpy,
inr,
cny,
usd

entity-type: stock  :  aapl,
abnb,
amzn,
intc,
googl


entity-type : crypto  :  btc,
eth,
usd,
dog,
ltc

