# 헥토데이터 백엔드 개발 과제

## API
### WebFlux 
 
- 다건요청

    - localhost:8080/flux

      - default : 5
      - curl http://127.0.0.1:8080/flux
      - curl http://127.0.0.1:8080/flux?time=10

- 단건요청

    - localhost:8080/mono

        - curl http://127.0.0.1:8080/mono
  

### 게시판 CRUD

- 조회 (pageSize, pageNum)

  - curl http://127.0.0.1:8080/board?pageSize=10&pageNum=1

- 입력 (content)

  - curl -X POST -H "Content-Type: application/json" -d "{\"content\": \"ok\"}" http://127.0.0.1:8080/board

- 수정 (id, content)

  - curl -X PUT -H "Content-Type: application/json" -d "{\"id\": 31, \"content\": \"okokok\"}" http://127.0.0.1:8080/board
 
- 삭제 (id)

  - curl -X DELETE -H "Content-Type: application/json" -d "{\"id\": 31}" http://127.0.0.1:8080/board
