session.save session.persist 没区别 一个hibernate的 一个jpa的

session.delete update 删除根据id跟别的没任何关系

session.saveOrUpdate 记住这个地方有个小坑，这个方法的意思是 有id那么就执行update,没有就save

//注意
session必须在事务环境下运行，无论是增删改查
那么get,load区别
如果要查询的对象不存在
get返回null,load抛出异常这只是区别的一种表现，但是本质


默认执行顺序
插入，修改，删除
如果想自定义顺序
session.flush()添加了一个刷新点，一共有四种刷新点，马上会执行sql语句