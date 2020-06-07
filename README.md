# 一个简单的MVC实例

简单的NoteBook

## MVC

- View 负责展示视图，和用户交互。将用户的请求发给Controller。监听Model的更新。
- Controller 负责处理用户请求，转化成Model能听懂的方法调用，并协调控制View视图层变化。
- Model 数据模型，肩负缓存、持久化数据的任务。一旦有更新可以通知视图层发生变化。