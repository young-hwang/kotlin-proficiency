package me.coroutine

fun main() {
 // 수많은 쓰레드가 생성되는 것을 확인할 수 있으며,
 // 출퇴근 시간에 음악을 들으면서 다른 비동기 처리를 해야한다면 콜백 지옥이 발생하는 구조입니다.
 asyncGoToWork() { // thread-1
   stopMusic()
   startWork()
   asyncLeaveWork { // thread-2
     stopMusic()
   }
   asyncPlayMusic() // thread-3
 }
 asyncPlayMusic() // thread-4
 Thread.sleep(5000)
}

fun asyncGoToWork(time: () -> Unit) {
 Thread {
   println("Go to work ${Thread.currentThread().name}")
   Thread.sleep(1000)
   time.invoke()
 }.start()
}

fun asyncLeaveWork(time: () -> Unit) {
 Thread {
   println("Leave work ${Thread.currentThread().name}")
   Thread.sleep(1000)
   time.invoke()
 }.start()
}

var playMusic = false

fun asyncPlayMusic() {
 Thread {
   playMusic = true
   println("Play music ${Thread.currentThread().name}")
   while (playMusic) {
     println("Listening ${Thread.currentThread().name}")
     Thread.sleep(500)
   }
 }.start()
}

fun stopMusic() {
 playMusic = false
}

fun startWork() {
 println("Start work ${Thread.currentThread().name}")
 println("Working ${Thread.currentThread().name}")
 Thread.sleep(2000)
}