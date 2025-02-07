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
        ("Cause a picture is all that I have", 0.08),
        ("to remind me that you're never coming back", 0.07),
        ("If I picture it now, it just makes me sad", 0.08),
        ("And right now, I just wish you were here", 0.07),
        ("Don't say everything's meant to be", 0.07),
        ("Cause you know it's not what I believe", 0.07),
        ("Can't help but think that it should've been me", 0.07),
        ("In the end, I just wish you were here...", 0.07),
    ]
    delays = [0.3, 4.6, 9.0, 13.5, 17.0, 21.7, 25.8, 30.8]

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