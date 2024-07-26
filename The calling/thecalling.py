import time
from threading import Thread, Lock
import sys

lock = Lock()

def animate_text(text, delay=0.1):
    with lock:
        for char in text:
            sys.stdout.write(char)
            sys.stdout.flush()
            time.sleep(delay)
        print()

def sing_lyric(lyric, delay, speed):
    time.sleep(delay)
    animate_text(lyric, speed)

def sing_song():
    lyrics = [
        ("In your heart, in your mind", 0.14),
        ("I'll stay with you for all the time", 0.12),
        ("If I could, then I would", 0.16),
        ("I'll go wherever you will go", 0.19),
        ("Way up high or down low", 0.15),
        ("I'll go wherever you will go", 0.14),
    ]
    delays = [1.0, 1.2, 3.7, 5.0, 5.2, 6.7]
    
    threads = []
    for i in range(len(lyrics)):
        lyric, speed = lyrics[i]
        t = Thread(target=sing_lyric, args=(lyric, delays[i], speed))
        threads.append(t)
        t.start()
    
    for thread in threads:
        thread.join()

if __name__ == "__main__":
    sing_song()
