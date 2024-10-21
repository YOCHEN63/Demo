# Demo
This repo is made for practice the demo of high performance ordering situation.

**Used Technology**
- SpringBoot
- Redis
- Kafka

## 秒杀
1. 从redis获取当前库存
2. 如果redis没有，从数据库获取
3. 获取库存后，对redis执行`SETNX`（保证期间没有被赋值）
4. 扣减库存，如果扣减后低于0，则恢复库存并返回失败
5. TODO：成功后提交到kafka
