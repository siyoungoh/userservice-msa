# User Service

## 소개
User Service는 사용자 정보를 조회할 수 있는 간단한 Spring Boot 기반 REST API 애플리케이션입니다.  
서비스는 Docker 컨테이너와 함께 실행 가능하며, 사용자 정보를 ID를 통해 조회할 수 있습니다.

---

## 주요 기능
- **사용자 정보 조회**  
  REST API를 통해 특정 ID의 사용자 정보를 조회할 수 있습니다.

  ### API 엔드포인트
  - `GET /users/{id}`  
    요청된 ID에 해당하는 사용자의 정보를 반환합니다.

---

## 기술 스택
- **백엔드**: Spring Boot, Java 17
- **빌드 도구**: Gradle 7.6
- **컨테이너 환경**: Docker
- **JDK 런타임**: Eclipse Temurin 17

---

## 시스템 요구사항
- Java 17 이상
- Docker 및 Docker Compose 설치

---

## 실행 방법

### 1. 로컬 환경에서 실행
1. 프로젝트를 클론합니다.
   ```bash
   git clone <REPOSITORY_URL>
   cd <PROJECT_FOLDER>
   ```
2. 애플리케이션 실행:
   ```bash
   ./gradlew bootRun
   ```
   애플리케이션은 기본적으로 [http://localhost:8081](http://localhost:8081)에서 실행됩니다.

---

### 2. Docker로 실행
1. Docker 이미지를 빌드합니다.
   ```bash
   docker build -t userservice .
   ```
2. 컨테이너 실행:
   ```bash
   docker run -p 8081:8081 userservice
   ```
   애플리케이션은 Docker 컨테이너에서 [http://localhost:8081](http://localhost:8081)에서 실행됩니다.

---

## 구성 및 설정
### 기본 설정 (`application.yml`)
- 서버 포트: `8081`

---

## 예시
### 사용자 정보 조회
#### 요청:
```http
GET /users/1 HTTP/1.1
Host: localhost:8081
```

#### 응답:
```json
{
  "id": 1,
  "name": "User1"
}
```

---

## 빌드 프로세스
1. Gradle은 프로젝트를 빌드하고 실행 파일(JAR)을 생성합니다.
2. Docker는 생성된 JAR 파일을 기반으로 실행 가능한 컨테이너 이미지를 생성합니다.

`Dockerfile` 구성:
- Gradle을 사용하여 애플리케이션을 빌드 (스테이지 `build`)
- Eclipse Temurin JRE로 빌드된 JAR 파일 실행 (최종 스테이지)

---

## 라이센스
- MIT License