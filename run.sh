#!/bin/bash
# 使用说明：
# 1. 将此脚本拷贝到 Spring Boot 项目根目录
# 2. 运行命令：./run.sh [应用名] start|stop|restart

# 应用名，可根据实际情况修改
APP_NAME=$1

# 判断应用名是否为空
if [[ -z $APP_NAME ]]; then
  echo "Error: 请指定应用名！"
  exit 1
fi

# Spring Boot jar 包名称，可根据实际情况修改
JAR_NAME=$APP_NAME.jar

# Java 环境路径，可根据实际情况修改
JAVA_HOME=/usr/local/java/jdk1.8.0_291

# 运行参数，可根据实际情况修改
JAVA_OPTS="-Xms512m -Xmx512m -XX:PermSize=256m -XX:MaxPermSize=256m -Dspring.profiles.active=prod"

# PID 文件路径，可根据实际情况修改
PID_FILE=$APP_NAME.pid

# 启动命令
function start() {
  # 判断应用是否已经启动
  if [[ -f $PID_FILE ]]; then
    PID=$(cat $PID_FILE)
    if ps -p $PID > /dev/null; then
      echo "Error: $APP_NAME is already running with pid $PID."
      exit 1
    fi
  fi

  # 启动应用
  nohup $JAVA_HOME/bin/java $JAVA_OPTS -jar $JAR_NAME > /dev/null 2>&1 &

  # 保存进程 ID 到文件
  PID=$!
  echo $PID > $PID_FILE
  echo "$APP_NAME started with pid $PID."
}

# 停止命令
function stop() {
  # 判断应用是否已经启动
  if [[ -f $PID_FILE ]]; then
    PID=$(cat $PID_FILE)
    if ps -p $PID > /dev/null; then
      # 关闭应用进程
      kill $PID
      rm $PID_FILE
      echo "$APP_NAME stopped."
    else
      echo "Error: $APP_NAME is not running."
      exit 1
    fi
  else
    echo "Error: $APP_NAME is not running."
    exit 1
  fi
}

# 重启命令
function restart() {
  stop
  start
}

# 根据命令执行相应操作
case $2 in
  start)
    start;;
  stop)
    stop;;
  restart)
    restart;;
  *)
    echo "Usage: $0 [应用名] {start|stop|restart}"
    exit 1;;
esac

exit 0
