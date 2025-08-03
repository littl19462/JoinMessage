# JoinMessage 插件

一个用于PaperMC服务器的插件，提供以下功能：
- 自定义玩家加入/退出消息
- 玩家加入时发送"一言"
- 整点报时功能
- 支持PlaceholderAPI
- 兼容Paper 1.12.2 - 1.21.9

## 安装
1. 将构建的JAR文件放入服务器的`plugins`文件夹
2. 重启服务器
3. 编辑`plugins/JoinMessage/config.yml`进行配置

## 构建
```bash
mvn clean package
