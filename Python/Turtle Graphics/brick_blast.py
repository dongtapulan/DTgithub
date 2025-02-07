import turtle
import random

# Set up the screen
screen = turtle.Screen()
screen.title("Brick Blast Game")
screen.bgcolor("white")
screen.setup(width=800, height=600)
screen.tracer(0)

# Paddle
paddle = turtle.Turtle()
paddle.shape("square")
paddle.color("black")
paddle.shapesize(stretch_wid=1, stretch_len=5)
paddle.penup()
paddle.goto(0, -250)

# Ball
ball = turtle.Turtle()
ball.shape("circle")
ball.color("red")
ball.penup()
ball.goto(0, -200)
ball.dx = 3
ball.dy = 3

# Bricks
bricks = []
colors = ["red", "orange", "yellow", "green", "blue"]
rows, cols = 5, 10

for row in range(rows):
    for col in range(cols):
        brick = turtle.Turtle()
        brick.shape("square")
        brick.color(colors[row % len(colors)])
        brick.shapesize(stretch_wid=1, stretch_len=2)
        brick.penup()
        x = -350 + col * 75
        y = 250 - row * 30
        brick.goto(x, y)
        bricks.append(brick)

# Score
score = 0
score_display = turtle.Turtle()
score_display.color("black")
score_display.penup()
score_display.hideturtle()
score_display.goto(0, 260)
score_display.write(f"Score: {score}", align="center", font=("Courier", 24, "normal"))

# Functions to move the paddle
def paddle_left():
    x = paddle.xcor() - 20
    if x > -350:
        paddle.setx(x)

def paddle_right():
    x = paddle.xcor() + 20
    if x < 350:
        paddle.setx(x)

# Keyboard bindings
screen.listen()
screen.onkeypress(paddle_left, "Left")
screen.onkeypress(paddle_right, "Right")

# Game loop
running = True
while running:
    screen.update()

    # Move the ball
    ball.setx(ball.xcor() + ball.dx)
    ball.sety(ball.ycor() + ball.dy)

    # Ball collision with walls
    if ball.xcor() > 390 or ball.xcor() < -390:
        ball.dx *= -1

    if ball.ycor() > 290:
        ball.dy *= -1

    # Ball collision with paddle
    if (ball.ycor() > -240 and ball.ycor() < -230) and \
       (paddle.xcor() - 50 < ball.xcor() < paddle.xcor() + 50):
        ball.dy *= -1

    # Ball collision with bricks
    for brick in bricks:
        if brick.isvisible() and \
           (brick.xcor() - 37 < ball.xcor() < brick.xcor() + 37) and \
           (brick.ycor() - 10 < ball.ycor() < brick.ycor() + 10):
            ball.dy *= -1
            brick.hideturtle()
            bricks.remove(brick)
            score += 10
            score_display.clear()
            score_display.write(f"Score: {score}", align="center", font=("Courier", 24, "normal"))

    # Ball falls out of bounds
    if ball.ycor() < -300:
        running = False
        score_display.goto(0, 0)
        score_display.write("Game Over", align="center", font=("Courier", 36, "normal"))

screen.mainloop()
