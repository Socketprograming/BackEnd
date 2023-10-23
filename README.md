# ✳️ SocketPrograming ✳️

### R&R


| 분야 | 이름 | 포지션 |
| 개발 | [정태우](https://github.com/taewoojeong) | 📱 iOS 화면 UI 구현, 서버 연동 |
| 개발 | [유우식](https://github.com/YWSIK) | 💻 DB 및 API 구축, 서버 배포 |
| 개발 | [이성원]([https://github.com/hojeong2747](https://github.com/lsw71311)) | 🖥️ DB 및 API 구축, 서버 배포 |

<br>
<br>

<br>
<br>



<br>

## :computer: Technology
- Server
    - ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000.svg?style=flat-square&logo=intellij-idea&logoColor=white)
      ![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=flat-square&logo=Java&logoColor=white)
      ![Springboot](https://img.shields.io/badge/Springboot-6DB33F?style=flat-square&logo=springboot&logoColor=white)
      ![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=flat-square&logo=Spring%20Security&logoColor=white)
      ![Shell Script](https://img.shields.io/badge/Shell_Script-%23121011.svg?style=flat-square&logo=gnu-bash&logoColor=white)
      ![JWT](https://img.shields.io/badge/JWT-black?style=flat-square&logo=JSON%20web%20tokens)
      ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=flat-square&logo=Gradle&logoColor=white)
      ![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=flat-square&logo=swagger&logoColor=white)
    - ![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=flat-square&logo=spring&logoColor=white)
      ![QueryDSL](https://img.shields.io/badge/QueryDSL-007ACC?style=flat-square&logo=kotlin&logoColor=white)
    - ![MySQL](https://img.shields.io/badge/MySQL-%2300f.svg?style=flat-square&logo=mysql&logoColor=white)
      ![Redis](https://img.shields.io/badge/Redis-%23DD0031.svg?style=flat-square&logo=redis&logoColor=white)
      ![RDS](https://img.shields.io/badge/AWS%20RDS-527FFF?style=flat-square&logo=Amazon%20RDS&logoColor=white)
      ![ElastiCache](https://img.shields.io/badge/AWS%20ElastiCache-4053D6?style=flat-square&logo=Amazon)
      ![AWS Lambda](https://img.shields.io/badge/AWS%20Lambda-FF9900?style=flat-square&logo=AWS%20Lambda&logoColor=white)
      ![Amazon CloudWatch](https://img.shields.io/badge/Amazon%20CloudWatch-FF4F8B?style=flat-square&logo=Amazon%20CloudWatch&logoColor=white)
      ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=Hibernate&logoColor=white)
    - ![GitHub Actions](https://img.shields.io/badge/Github%20Actions-%232671E5.svg?style=flat-square&logo=githubactions&logoColor=white)
      ![EC2](https://img.shields.io/badge/AWS%20EC2-FF9900?style=flat-square&logo=Amazon%20EC2&logoColor=white)
      ![Docker](https://img.shields.io/badge/Docker-%230db7ed.svg?style=flat-square&logo=docker&logoColor=white)
      ![Nginx](https://img.shields.io/badge/Nginx-%23009639.svg?style=flat-square&logo=nginx&logoColor=white)


### **📗 Server 선정 이유**

- IntelliJ는 Spring Boot 개발을 위해 필요한 모듈과 기능을 간편하게 사용할 수 있는 IDE입니다.
- Spring Boot는 Spring framework를 간편하게 사용할 수 있게 해주며 RDBMS와의 편리한 연동, 라이브러리의 버전 관리 자동화 등으로 Java 기반 애플리케이션 서버 개발에 특화되어 있습니다.
- Spring Security를 사용하여 JWT 기반 사용자 인증 관련 필터를 구축하였습니다.
- Spring Data JPA를 사용하여 연동한 RDBMS에 간편하게 접근하고, 필요 시 JPQL과 QueryDSL fetch join을 사용하여 N + 1 문제를 해결하였습니다.
- Slf4j와 logback-spring.xml 파일 설정을 통해 배포된 서버에서 로그를 파일에 저장하도록 구현했습니다.
- OpenId Connect는 OAuth 2.0에서 확장된 인증 프로토콜이며, 소셜 로그인 시 API 호출 횟수를 약 절반 가까이 줄일 수 있는 장점을 가지고 있습니다. 따라서 OpenId Connect를 사용하여 애플 로그인 및 카카오 로그인을 구현하였습니다.
- 일반적인 데이터를 안전하게 저장하기 위해 대표적인 RDBMS인 MySQL을 사용했고, 이를 AWS RDS를 통해 배포하였습니다.
- 매일 자정마다 DB에 insert, update 쿼리를 수행하기 위해 pymysql을 이용해 작성한 쿼리 파일을 Lambda에 업로드하고, EventBridge의 규칙에 따라 Lambda를 실행하도록 구현하였습니다.
- 로그인 과정에서 발급되는 JWT인 Access Token과 Refresh Token 중 Refresh Token을 캐싱하여 사용자가 빠르게 Access Token을 재발급 받을 수 있게 하기 위해 Redis를 사용하였습니다. JWT로 구현된 Access Token은 탈취 당하더라도 유저 정보는 안전하지만, 이를 그대로 활용하여 로그인할 수 있기 때문에 만료 시간을 짧게 설정하고 Refresh Token을 이용하여 사용자의 불편을 줄였습니다. Redis에 Refresh Token과 Request IP를 저장하여 Refresh Token 탈취에 대비했으며, 배포에는 AWS ElastiCache를 사용하였습니다.
- JAR 파일을 배포하기 위해 환경설정이 간편한 AWS EC2를 사용하였습니다.
- 무료로 사용할 수 있으며 비밀 값을 Repository Secret에 넣어 안전하게 관리할 수 있는 Github Actions를 사용하여 CI/CD를 구현했습니다.
- CI/CD 구현 및 컨테이너화를 위해 Docker를 사용하였습니다. Docker Compose를 통해 빌드된 JAR 파일 및 nginx를 EC2 상에 컨테이너를 생성해 배포하였습니다.
- 서버의 자원을 더욱 효율적으로 사용하기 위해 nginx를 사용하였습니다.

<br>

## 🔖 Naming Rules

Java
- Class & Interface: `UpperCamelCase`
    - Class 이름은 일반적으로 명사, 명사구
    - Interface 이름은 명사, 명사구도 되지만 형용사, 형용사구도 됨
- Package: `Lowercase` 복합단어 사용 금지
- Method & Parameter: `LowerCamelCase`
    - Method 이름은 동사, 동사구
- Constant: `UpperSnakeCase`
    - 모두 대문자로 밑줄(_)로 각 단어 구분
- Non-constant field names & Local variable: `LowerCamelCase`
- Camel case: defined
    - 구를 일반 ASCII로 변환하고 어퍼스트로피 제거
    - 단어로 나누고 공백과 나머지 구두점으로 분리
    - 각 단어를 `UpperCamelCase`로 표시하거나 첫 단어 제외한 각 단어는 `LowerCamelCase`
    - 모든 단어를 단일 식별자로 결합

<br>
 


### 📌 Type

| commit 명 | commit 뜻 |
| --- | --- |
| Feat | 새로운 기능 추가 |
| Fix | 버그 수정 |
| Docs | 문서 수정 |
| Style | 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우 |
| Refactor | 코드 리펙토링 |
| Test | 테스트 코드, 리펙토링 테스트 코드 추가 |
| Chore | 패키지 매니저 추가 |
| Build | 빌드 관련 파일 수정 |
| CI | CI 설정 파일 수정 |
| Pref | 성능 개선 |
| Design | UI 디자인 변경 |
| Add | 파일 추가 |
| Rename | 파일 혹은 폴더 이동, 이름 수정 |
| Remove | 파일 삭제 |
