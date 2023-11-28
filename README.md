# console-paint
## v1
### 메서드 설명
- char[] **createOutline**() : 테두리를 생성하여 char 배열로 반환.
- int[] **getInput**() : 입력값을 배열로 반환. 입력값을 잘못 입력하거나, 범위가 테두리를 벗어나면 메세지 출력 후 재입력 받음.
- void **printPaint**(char[] arr) : 그림판 출력.
- void **createSquare**(int[] a, int[] b) : 좌표를 가지고 있는 int 배열 2개를 매개변수로 사각형을 만듬.

### 풀이
1. **createOutline** 메서드로 테두리가 있는 그림판을 char 배열로 반환.
2. **getInput** 메서드로 올바른 값의 두 좌표를 int 배열에 저장.
3. **createSquare** 메서드로 그림판에 사각형을 채워넣음.

### 실행결과
- 사용자에게 좌표 값을 입력 받고 테두리를 넘어서는 값, 형식에 맞지 않는 값이면 다시 입력을 받음.
- 테두리 내의 사각형을 출력하고 프로그램 종료.
