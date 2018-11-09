## Sharding-Sphere 数据分片与读写分离

### 数据分片

`t_order`逻辑表可以分为以下真实表：

```
db0
  ├── t_order_0
  ├── t_order_1
  └── t_order_2
db1
  ├── t_order_0
  ├── t_order_1
  └── t_order_2
```

编译后执行， profile 为 `sharding`

```
java -jar demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=sharding
```

### 读写分离

配置master为主库，slave0和slave1为从库：

```
master
  └── t_user

slave0
  └── t_user

slave1
  └── t_user
```

编译后执行， profile 为 `ms`

```
java -jar demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=ms
```

### 数据分片 + 读写分离

结合数据分片和读写分离，将master分片为master0 和master1 两个数据库，然后再master0和master1配置主从数据库，
master0 对应 master0slave0，master0slave1， master1对应  master1slave0，master1slave1

```
master0
  ├── t_order_0
  └── t_order_1

master0slave0
  ├── t_order_0
  └── t_order_1

master0slave1
  ├── t_order_0
  └── t_order_1


master1
  ├── t_order_0
  └── t_order_1

master1slave0
  ├── t_order_0
  └── t_order_1

master1slave1
  ├── t_order_0
  └── t_order_1
```

编译后执行， profile 为 `sms`

```
java -jar demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=sms
```