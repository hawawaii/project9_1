“실습 9-1 간단 그림판 앱 만들기”에 아래의 추가 기능을 제공하라.
 

옵션메뉴 : {"선 추가”, "원 추가”, "사각형 추가"}
추가된 그림 객체를 리스트로 관리하고, 저장 부모 클래스 Shape을 상속 받은 Line, Circle, Rect 클래스를 구현하고, 리스트의 추가 객체로 사용
터치 이벤트 중 화면에서 손가락을 떼면 발생하는 MotionEvent.ACTION_UP 이벤트 발생 시 그림객체 추가
Draw 이벤트 발생시 그림객체 리스트를 모두 캔버스에 그리기
 

Github 레파지토리( 프로젝트명 : “Project9_4”)의 URL을 제출 함, url 제출이 어려운 경우 프로젝트를 zip파일로 제출 함

app/src/main/java/com/cookandroid/project9_1/MainActivity.java
app/src/main/AndroidManifest.xml
app/src/main/res/layout/activity_main.xml
