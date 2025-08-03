# JoinMessage 变更日志

## [Unreleased]
> 下一个版本的变更将出现在这里

## [v1.0.0] - 2025-08-03
### 新增
- 初始版本发布
- 自定义玩家加入/退出消息
- 玩家加入时发送一言
- 整点报时功能
- PlaceholderAPI 支持

### 配置示例
```yaml
# config.yml
messages:
  join: "&e%player% 加入了游戏"
  quit: "&e%player% 离开了游戏"
  hitokoto: "&b今日一言: &f%hitokoto%"

hitokoto:
  enabled: true
  delay: 3

time-announce:
  enabled: true
  message: "&a现在是北京时间: &6%time%"
