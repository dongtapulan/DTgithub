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
        ("Tatlong bilyon ikaw lamang ang aking gusto", 0.12),
        ("Pasensya na kung ngayon akoy di para sayo", 0.15),
        ("Tayo ay papunta na sa'ting bagong yugto", 0.16),
        ("'yokong mabuhay sa isang mundong walang tayo,", 0.15),
    ]
    delays = [2.10, 6.0, 8.0, 11.0]

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