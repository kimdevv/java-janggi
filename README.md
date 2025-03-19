# java-janggi

## Position 생성
- [x] 10행 9열의 범위가 아닐 경우 예외를 던진다.

## 기물 생성
- [x] 왕을 생성한다.
- [x] 사를 생성한다.
- [x] 졸병을 생성한다.
- [x] 차를 생성한다.
- [x] 마를 생성한다.
- [x] 상을 생성한다.
- [x] 포를 생성한다.

## 기물 이동
- [ ] 왕을 이동한다.
    - [x] 직선 한 칸 이동할 수 있다.
    - [ ] 직선 한 칸 앞에 같은 편 기물이 있을 경우, 움직일 수 없다.
    - [ ] 직선 한 칸 앞에 상대 편 기물이 있을 경우, 그 기물을 제거 후 움직일 수 있다.
- [ ] 사를 이동한다.
    - [x] 직선 한 칸 이동할 수 있다.
    - [ ] 직선 한 칸 앞에 같은 편 기물이 있을 경우, 움직일 수 없다.
    - [ ] 직선 한 칸 앞에 상대 편 기물이 있을 경우, 그 기물을 제거 후 움직일 수 있다.
- [ ] 졸병을 이동한다.
    - [x] 앞, 옆으로 이동할 수 있다.
    - [ ] 앞, 옆에 같은 편 기물이 있을 경우, 움직일 수 없다.
    - [ ] 앞, 옆에 상대 편 기물이 있을 경우, 그 기물을 제거 후 움직일 수 있다.
- [ ] 차를 이동한다.
    - [x] 직선 이동경로에 다른 기물이 없는 한, 직선으로 원하는 만큼 이동할 수 있다.
    - [ ] 직선에 같은 편 기물이 있을 경우, 그 직전까지 이동할 수 있다.
    - [ ] 직선에 다른 편 기물이 있을 경우, 이동 경로 상 가장 가까운 기물을 제거 후 움직일 수 있다.
- [ ] 마를 이동한다.
    - [x] 직선 한 칸, 대각선 한 칸 이동할 수 있다.
    - [ ] 직선 이동 경로에 다른 기물이 있다면, 해당 경로로 이동할 수 없다.
    - [ ] 최종 경로에 같은 편 기물이 있는 경우, 해당 경로로 이동할 수 없다.
    - [ ] 최종 경로에 다른 편 기물이 있는 경우, 그 기물을 제거 후 움직일 수 있다.
- [ ] 상을 이동한다.
    - [x] 직선 한 칸, 대각선 두 칸 이동할 수 있다.
    - [ ] 직선 이동 경로에 다른 기물이 있다면, 해당 경로로 이동할 수 없다.
    - [ ] 직선 + 대각선 한 칸 이동 경로에 다른 기물이 있다면, 해당 경로로 이동할 수 없다.
    - [ ] 최종 경로에 같은 편 기물이 있는 경우, 해당 경로로 이동할 수 없다.
    - [ ] 최종 경로에 다른 편 기물이 있는 경우, 그 기물을 제거 후 움직일 수 있다.
- [ ] 포를 이동한다.
    - [ ] 하나의 기물을 뛰어넘을 수 있다.
        - [ ] 뛰어넘은 후 직선 상 다른 기물이 없다면, 직선 상에서 원하는 만큼 이동할 수 있다.
        - [ ] 직선 이동 경로 상 가장 가까운 상대편 기물을 제거 후 움직일 수 있다.
        - [ ] 단, 같은 포끼리는 제거할 수 없다.
    - [ ] 두 개의 기물은 뛰어넘을 수 없다.
    - [ ] 같은 포 끼리는 뛰어넘을 수 없다.

