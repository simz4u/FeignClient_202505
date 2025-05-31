#!/bin/bash

APP_NAME="eureka-server"
SUBPROJECT_DIR="./$APP_NAME"
REMOTE_USER="simz"
REMOTE_HOST="127.0.0.1"
REMOTE_PATH="/home/simz/local/apps"
REMOTE_JAR_NAME="EurekaServer.jar"

ROOT_DIR=$(cd "$(dirname "$0")" && pwd)

echo "🚧 $APP_NAME 빌드 시작..."

cd "$ROOT_DIR/$SUBPROJECT_DIR" || { echo "❌ $APP_NAME 디렉토리로 이동 실패"; exit 1; }

cd "$ROOT_DIR" || { echo "❌ 루트 디렉토리로 이동 실패"; exit 1; }
./gradlew ":$APP_NAME:clean" ":$APP_NAME:bootJar" --refresh-dependencies

if [ $? -ne 0 ]; then
  echo "❌ Gradle 빌드 실패. 배포 중단."
  exit 1
fi

JAR_FILE=$(find "$ROOT_DIR/$SUBPROJECT_DIR/build/libs" -name "*.jar" | head -n 1)

if [ -z "$JAR_FILE" ]; then
  echo "❌ JAR 파일을 찾을 수 없습니다. 배포 중단."
  exit 1
fi

echo "📦 빌드된 JAR 파일: $JAR_FILE"
echo "📡 ${REMOTE_HOST} 서버로 업로드 중..."

scp "$JAR_FILE" "$REMOTE_USER@$REMOTE_HOST:$REMOTE_PATH/$REMOTE_JAR_NAME"

if [ $? -ne 0 ]; then
  echo "❌ scp 업로드 실패."
  exit 1
fi

echo "✅ 업로드 완료. 리모트 서버에서 다음 명령어로 실행하세요:"
echo "   java -jar $REMOTE_PATH/$REMOTE_JAR_NAME"

exit 0
