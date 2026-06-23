# Simple Board (스프링부트 + JPA 게시판 REST API)

6주차 스터디 실습 프로젝트. CRUD / JPA / Entity·DTO / RESTful API / Postman 학습용으로 만든 게시판입니다.

## 기술 스택
- Java 17, Spring Boot 3.3
- Spring Data JPA, H2 (인메모리 DB)
- Thymeleaf (목록 화면 한 개), Lombok, Validation

## 실행 방법
1. IntelliJ에서 폴더 열기 (Gradle 프로젝트로 자동 인식)
2. `BoardApplication` 실행
3. 접속
   - API: `http://localhost:8080/api/posts`
   - 화면: `http://localhost:8080/posts`
   - H2 콘솔: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:board`)

> MySQL로 바꾸려면 `build.gradle`과 `application.yml`의 주석 부분 참고

## REST API 명세
| 기능 | 메서드 | URL | 요청 본문 | 응답 |
|------|--------|-----|-----------|------|
| 생성 | POST | /api/posts | {title, content, author} | 201, 생성된 id |
| 전체조회 | GET | /api/posts | - | 200, 목록 |
| 단건조회 | GET | /api/posts/{id} | - | 200, 게시글 |
| 수정 | PUT | /api/posts/{id} | {title, content, author} | 204 |
| 삭제 | DELETE | /api/posts/{id} | - | 204 |

### 요청 예시 (POST /api/posts)
```json
{
  "title": "첫 글",
  "content": "안녕하세요",
  "author": "peach99"
}
```

## 구조 & 학습 포인트
- **Entity(`Post`)**: DB 테이블과 매핑되는 객체. 외부에 직접 노출하지 않음
- **DTO(`PostRequest`/`PostResponse`)**: 요청/응답 전용 객체. Entity와 분리해 안전성·유연성 확보
- **Repository**: `JpaRepository` 상속만으로 기본 CRUD 제공
- **Service**: 비즈니스 로직 + 트랜잭션(`@Transactional`)
- **Controller**: `@RestController`로 JSON 응답, REST 규칙에 맞춘 URL/메서드 설계
