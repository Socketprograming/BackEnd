# ✳️ SocketPrograming ✳️

### R&R

| 분야 | 이름 | 포지션 |

| 개발 | [유우식](https://github.com/YWSIK) | 💻 DB 및 API 구축, websocket 연결, 팀장 |

| 개발 | [이성원](https://github.com/lsw71311) | 🖥️ DB 및 API 구축, websocket 연결 |

| 개발 | [박예진](https://github.com/uiop5809) | 🖥️ 프론트 개발 |

| 개발 | [정태우](https://github.com/taewoojeong) | 💻 |

### Repository
| 개발 | https://github.com/Socketprograming/BackEnd

| 개발 | https://github.com/Socketprograming/FrontEnd

## computer: Technology
- ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000.svg?style=flat-square&logo=intellij-idea&logoColor=white)  ![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=flat-square&logo=Java&logoColor=white) ![Springboot](https://img.shields.io/badge/Springboot-6DB33F?style=flat-square&logo=springboot&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-%2300f.svg?style=flat-square&logo=mysql&logoColor=white)
- ![HTML](https://camo.githubusercontent.com/989c72c75f8e78ca3d5f8faf7d6d50228c2154b400a1280c36dff4d62783fadd/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f48544d4c352d4533344632363f7374796c653d666c6174266c6f676f3d48544d4c35266c6f676f436f6c6f723d7768697465) ![Css](https://camo.githubusercontent.com/79fe43df22a9d1011a93608949644a2676fb125b92192462dc5ae33558f69d14/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f435353332d3135373242363f7374796c653d666c6174266c6f676f3d43535333266c6f676f436f6c6f723d7768697465)  ![Js](https://camo.githubusercontent.com/0ac526200358c3cd09ca0eae4bc7149282c173b5fb1de1636715f18b9ab346ba/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a6176615363726970742d4637444631453f7374796c653d666c6174266c6f676f3d4a617661536372697074266c6f676f436f6c6f723d7768697465) ![Ts](https://camo.githubusercontent.com/17131306fc490286432e1148ea92ac1754363621a9d185bf613ad6e0f4d33a96/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f547970655363726970742d3331373843363f7374796c653d666c6174266c6f676f3d54797065536372697074266c6f676f436f6c6f723d7768697465) ![React](https://camo.githubusercontent.com/835b9feec81fd42c824d27ac734bfcabb61fa43c4b3b166fe89adf5bd06b079c/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f52656163742d3631444146423f7374796c653d666c6174266c6f676f3d5265616374266c6f676f436f6c6f723d7768697465)

### **📗 프로젝트 주제 선정**
    웹 개발 공부를 하던 학생들끼리 뭉쳐 팀 프로젝트를 진행했습니다.
    spring websocket과 한국투자증권 api를 이용해 실시간 주가를 확인할 수 있는 웹을 구성하는 것을 목표로 시작했습니다.

### **📗 프로젝트 일정**
    09.11 팀 프로젝트 공지
     ~ 10.02 팀 프로젝트 주제 선정
     ~ 10.04 팀 프로젝트 주제 확정
     ~ 10.24 프로젝트 초기설정
     ~ 11.21 팀 프로젝트 종료
     ~ 11.27 팀 프로젝트 발표

### **📗 프로젝트를 마치며**
     목표한 기능들과 서버 배포까지 완성하지 못했지만 websocket을 이용해 실시간으로 주가 정보를 받아오는 것은 성공했습니다.
     websocket을 이용해 정보를 받아오는 과정을 spring에서 진행을 했는데, 적절하지 않은 방법이었던 것 같습니다.
     websocket은 HTTP와는 다르게 접속을 위한 하나의 url만 존재하고 뒤로는 모두 messaging을 통해 처리해야 하기 때문에
    초기 구상한 모델에서 많은 수정을 해야했기에 기한 내 완성하지 못했습니다.
     websocket은 실시간 주가를 확인하는 방법으로 채택할 수 있지만, 주식 시장이 열려있는 09:00 ~ 15:00 제외하고는 테스트가 불가능해
    spring을 사용한다면 webclient 방식으로 데이터를 파싱하는 방법이 주가확인을 적절하다는 것을 알게되었습니다.

<br>

[//]: # (## 🔖 Naming Rules)

[//]: # ()
[//]: # (Java)

[//]: # (- Class & Interface: `UpperCamelCase`)

[//]: # (    - Class 이름은 일반적으로 명사, 명사구)

[//]: # (    - Interface 이름은 명사, 명사구도 되지만 형용사, 형용사구도 됨)

[//]: # (- Package: `Lowercase` 복합단어 사용 금지)

[//]: # (- Method & Parameter: `LowerCamelCase`)

[//]: # (    - Method 이름은 동사, 동사구)

[//]: # (- Constant: `UpperSnakeCase`)

[//]: # (    - 모두 대문자로 밑줄&#40;_&#41;로 각 단어 구분)

[//]: # (- Non-constant field names & Local variable: `LowerCamelCase`)

[//]: # (- Camel case: defined)

[//]: # (    - 구를 일반 ASCII로 변환하고 어퍼스트로피 제거)

[//]: # (    - 단어로 나누고 공백과 나머지 구두점으로 분리)

[//]: # (    - 각 단어를 `UpperCamelCase`로 표시하거나 첫 단어 제외한 각 단어는 `LowerCamelCase`)

[//]: # (    - 모든 단어를 단일 식별자로 결합)

[//]: # ()
[//]: # (<br>)



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
