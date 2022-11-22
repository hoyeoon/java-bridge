# 미션 - 다리 건너기

## 기능 목록
- [x] 다리의 길이를 입력 받는다. - InputView#readBridgeSize
- [x] 다리를 만들기 위해 0 또는 1인 임의의 수 N개(입력받은 다리 길이 값)를 뽑는다. - BridgeMaker#makeBridge
- [x] 이동할 칸(U, D)를 입력 받는다. - InputView#readMoving
- [x] 다리 건너기 결과를 보여준다. - OutputView#printMap
- [x] 게임을 다시 시도할지 여부(R, Q)를 입력 받는다. - InputView#readGameCommand
- [x] 게임 결과를 보여준다. - OutputView#printResult
- [x] 사용자가 칸을 이동할 때 사용하는 메서드를 구현한다. - BridgeGame#move
- [x] 사용자가 게임을 다시 시도할 때 사용하는 메서드를 구현한다. - BridgeGame#retry
- [x] 사용자에게 보여주는 전체 프로그램이 정상 동작되도록 구현한다. - BridgeController
### 예외 처리
- [x] 잘못된 입력입니다. - BridgeSize
- [x] 다리 길이는 3부터 20 사이의 숫자여야 합니다. - BridgeSize
- [x] 이동할 칸은 U 또는 D여야 합니다. - MovingSpace
- [x] 게임 재시작/종료 여부는 R 또는 Q여야 합니다. - GameCommand