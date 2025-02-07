import matplotlib.pyplot as plt

# Sample data
x = [1, 2, 3, 4, 5]
y = [10, 20, 25, 30, 40]

# Create a plot
plt.plot(x, y, marker='o', linestyle='-', color='b', label='Sample Data')

# Add labels and title
plt.xlabel('X-axis')
plt.ylabel('Y-axis')
plt.title('Simple Line Graph')
plt.legend()

# Display the graph
plt.show()
