

# JoinMessage 插件

[![Latest Release](https://img.shields.io/github/v/release/littl19642/JoinMessage?label=最新版本)](https://github.com/littl19642/JoinMessage/releases/latest)
[![Build Status](https://img.shields.io/github/actions/workflow/status/littl19642/JoinMessage/release.yml?label=构建状态)](https://github.com/littl19642/JoinMessage/actions)

一个功能丰富的PaperMC插件，提供自定义玩家消息、一言功能和整点报时。

## 功能特色
- ✨ 完全可定制的加入/退出消息
- 📜 玩家加入时发送"一言"（每日一句）
- ⏰ 整点自动报时
- 🔌 支持PlaceholderAPI
- 📦 简单安装，零配置开箱即用

## 安装
1. 访问 [Releases 页面](https://github.com/littl19642/JoinMessage/releases)
2. 下载最新版本 JAR 文件
3. 放入服务器的 `plugins` 文件夹
4. 重启服务器

## 配置
首次运行后，编辑 `plugins/JoinMessage/config.yml`:
```yaml
# 消息配置
messages:
  join: "&e%player% 加入了游戏"
  quit: "&e%player% 离开了游戏"
  hitokoto: "&b今日一言: &f%hitokoto%"

# 一言功能
hitokoto:
  enabled: true  # 是否启用
  delay: 3       # 延迟发送时间(秒)

# 整点报时
time-announce:
  enabled: true  # 是否启用
  message: "&a现在是北京时间: &6%time%" # 报时消息格式
